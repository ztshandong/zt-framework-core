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

    public ZtResBeanExResult getResult() {
        return (ZtResBeanExResult) this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getResult());
    }

    public ZtResBeanEx() {
        this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getResult(), new ZtResBeanExResult());
    }

    public static ZtResBeanEx ok() {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccessCode());
        res.setMsg(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccessMsg());
        res.setSuccess(true);
        return res;
    }

    public static ZtResBeanEx ok(Object o) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccessCode());
        res.setMsg(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccessMsg());
        res.setData(o);
        res.setSuccess(true);
        return res;
    }

    public static ZtResBeanEx ok(String msg) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccessCode());
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
        res.setCode(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getFailCode());
        res.setMsg(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getFailMsg());
        res.setSuccess(false);
        return res;
    }

    public static ZtResBeanEx error(String msg) {
        ZtResBeanEx res = new ZtResBeanEx();
        res.setCode(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getFailCode());
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
        return (Boolean) this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccess());
    }

    public void setSuccess(Boolean success) {
        this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getSuccess(), success);
    }

    public Boolean getEmpty() {
        return (Boolean) this.getResult().get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getEmpty());
    }

    public void setEmpty(Boolean empty) {
        this.getResult().put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getEmpty(), empty);
    }

    public Integer getTotal() {
        return (Integer) this.getResult().get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getTotal());
    }

    public void setTotal(Integer total) {
        this.getResult().put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getTotal(), total);
    }

    public Object getCode() {
        return this.getResult().get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getCode());
    }

    public void setCode(String code) {
        this.getResult().put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getCode(), code);
    }

    public Object getMsg() {
        return this.getResult().get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getMsg());
    }

    public void setMsg(String msg) {
        this.getResult().put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getMsg(), msg);
    }

    public Object getData() {
        return this.getResult().get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getData());
    }

    public void setData(Object data) {
        this.getResult().put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getData(), data);
    }

    public class ZtResBeanExResult<T> extends HashMap {

        public Boolean getEmpty() {
            return (Boolean) this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getEmpty());
        }

        public void setEmpty(Boolean empty) {
            this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getEmpty(), empty);
        }

        public Integer getTotal() {
            return (Integer) this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getTotal());
        }

        public void setTotal(Integer total) {
            this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getTotal(), total);
        }

        public Object getCode() {
            return this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getCode());
        }

        public void setCode(String code) {
            this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getCode(), code);
        }

        public Object getMsg() {
            return this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getMsg());
        }

        public void setMsg(String msg) {
            this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getMsg(), msg);
        }

        public Object getData() {
            return this.get(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getData());
        }

        public void setData(Object data) {
            this.put(ZtSpringUtil.getBeanFactory().getBean(ZtResBeanExConfig.class).getData(), data);
        }
    }
}
