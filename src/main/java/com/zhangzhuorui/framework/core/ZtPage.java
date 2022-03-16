package com.zhangzhuorui.framework.core;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description : 分页查询返回数据结构
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */

import java.io.Serializable;
import java.util.List;

public class ZtPage<T> implements Serializable {

    private List<T> results;
    private Integer total;

    public ZtPage() {
    }

    public ZtPage(List<T> results, int total) {
        this.results = results;
        this.total = total;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
