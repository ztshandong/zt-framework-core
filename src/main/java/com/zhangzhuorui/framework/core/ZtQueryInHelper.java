package com.zhangzhuorui.framework.core;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate :  2021/10/4 下午7:31
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtQueryInHelper {

    /**
     * SQL 的 IN 查询条件的最终数据
     */
    private String inSqlStr;

    public String getInSqlStr() {
        return inSqlStr;
    }

    public void setInSqlStr(String inSqlStr) {
        this.inSqlStr = inSqlStr;
    }
}
