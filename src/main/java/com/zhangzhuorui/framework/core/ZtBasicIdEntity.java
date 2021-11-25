package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate :  2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtBasicIdEntity<T extends Serializable> implements Serializable {

    private T id;

    @ApiModelProperty(value = "主键(自增主键新增不用传)", example = "1")
    @JsonProperty(value = "id")
    @JSONField(name = "id")
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

}
