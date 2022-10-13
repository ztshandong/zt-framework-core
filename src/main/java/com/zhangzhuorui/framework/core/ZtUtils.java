package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.Collator;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public final static Comparator<Object> COMPARATOR = Collator.getInstance(Locale.CHINESE);
    final static String patterNumStr = "^\\d*";
    final static String patterNaNStr = "^\\D*";

    final static Pattern patterNum = Pattern.compile(patterNumStr);
    final static Pattern patterNan = Pattern.compile(patterNaNStr);

    public static int comparePlus(String str1, String str2) {
        if (Objects.equals(str1, str2)) {
            return 0;
        }
        if (StringUtils.isEmpty(str1)) {
            return -1;
        } else if (StringUtils.isEmpty(str2)) {
            return 1;
        }
        int int1 = -1;
        int int2 = -1;

        Matcher matchNum1 = patterNum.matcher(str1);
        if (matchNum1.find()) {
            String group1 = matchNum1.group();
            if (!StringUtils.isEmpty(group1)) {
                int1 = Integer.parseInt(group1);
            }
        }
        Matcher matchNum2 = patterNum.matcher(str2);
        if (matchNum2.find()) {
            String group2 = matchNum2.group();
            if (!StringUtils.isEmpty(group2)) {
                int2 = Integer.parseInt(group2);
            }
        }

        // 数字优先
        if ((int1 > 0) && (int2 == -1)) {
            return -1;
        }
        if ((int2 > 0) && (int1 == -1)) {
            return 1;
        }
        if (int1 == int2) {
            str1 = str1.substring(String.valueOf(int1).length());
            str2 = str2.substring(String.valueOf(int2).length());
            String s1 = "";
            String s2 = "";
            Matcher matchNan1 = patterNan.matcher(str1);
            Matcher matchNan2 = patterNan.matcher(str2);
            if (matchNan1.find()) {
                s1 = matchNan1.group();
            }
            if (matchNan2.find()) {
                s2 = matchNan2.group();
            }
            if (!Objects.equals(s1, s2)) {
                return COMPARATOR.compare(s1, s2);
            } else {
                str1 = str1.substring(s1.length());
                str2 = str2.substring(s2.length());
                return comparePlus(str1, str2);
            }
        }
        return int1 - int2;

    }

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

    public static boolean isEmptyList(List list) {
        if (list == null) {
            return true;
        } else {
            return list.isEmpty();
        }
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
