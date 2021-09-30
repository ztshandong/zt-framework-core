package com.zhangzhuorui.framework.core;

import com.sun.tracing.dtrace.ModuleName;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
@Configuration
public class ZtSpringUtil implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    public static BeanFactory beanFactory;

    public static ApplicationContext applicationContext;

    private static Set<Class<?>> allClasses = new HashSet<>();

    public static Set<Class<?>> getAllClasses() {
        return allClasses;
    }

    private static Map<String, List<ZtEnumInfoEntity>> enumInfoMap;

    public static List<ZtEnumInfoEntity> getEnumInfo(String enumName) {
        return enumInfoMap.get(enumName);
    }

    private static TreeMap<String, String> enumName;

    public static TreeMap<String, String> getEnumName() {
        if (enumName == null || enumInfoMap == null) {
            initEnumInfos();
        }
        return enumName;
    }

    private static String springBootApplicationPackageName;

    public static String getSpringBootApplicationPackageName() {
        return springBootApplicationPackageName;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        beanFactory = configurableListableBeanFactory;
    }

    public static BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public static <T> T getBean(String name) {
        return (T) beanFactory.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return beanFactory.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return beanFactory.getBean(name, clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ZtSpringUtil.applicationContext = applicationContext;
    }

    private synchronized static void initEnumInfos() {
        if (enumName == null || enumInfoMap == null) {
            enumName = new TreeMap<>();
            enumInfoMap = new HashMap<>();
            Set<String> scanPackages = new HashSet<>();

            Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(ComponentScan.class);
            Class<? extends Object> clazz = null;
            for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
                clazz = entry.getValue().getClass();
                if (clazz.getName().contains("spring")) {
                    continue;
                }
                ComponentScan annotation = clazz.getAnnotation(ComponentScan.class);
                if (annotation != null) {
                    String[] strings = annotation.basePackages();
                    scanPackages.addAll(Arrays.asList(strings));
                    System.out.println();
                }
            }
            Map<String, Object> beansWithAnnotation1 = applicationContext.getBeansWithAnnotation(SpringBootApplication.class);
            for (Map.Entry<String, Object> entry : beansWithAnnotation1.entrySet()) {
                clazz = entry.getValue().getClass();
                String name = clazz.getPackage().getName();
                springBootApplicationPackageName = name;
                scanPackages.add(name);
            }

            try {
                for (String scanPackage : scanPackages) {
                    allClasses.addAll(ZtClassUtils.getClassSet(scanPackage));
                }

                for (Class<?> aClass : allClasses) {
                    if (!aClass.isEnum()) {
                        continue;
                    }
                    Class<?>[] enumInterfaces = aClass.getInterfaces();
                    List<Class<?>> tmp = new ArrayList<Class<?>>(Arrays.asList(enumInterfaces));
                    if (!tmp.contains(IZtBaseEnum.class)) {
                        continue;
                    }
                    Method getName = aClass.getMethod("name");
                    Method getIntValue = aClass.getMethod("getIntValue");
                    Method getStrValue = aClass.getMethod("getStrValue");
                    Object[] enumConstants = aClass.getEnumConstants();
                    List<ZtEnumInfoEntity> ztEnumInfoEntityList = new LinkedList<>();
                    for (Object enumConstant : enumConstants) {
                        ZtEnumInfoEntity ztEnumInfoEntity = new ZtEnumInfoEntity();
                        ztEnumInfoEntity.setValue(getName.invoke(enumConstant).toString());
                        ztEnumInfoEntity.setLabel(getStrValue.invoke(enumConstant).toString());
                        ztEnumInfoEntity.setEnumIntValue(Integer.valueOf(getIntValue.invoke(enumConstant).toString()));
                        ztEnumInfoEntityList.add(ztEnumInfoEntity);
                    }
                    enumInfoMap.put(aClass.getSimpleName(), ztEnumInfoEntityList);
                    ModuleName annotation = aClass.getAnnotation(ModuleName.class);
                    String des = aClass.getSimpleName();
                    if (annotation != null) {
                        des = annotation.value();
                    }
                    enumName.put(aClass.getSimpleName(), des);
                }
            } catch (Exception e) {

            }
        }
    }

    public static Object getOriginBean(Object bean) throws Exception {
        if (AopUtils.isJdkDynamicProxy(bean)) {
            Object jdk = getJdkDynamicProxyTargetObject(bean);
            System.out.println();
            return jdk;
        } else { //cglib
            Object cglib = getCglibProxyTargetObject(bean);
            System.out.println();
            return cglib;
        }
    }

    public static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);

        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();

        return target;
    }

    public static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);

        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();

        return target;
    }

}




