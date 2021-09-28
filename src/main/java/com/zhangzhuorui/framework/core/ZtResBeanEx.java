package com.zhangzhuorui.framework.core;

import java.util.HashMap;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description : 返回给前端的数据
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtResBeanEx<T> extends HashMap {

    public static ZtResBeanEx ok() {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtStrUtils.SUCCESS_CODE);
        res.setMsg(ZtStrUtils.SUCCESS_MSG);
        res.setSuccess(true);
        return res;
    }

    public static ZtResBeanEx ok(Object o) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtStrUtils.SUCCESS_CODE);
        res.setMsg(ZtStrUtils.SUCCESS_MSG);
        res.setData(o);
        res.setSuccess(true);
        return res;
    }

    public static ZtResBeanEx ok(String msg) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtStrUtils.SUCCESS_CODE);
        res.setMsg(msg);
        res.setSuccess(true);
        return res;
    }

    public static ZtResBeanEx ok(String code, String msg) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(code);
        res.setMsg(msg);
        res.setSuccess(true);
        return res;
    }

    public static ZtResBeanEx error() {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtStrUtils.FAIL_CODE);
        res.setMsg(ZtStrUtils.FAIL_MSG);
        res.setSuccess(false);
        return res;
    }

    public static ZtResBeanEx error(String msg) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtStrUtils.FAIL_CODE);
        res.setMsg(msg);
        res.setSuccess(false);
        return res;
    }

    public static ZtResBeanEx error(String code, String msg) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(code);
        res.setMsg(msg);
        res.setSuccess(false);
        return res;
    }

    public Boolean getSuccess() {
        return (Boolean) this.get(ZtStrUtils.SUCCESS);
    }

    public void setSuccess(Boolean success) {
        this.put(ZtStrUtils.SUCCESS, success);
    }

    public Boolean getEmpty() {
        return (Boolean) this.get(ZtStrUtils.EMPTY);
    }

    public void setEmpty(Boolean empty) {
        this.put(ZtStrUtils.EMPTY, empty);
    }

    public Integer getTotal() {
        return (Integer) this.get(ZtStrUtils.TOTAL);
    }

    public void setTotal(Integer total) {
        this.put(ZtStrUtils.TOTAL, total);
    }

    public Object getCode() {
        return this.get(ZtStrUtils.CODE);
    }

    public void setCode(String code) {
        this.put(ZtStrUtils.CODE, code);
    }

    public Object getMsg() {
        return this.get(ZtStrUtils.MSG);
    }

    public void setMsg(String msg) {
        this.put(ZtStrUtils.MSG, msg);
    }

    public Object getData() {
        return this.get(ZtStrUtils.DATA);
    }

    public void setData(Object data) {
        this.put(ZtStrUtils.DATA, data);
    }
}
