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
// @ModuleName("SQL条件结合类型")
@ApiModel(value = "SQL条件结合类型", description = "SQL条件结合类型")
public enum ZtQueryTypeEnum implements IZtBaseEnum<ZtQueryTypeEnum> {

    AND(1, "AND"),
    OR(2, "OR"),
    ;

    private final Integer intValue;

    private final String strValue;

    ZtQueryTypeEnum(Integer intValue, String strValue) {
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
