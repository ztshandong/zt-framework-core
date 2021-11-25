package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate :  2017-01-01
 * @description : 返回给前端的数据(为了swagger显示)
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtResBeanExObj4Swagger {

    Boolean success;

    ZtResBeanExResultObj4Swagger result;

    @ApiModelProperty(value = "执行结果", example = "true")
    @JsonProperty(value = "success")
    @JSONField(name = "success")
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @ApiModelProperty(value = "返回的数据")
    @JsonProperty(value = "result")
    @JSONField(name = "result")
    public ZtResBeanExResultObj4Swagger getResult() {
        return result;
    }

    public void setResult(ZtResBeanExResultObj4Swagger result) {
        this.result = result;
    }

    static class ZtResBeanExResultObj4Swagger {

        String errCode;

        String errMsg;

        Boolean empty;

        ZtBasicNumberIdEntity4Swagger data;

        @ApiModelProperty(value = "0代表正常(可能是字符串也可能是数值类型)，其余代表有错误", example = "0")
        @JsonProperty(value = "errCode")
        @JSONField(name = "errCode")
        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        @ApiModelProperty(value = "返回结果描述", example = "操作成功")
        @JsonProperty(value = "errMsg")
        @JSONField(name = "errMsg")
        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        @ApiModelProperty(value = "查询结果是否为空", example = "true")
        @JsonProperty(value = "empty")
        @JSONField(name = "empty")
        public Boolean getEmpty() {
            return empty;
        }

        public void setEmpty(Boolean empty) {
            this.empty = empty;
        }

        @ApiModelProperty(value = "返回对象时的数据结构。例如根据id获取详情接口selectIdSimple")
        @JsonProperty(value = "data")
        @JSONField(name = "data")
        public ZtBasicNumberIdEntity4Swagger getData() {
            return data;
        }

        public void setData(ZtBasicNumberIdEntity4Swagger data) {
            this.data = data;
        }

    }
}
