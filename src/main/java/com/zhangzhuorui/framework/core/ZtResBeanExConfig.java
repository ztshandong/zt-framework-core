package com.zhangzhuorui.framework.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate :  2021/11/18 上午9:19
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
@Configuration
@ConfigurationProperties(prefix = "resbean.config")
public class ZtResBeanExConfig {

    private String code = "code";
    private String empty = "empty";
    private String total = "total";
    private String msg = "message";
    private String data = "data";
    private String success = "success";
    private String successCode = "200";
    private String successMsg = "操作成功";
    private String failCode = "-1";
    private String failMsg = "操作失败，请刷新页面，获取最新数据后重试";
    private String start = "1";//start  current
    private String limit = "20";//limit  size
    private String maxPage = "1000";//默认最大每页1000条

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmpty() {
        return empty;
    }

    public void setEmpty(String empty) {
        this.empty = empty;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(String maxPage) {
        this.maxPage = maxPage;
    }
}
