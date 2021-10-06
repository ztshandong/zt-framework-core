package com.zhangzhuorui.framework.core;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtStrUtils {

    //region 返回的状态码
    public static final String CODE = "code";
    public static final String EMPTY = "empty";
    public static final String TOTAL = "total";
    public static final String MSG = "message";
    public static final String DATA = "data";
    public static final String SUCCESS = "success";
    public static final String SUCCESS_CODE = "OK";
    public static final String SUCCESS_MSG = "操作成功";
    public static final String FAIL_CODE = "FAIL";
    public static final String FAIL_MSG = "操作失败，请刷新页面，获取最新数据后重试";
    //endregion

    public static final String ID_FIELD_NAME = "id";
    public static final String ID_COLUMN_NAME = "id";
    public static final String VERSION_FIELD_NAME = "version";
    public static final String VERSION_COLUMN_NAME = "version";

    //region 增删改查api
    public static final String DELEMITER = "/";
    public static final String GET_ENUM_NAME = DELEMITER + "getEnumName";
    public static final String GET_ENUM_INFO = DELEMITER + "getEnumInfo";
    public static final String SELECT_SIMPLE = DELEMITER + "selectSimple";
    public static final String SELECT_SIMPLE_ALL = DELEMITER + "selectSimpleAll";
    public static final String SELECT_ID_SIMPLE = DELEMITER + "selectIdSimple";
    public static final String INSERT_SIMPLE = DELEMITER + "insertSimple";
    public static final String UPDATE_SIMPLE = DELEMITER + "updateSimple";
    public static final String DELETE_SIMPLE = DELEMITER + "deleteSimple";
    public static final String INSERT_BATCH_SIMPLE = DELEMITER + "insertBatchSimple";
    public static final String DELETE_BATCH_SIMPLE = DELEMITER + "deleteBatchSimple";

    public static final String REFRESH_CACHE = DELEMITER + "refresh";
    public static final String REFRESH_CACHE_BY_NAME = DELEMITER + "refreshByName";
    public static final String REFRESH_CACHE_BY_CUR_USER_ID = DELEMITER + "refreshCacheByCurUserId";
    //endregion

    //默认分页信息
    public static final String START = "1";//start  current
    public static final String LIMIT = "20";//limit  size
    public static final String MAX_PAGE = "1000";//默认最大每页1000条
    public static final Integer NO_COUNT = -1;

    public static final String FALSE_SQL = " NULL AND NOT NULL ";

}
