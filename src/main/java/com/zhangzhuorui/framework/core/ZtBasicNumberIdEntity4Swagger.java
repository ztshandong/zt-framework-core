package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate :  2017-01-01
 * @description : swagger生成文档使用
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtBasicNumberIdEntity4Swagger {

    private long id;

    @ApiModelProperty(value = "主键(自增主键新增不用传)", example = "1")
    @JsonProperty(value = "id")
    @JSONField(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
