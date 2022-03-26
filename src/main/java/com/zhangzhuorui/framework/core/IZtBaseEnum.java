package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
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
public interface IZtBaseEnum<E extends Enum<E>> extends IZtSimpleBaseEnum<E> {

    Integer getIntValue();

    static <T extends Enum<T> & IZtBaseEnum<T>> IZtBaseEnum<T> getIZtBaseEnumByIntValue(Class<T> opEnumType, Integer intValue) {
        T[] enumConstants = opEnumType.getEnumConstants();
        System.out.println(JSON.toJSONString(enumConstants));
        Optional<T> any = Arrays.stream(enumConstants).filter(t -> t.getIntValue().equals(intValue)).findAny();
        return any.orElse(null);
    }
}
