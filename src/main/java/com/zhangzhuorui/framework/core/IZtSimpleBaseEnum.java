package com.zhangzhuorui.framework.core;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author :  zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public interface IZtSimpleBaseEnum<T extends Enum<T>> {

    public String getStrValue();

    public static <T extends Enum<T> & IZtSimpleBaseEnum<T>> IZtSimpleBaseEnum<T> getIZtBaseEnumByStrValue(Class<T> opEnumType, String strValue) {
        T[] enumConstants = opEnumType.getEnumConstants();
        Optional<T> any = Arrays.stream(enumConstants).filter(t -> t.getStrValue().equals(strValue)).findAny();
        return any.orElse(null);
    }

}
