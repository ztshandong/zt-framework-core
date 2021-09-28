package com.zhangzhuorui.framework.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
// @ApiModel(value = "查询或更新的条件", description = "查询或更新的条件")
public class ZtQueryConditionEntity implements Serializable {

    //数据库列名
    private String columnName;

    //java字段名
    private String fieldName;

    private ZtQueryTypeEnum queryType = ZtQueryTypeEnum.AND;

    private ZtQueryWrapperEnum queryWrapper = ZtQueryWrapperEnum.EQUALS;

    //IN查询条件用。可能是list，也可能是ZtQueryWrapper
    private Object list;

    //BETWEEN查询
    private Object betweenStart;

    //BETWEEN查询
    private Object betweenEnd;

    //UPDATE语句是否使用原生SQL
    private Boolean updateFieldUseNativeSql = false;

    //例如 SET num = ( num - lockNum )
    private String updateFieldNativeSql;

    // @ApiModelProperty(value = "数据库字段名")
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    // @ApiModelProperty(value = "java字段名")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    // @ApiModelProperty(value = "查询方式 AND OR")
    public ZtQueryTypeEnum getQueryType() {
        return queryType;
    }

    public void setQueryType(ZtQueryTypeEnum queryType) {
        this.queryType = queryType;
    }

    // @ApiModelProperty(value = "查询条件 = <> > < LIKE IN 等等")
    public ZtQueryWrapperEnum getQueryWrapper() {
        return queryWrapper;
    }

    public void setQueryWrapper(ZtQueryWrapperEnum queryWrapper) {
        this.queryWrapper = queryWrapper;
    }

    // @ApiModelProperty(value = "IN 或 NOT IN 范围查询的值")
    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    // @ApiModelProperty(value = "BETWEEN开始值")
    public Object getBetweenStart() {
        return betweenStart;
    }

    public void setBetweenStart(Object betweenStart) {
        this.betweenStart = betweenStart;
    }

    // @ApiModelProperty(value = "BETWEEN结束值")
    public Object getBetweenEnd() {
        return betweenEnd;
    }

    public void setBetweenEnd(Object betweenEnd) {
        this.betweenEnd = betweenEnd;
    }

    public Boolean getUpdateFieldUseNativeSql() {
        return updateFieldUseNativeSql;
    }

    public void setUpdateFieldUseNativeSql(Boolean updateFieldUseNativeSql) {
        this.updateFieldUseNativeSql = updateFieldUseNativeSql;
    }

    public String getUpdateFieldNativeSql() {
        return updateFieldNativeSql;
    }

    public void setUpdateFieldNativeSql(String updateFieldNativeSql) {
        this.updateFieldNativeSql = updateFieldNativeSql;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ZtQueryConditionEntity)) {
            return false;
        }
        ZtQueryConditionEntity that = (ZtQueryConditionEntity) o;
        return getColumnName().equals(that.getColumnName()) &&
                getFieldName().equals(that.getFieldName()) &&
                getQueryType() == that.getQueryType() &&
                getQueryWrapper() == that.getQueryWrapper() &&
                getList().equals(that.getList()) &&
                getBetweenStart().equals(that.getBetweenStart()) &&
                getUpdateFieldUseNativeSql().equals(that.getUpdateFieldUseNativeSql()) &&
                getUpdateFieldNativeSql().equals(that.getUpdateFieldNativeSql()) &&
                getBetweenEnd().equals(that.getBetweenEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumnName(), getFieldName(), getQueryType(), getQueryWrapper(), getList(), getBetweenStart(), getUpdateFieldUseNativeSql(), getUpdateFieldNativeSql(), getBetweenEnd());
    }
}
