package com.zhangzhuorui.framework.core;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtEnumInfoEntity {
    //枚举name()
    private String value;
    //enumStrValue
    private String label;
    //严格来讲，后台应该存int
    private Integer enumIntValue;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getEnumIntValue() {
        return enumIntValue;
    }

    public void setEnumIntValue(Integer enumIntValue) {
        this.enumIntValue = enumIntValue;
    }
}
