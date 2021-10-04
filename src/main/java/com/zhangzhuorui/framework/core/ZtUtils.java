package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtUtils {

    public static final DateTimeFormatter SHORT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
    public static final DateTimeFormatter LONG_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static Date getEarliestTimeOfTheDay(Date date) {
        return getTimeOfTheDay(date, true);
    }

    public static Date getLatestTimeOfTheDay(Date date) {
        return getTimeOfTheDay(date, false);
    }

    public static Date getTimeOfTheDay(Date date, boolean isEarliest) {
        Date res = null;
        LocalDateTime localDateTime = null;
        if (isEarliest) {
            localDateTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        } else {
            localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        }
        res = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return res;
    }

    public static Field getField(Object obj, String fieldName) {
        List<Field> fields = getFields(obj);
        Optional<Field> any = fields.stream().filter(t -> t.getName().equals(fieldName)).findAny();
        return any.orElse(null);
    }

    /**
     * @param obj :
     * @return :  java.util.List<java.lang.reflect.Field>
     * @author :  zhangtao
     * @createDate :  2021/9/23 下午12:29
     * @description :  获取所有字段
     * @updateUser :
     * @updateDate :
     * @updateRemark :
     */
    public static List<Field> getFields(Object obj) {
        List<Field> fieldList = new ArrayList<>();
        Class tempClass = obj.getClass();
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
        }
        return fieldList;
    }

    public static String getSqlInStr(List<String> list) {
        String str = JSON.toJSONString(list).replace("\"", "'").replace("[", "").replace("]", "").replace(" ", "");
        if (StringUtils.isEmpty(str)) {
            str = ZtStrUtils.FALSE_SQL;
        }
        return str;
    }
}