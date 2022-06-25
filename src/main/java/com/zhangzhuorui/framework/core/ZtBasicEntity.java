package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtBasicEntity<T extends Serializable> extends ZtBasicIdEntity<T> {

    private Date gmtCreate;

    private String createdBy;

    private String createdByName;

    private Date gmtUpdate;

    private String updatedBy;

    private String updatedByName;

    private String remark;

    //------------分割线以下的字段数据库不存在

    private Boolean dataScopeFlag;

    private Object queryHelper;

    private Object otherParams;

    private List otherListParams;

    //------------查询接口专用参数

    private Date queryStartTime;

    private Date queryEndTime;

    private Date queryStartDate;

    private Date queryEndDate;

    private Long start;

    private Long limit;

    private String orderBy;

    private Boolean ascFlag;

    @ApiModelProperty(value = "创建时间(不用传,后台自动生成)", example = "1982-10-24 20:48:00", position = 1000)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "gmtCreate")
    @JSONField(name = "gmtCreate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date getGmtCreate() {
        return gmtCreate;
    }

    @JsonDeserialize(using = ZtDateDeserializer.class)
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @ApiModelProperty(value = "创建人账号(不用传,根据token获取)", example = "zhangsan", position = 1100)
    @JsonProperty(value = "createdBy")
    @JSONField(name = "createdBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @ApiModelProperty(value = "创建人姓名(不用传,根据token获取)", example = "张三", position = 1200)
    @JsonProperty(value = "createdByName")
    @JSONField(name = "createdByName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    @ApiModelProperty(value = "单据修改时间(不用传,后台自动生成)", example = "1982-10-24 20:48:00", position = 1300)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "gmtUpdate")
    @JSONField(name = "gmtUpdate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    @JsonDeserialize(using = ZtDateDeserializer.class)
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @ApiModelProperty(value = "修改人账号(不用传,根据token获取)", example = "zhangsan", position = 1400)
    @JsonProperty(value = "updatedBy")
    @JSONField(name = "updatedBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @ApiModelProperty(value = "修改人姓名(不用传,根据token获取)", example = "张三", position = 1500)
    @JsonProperty(value = "updatedByName")
    @JSONField(name = "updatedByName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    @ApiModelProperty(value = "备注", example = "天行健，君子以自强不息", position = 1600)
    @JsonProperty(value = "remark")
    @JSONField(name = "remark")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 是否需要添加数据权限的控制。这个不能由前端控制，所以序列化忽略
     *
     * @return
     */
    @ApiIgnore
    @JsonIgnore
    @JSONField(serialize = false)
    public Boolean getDataScopeFlag() {
        return dataScopeFlag;
    }

    public void setDataScopeFlag(Boolean dataScopeFlag) {
        this.dataScopeFlag = dataScopeFlag;
    }

    @ApiModelProperty(value = "不同的界面，可以返回不同的字段。优化用，默认返回所有字段", example = "user/index", position = 2000)
    @JsonProperty(value = "queryHelper")
    @JSONField(name = "queryHelper")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object getQueryHelper() {
        return queryHelper;
    }

    public void setQueryHelper(Object queryHelper) {
        this.queryHelper = queryHelper;
    }

    @ApiModelProperty(value = "备用对象参数，前后端交互使用。(一般不用)", example = "{}", position = 2100)
    @JsonProperty(value = "otherParams")
    @JSONField(name = "otherParams")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object getOtherParams() {
        return otherParams;
    }

    public void setOtherParams(Object otherParams) {
        this.otherParams = otherParams;
    }

    @ApiModelProperty(value = "备用数组参数，前后端交互使用。(一般不用)", example = "[]", position = 2200)
    @JsonProperty(value = "otherListParams")
    @JSONField(name = "otherListParams")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List getOtherListParams() {
        return otherListParams;
    }

    public void setOtherListParams(List otherListParams) {
        this.otherListParams = otherListParams;
    }

    @ApiModelProperty(value = "查询接口专用参数:当前页(分页查询条件)", example = "1", position = 3000)
    @JsonProperty(value = "start")
    @JSONField(name = "start")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    @ApiModelProperty(value = "查询接口专用参数:每页大小(分页查询条件)", example = "30", position = 3100)
    @JsonProperty(value = "limit")
    @JSONField(name = "limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @ApiModelProperty(value = "查询接口专用参数:排序列(查询条件)", example = "age", position = 3200)
    @JsonProperty(value = "orderBy")
    @JSONField(name = "orderBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @ApiModelProperty(value = "查询接口专用参数:排序列的排序方向(查询条件)(true:升序;false:降序)默认true", example = "true", position = 3300)
    @JsonProperty(value = "ascFlag")
    @JSONField(name = "ascFlag")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAscFlag() {
        return ascFlag;
    }

    public void setAscFlag(Boolean ascFlag) {
        this.ascFlag = ascFlag;
    }

    @ApiModelProperty(value = "查询接口专用参数:开始时间(查询条件，时间格式，精确到秒 yyyy-MM-dd HH:mm:ss)", example = "1982-10-24 20:48:00", position = 3400)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "queryStartTime")
    @JSONField(name = "queryStartTime", format = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date getQueryStartTime() {
        return queryStartTime;
    }

    @JsonDeserialize(using = ZtDateDeserializer.class)
    public void setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    @ApiModelProperty(value = "查询接口专用参数:结束时间(查询条件，时间格式，精确到秒 yyyy-MM-dd HH:mm:ss)", example = "1982-10-24 20:48:00", position = 3500)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "queryEndTime")
    @JSONField(name = "queryEndTime", format = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date getQueryEndTime() {
        return queryEndTime;
    }

    @JsonDeserialize(using = ZtDateDeserializer.class)
    public void setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    @ApiModelProperty(value = "查询接口专用参数:开始日期(查询条件，日期格式 yyyy-MM-dd)", example = "1982-10-24", position = 3600)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonProperty(value = "queryStartDate")
    @JSONField(name = "queryStartDate", format = "yyyy-MM-dd")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date getQueryStartDate() {
        return queryStartDate;
    }

    @JsonDeserialize(using = ZtDateDeserializer.class)
    public void setQueryStartDate(Date queryStartDate) {
        this.queryStartDate = queryStartDate;
    }

    @ApiModelProperty(value = "查询接口专用参数:结束日期(查询条件，日期格式 yyyy-MM-dd)", example = "1982-10-24", position = 3700)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonProperty(value = "queryEndDate")
    @JSONField(name = "queryEndDate", format = "yyyy-MM-dd")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date getQueryEndDate() {
        return queryEndDate;
    }

    @JsonDeserialize(using = ZtDateDeserializer.class)
    public void setQueryEndDate(Date queryEndDate) {
        this.queryEndDate = queryEndDate;
    }
}
