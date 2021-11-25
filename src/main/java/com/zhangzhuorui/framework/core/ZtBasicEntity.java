package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private Date startTime;

    private Date endTime;

    private Date startDate;

    private Date endDate;

    private Long start;

    private Long limit;

    private String orderBy;

    private Boolean ascFlag;

    @ApiModelProperty(value = "创建时间(不用传,后台自动生成)", example = "1982-10-24 20:48:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "gmtCreate")
    @JSONField(name = "gmtCreate", format = "yyyy-MM-dd HH:mm:ss")
    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @ApiModelProperty(value = "创建人账号(不用传,根据token获取)", example = "zhangsan")
    @JsonProperty(value = "createdBy")
    @JSONField(name = "createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @ApiModelProperty(value = "创建人姓名(不用传,根据token获取)", example = "张三")
    @JsonProperty(value = "createdByName")
    @JSONField(name = "createdByName")
    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    @ApiModelProperty(value = "单据修改时间(不用传,后台自动生成)", example = "1982-10-24 20:48:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "gmtUpdate")
    @JSONField(name = "gmtUpdate", format = "yyyy-MM-dd HH:mm:ss")
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @ApiModelProperty(value = "修改人账号(不用传,根据token获取)", example = "zhangsan")
    @JsonProperty(value = "updatedBy")
    @JSONField(name = "updatedBy")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @ApiModelProperty(value = "修改人姓名(不用传,根据token获取)", example = "张三")
    @JsonProperty(value = "updatedByName")
    @JSONField(name = "updatedByName")
    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    @ApiModelProperty(value = "备注", example = "天行健，君子以自强不息")
    @JsonProperty(value = "remark")
    @JSONField(name = "remark")
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

    @ApiModelProperty(value = "不同的界面，可以返回不同的字段。优化用，默认返回所有字段", example = "user/index")
    @JsonProperty(value = "queryHelper")
    @JSONField(name = "queryHelper")
    public Object getQueryHelper() {
        return queryHelper;
    }

    public void setQueryHelper(Object queryHelper) {
        this.queryHelper = queryHelper;
    }

    @ApiModelProperty(value = "备用对象参数，前后端交互使用。(一般不用)", example = "{}")
    @JsonProperty(value = "otherParams")
    @JSONField(name = "otherParams")
    public Object getOtherParams() {
        return otherParams;
    }

    public void setOtherParams(Object otherParams) {
        this.otherParams = otherParams;
    }

    @ApiModelProperty(value = "备用数组参数，前后端交互使用。(一般不用)", example = "[]")
    @JsonProperty(value = "otherListParams")
    @JSONField(name = "otherListParams")
    public List getOtherListParams() {
        return otherListParams;
    }

    public void setOtherListParams(List otherListParams) {
        this.otherListParams = otherListParams;
    }

    @ApiModelProperty(value = "查询接口专用参数:当前页(分页查询条件)", example = "1")
    @JsonProperty(value = "start")
    @JSONField(name = "start")
    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    @ApiModelProperty(value = "查询接口专用参数:每页大小(分页查询条件)", example = "30")
    @JsonProperty(value = "limit")
    @JSONField(name = "limit")
    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @ApiModelProperty(value = "查询接口专用参数:排序列(查询条件)", example = "age")
    @JsonProperty(value = "orderBy")
    @JSONField(name = "orderBy")
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @ApiModelProperty(value = "查询接口专用参数:排序列的排序方向(查询条件)(true:升序;false:降序)默认true", example = "true")
    @JsonProperty(value = "ascFlag")
    @JSONField(name = "ascFlag")
    public Boolean getAscFlag() {
        return ascFlag;
    }

    public void setAscFlag(Boolean ascFlag) {
        this.ascFlag = ascFlag;
    }

    @ApiModelProperty(value = "查询接口专用参数:开始时间(查询条件，时间格式，精确到秒 yyyy-MM-dd HH:mm:ss)", example = "1982-10-24 20:48:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "startTime")
    @JSONField(name = "startTime", format = "yyyy-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @ApiModelProperty(value = "查询接口专用参数:结束时间(查询条件，时间格式，精确到秒 yyyy-MM-dd HH:mm:ss)", example = "1982-10-24 20:48:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty(value = "endTime")
    @JSONField(name = "endTime", format = "yyyy-MM-dd HH:mm:ss")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @ApiModelProperty(value = "查询接口专用参数:开始日期(查询条件，日期格式 yyyy-MM-dd)", example = "1982-10-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonProperty(value = "startDate")
    @JSONField(name = "startDate", format = "yyyy-MM-dd")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @ApiModelProperty(value = "查询接口专用参数:结束日期(查询条件，日期格式 yyyy-MM-dd)", example = "1982-10-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonProperty(value = "endDate")
    @JSONField(name = "endDate", format = "yyyy-MM-dd")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
