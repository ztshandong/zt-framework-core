package com.zhangzhuorui.framework.core;

import io.swagger.annotations.ApiModel;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
// @ModuleName("SQL查询符号")
@ApiModel(value = "SQL查询符号", description = "SQL查询符号")
public enum ZtQueryWrapperEnum implements IZtBaseEnum<ZtQueryWrapperEnum> {
    EQUALS(1, "="),
    NOT_EQUALS(2, "<>"),
    LIKE(3, "LIKE"),
    NOT_LIKE(4, "NOT LIKE"),
    IN(5, "IN"),
    NOT_IN(6, "NOT IN"),
    GREAT_THAN(7, ">"),
    LESS_THAN(8, "<"),
    GREAT_EQUALS(9, ">="),
    LESS_EQUALS(10, "<="),
    BETWEEN(11, "BETWEEN"),
    NOT_BETWEEN(12, "NOT BETWEEN"),
    IS_NULL(13, "IS NULL"),
    IS_NOT_NULL(14, "IS NOT NULL"),
    ;

    private final Integer intValue;

    private final String strValue;

    ZtQueryWrapperEnum(Integer intValue, String strValue) {
        this.intValue = intValue;
        this.strValue = strValue;
    }

    @Override
    public Integer getIntValue() {
        return intValue;
    }

    @Override
    public String getStrValue() {
        return strValue;
    }
}
