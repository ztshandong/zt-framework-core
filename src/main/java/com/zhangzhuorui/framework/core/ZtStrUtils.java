package com.zhangzhuorui.framework.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    //使用配置文件
    //region 返回的状态码
    // public static final String CODE = "code";
    // public static final String EMPTY = "empty";
    // public static final String TOTAL = "total";
    // public static final String MSG = "message";
    // public static final String DATA = "data";
    // public static final String SUCCESS = "success";
    // public static final String SUCCESS_CODE = "200";
    // public static final String SUCCESS_MSG = "操作成功";
    // public static final String FAIL_CODE = "-1";
    // public static final String FAIL_MSG = "操作失败，请刷新页面，获取最新数据后重试";
    //endregion

    //默认分页信息
    // public static final String START = "1";//start  current
    // public static final String LIMIT = "20";//limit  size
    // public static final String MAX_PAGE = "1000";//默认最大每页1000条
    public static final Integer NO_COUNT = -1;

    public static final String ID_FIELD_NAME = "id";
    public static final String ID_COLUMN_NAME = "id";
    public static final String VERSION_FIELD_NAME = "version";
    public static final String VERSION_COLUMN_NAME = "version";

    //快速组装 IN ( ? ) 的SQL。字段名后缀如果是这个，就会用IN
    public static final String LIST_VALUE_SUFFIX = "ListValue";

    //region swagger相关

    public static final String NORMAL_RES_SWAGGER_HTML = "<font color=\"#FF0000\">项目统一返回格式<br/>{<br/>" +
            "\b \b \b \b \"result\":\b \b <br/>" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b {},<br/>" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b \"0\",<br/>" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"操作成功\"<br/>" +
            "\b \b \b \b },<br/>" +
            "\b \b \b \b \"success\":\b \b true<br/>" +
            "}</font>";

    public static final String NORMAL_RES_SWAGGER_PDF = "项目统一返回格式\n" +
            "a-a-a-a-\n" +
            "{\n" +
            "\b \b \b \b \"result\"\b \b :\b \b {\n" +
            "\b \b \b \b \b \b \b \b \"data\"\b \b :\b \b {},\n" +
            "\b \b \b \b \b \b \b \b \"empty\"\b \b :\b \b true,\n" +
            "\b \b \b \b \b \b \b \b \"errCode\"\b \b :\b \b \"0\",\n" +
            "\b \b \b \b \b \b \b \b \"errMsg\"\b \b :\b \b \"ok\"\n" +
            "\b \b \b \b },\n" +
            "\b \b \b \b \"success\"\b \b :\b \b true\n" +
            "}\n" +
            "a-a-a-a-";

    public static final String GET_ENUM_NAME_RES_SWAGGER_HTML = "<font color=\"#FF0000\">查询枚举名称返回格式<br/>{<br/>" +
            "\b \b \b \b \"result\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"ZtRoleTypeEnum\":\b \b \"角色权限类型\"<br/>" +
            "\b \b \b \b \b \b \b \b },<br/>" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b \"0\",<br/>" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"操作成功\"<br/>" +
            "\b \b \b \b },<br/>" +
            "\b \b \b \b \"success\":\b \b true<br/>" +
            "}</font>";

    public static final String GET_ENUM_NAME_RES_SWAGGER_PDF = "查询枚举名称返回格式\n" +
            "a-a-a-a-\n" +
            "{\n" +
            "\b \b \b \b \"result\":\b \b {\n" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b {\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"ZtRoleTypeEnum\":\b \b \"role type\"\n" +
            "\b \b \b \b \b \b \b \b },\n" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b \"0\",\n" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"ok\"\n" +
            "\b \b \b \b },\n" +
            "\b \b \b \b \"success\":\b \b true\n" +
            "}\n" +
            "a-a-a-a-";

    public static final String GET_ENUM_INFO_RES_SWAGGER_HTML = "<font color=\"#FF0000\">查询枚举详情返回格式<br/>{<br/>" +
            "\b \b \b \b \"result\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b [<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"value\":\b \b \"COMPONENT\",<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"label\":\b \b \"菜单角色\",<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"enumIntValue\":\b \b 1<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b }<br/>" +
            "\b \b \b \b \b \b \b \b ],<br/>" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b \"0\",<br/>" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"操作成功\"<br/>" +
            "\b \b \b \b },<br/>" +
            "\b \b \b \b \"success\":\b \b true<br/>" +
            "}</font>";

    public static final String GET_ENUM_INFO_RES_SWAGGER_PDF = "查询枚举详情返回格式\n" +
            "a-a-a-a-\n" +
            "{\n" +
            "  \b \b \b \b \"result\":\b \b {\n" +
            "  \b \b \b \b \b \b \b \b \"data\":\b \b [\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b {\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"value\":\b \b \"COMPONENT\",\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"label\":\b \b \"menu role\",\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"enumIntValue\":\b \b 1\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b }\n" +
            "  \b \b \b \b \b \b \b \b ],\n" +
            "  \b \b \b \b \b \b \b \b \"errCode\":\b \b \"0\",\n" +
            "  \b \b \b \b \b \b \b \b \"errMsg\":\b \b \"ok\"\n" +
            "  \b \b \b \b },\n" +
            "  \b \b \b \b \"success\":\b \b true\n" +
            "}\n" +
            "a-a-a-a-";

    public static final String SELECT_ID_SIMPLE_RES_SWAGGER_HTML = "<font color=\"#FF0000\">返回的整体结构统一如下，result.data对象与selectSimple(分页查询)或insertSimple(单条新增)接口入参entity一致:<br/>" +
            "{<br/>" +
            "\b \b \b \b \"result\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"id\":\b \b 1,<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"createdBy\":\b \b \"zhangsan\"<br/>" +
            "\b \b \b \b \b \b \b \b },<br/>" +
            "\b \b \b \b \b \b \b \b \"empty\":\b \b true,<br/>" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b 0,<br/>" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"操作成功\"<br/>" +
            "\b \b \b \b },<br/>" +
            "\b \b \b \b \"success\":\b \b true<br/>" +
            "}</font>";

    public static final String SELECT_ID_SIMPLE_RES_SWAGGER_PDF = "返回的整体结构统一如下，result.data对象与selectSimple(分页查询)或insertSimple(单条新增)接口入参entity一致:\n" +
            "a-a-a-a-\n" +
            "{\n" +
            "  \b \b \b \b \"result\":\b \b {\n" +
            "  \b \b \b \b \b \b \b \b \"data\":\b \b {\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b \"id\":\b \b 1,\n" +
            "  \b \b \b \b \b \b \b \b \b \b \b \b \"createdBy\":\b \b \"zhangsan\"\n" +
            "  \b \b \b \b \b \b \b \b },\n" +
            "  \b \b \b \b \b \b \b \b \"empty\":\b \b true,\n" +
            "  \b \b \b \b \b \b \b \b \"errCode\":\b \b 0,\n" +
            "  \b \b \b \b \b \b \b \b \"errMsg\":\b \b \"ok\"\n" +
            "  \b \b \b \b },\n" +
            "  \b \b \b \b \"success\":\b \b true\n" +
            "}\n" +
            "a-a-a-a-";

    public static final String SELECT_SIMPLE_RES_SWAGGER_HTML = "<font color=\"#FF0000\">返回的整体结构统一如下，result.data.results数组内对象结构与selectSimple(分页查询)或insertSimple(单条新增)接口入参entity一致:<br/>" +
            "{<br/>" +
            "\b \b \b \b \"result\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"results\":\b \b [<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b {<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"id\":\b \b 1,<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"createdBy\":\b \b \"zhangsan\"<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b }<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b ],<br/>" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"total\":\b \b 0<br/>" +
            "\b \b \b \b \b \b \b \b },<br/>" +
            "\b \b \b \b \b \b \b \b \"empty\":\b \b true,<br/>" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b 0,<br/>" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"操作成功\"<br/>" +
            "\b \b \b \b },<br/>" +
            "\b \b \b \b \"success\":\b \b true<br/>" +
            "}</font>";

    public static final String SELECT_SIMPLE_RES_SWAGGER_PDF = "返回的整体结构统一如下，result.data.results数组内对象结构与selectSimple(分页查询)或insertSimple(单条新增)接口入参entity一致:\n" +
            "a-a-a-a-\n" +
            "{\n" +
            "\b \b \b \b \"result\":\b \b {\n" +
            "\b \b \b \b \b \b \b \b \"data\":\b \b {\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"results\":\b \b [\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b {\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"id\":\b \b 1,\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \"createdBy\":\b \b \"zhangsan\"\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \b \b \b \b }\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b ],\n" +
            "\b \b \b \b \b \b \b \b \b \b \b \b \"total\":\b \b 0\n" +
            "\b \b \b \b \b \b \b \b },\n" +
            "\b \b \b \b \b \b \b \b \"empty\":\b \b true,\n" +
            "\b \b \b \b \b \b \b \b \"errCode\":\b \b 0,\n" +
            "\b \b \b \b \b \b \b \b \"errMsg\":\b \b \"ok\"\n" +
            "\b \b \b \b },\n" +
            "\b \b \b \b \"success\":\b \b true\n" +
            "}\n" +
            "a-a-a-a-";

    public static final String NORMAL_RES_SWAGGER = NORMAL_RES_SWAGGER_HTML;
    public static final String GET_ENUM_NAME_RES_SWAGGER = GET_ENUM_NAME_RES_SWAGGER_HTML;
    public static final String GET_ENUM_INFO_RES_SWAGGER = GET_ENUM_INFO_RES_SWAGGER_HTML;
    public static final String SELECT_ID_SIMPLE_RES_SWAGGER = SELECT_ID_SIMPLE_RES_SWAGGER_HTML;
    public static final String SELECT_SIMPLE_RES_SWAGGER = SELECT_SIMPLE_RES_SWAGGER_HTML;

    // public static final String NORMAL_RES_SWAGGER = NORMAL_RES_SWAGGER_PDF;
    // public static final String GET_ENUM_NAME_RES_SWAGGER = GET_ENUM_NAME_RES_SWAGGER_PDF;
    // public static final String GET_ENUM_INFO_RES_SWAGGER = GET_ENUM_INFO_RES_SWAGGER_PDF;
    // public static final String SELECT_ID_SIMPLE_RES_SWAGGER = SELECT_ID_SIMPLE_RES_SWAGGER_PDF;
    // public static final String SELECT_SIMPLE_RES_SWAGGER = SELECT_SIMPLE_RES_SWAGGER_PDF;

    public static final String APIRESPONSE_MESSAGE = "返回的消息体结构请参照上面说明";
    //endregion

    //region 增删改查api
    public static final String DELEMITER = "/";
    public static final String GET_ENUM_NAME = DELEMITER + "getEnumName";
    public static final String GET_ENUM_INFO = DELEMITER + "getEnumInfo";
    public static final String SELECT_SIMPLE = DELEMITER + "selectSimple";
    public static final String SELECT_SIMPLE_ALL = DELEMITER + "selectSimpleAll";
    public static final String SELECT_ID_SIMPLE = DELEMITER + "selectIdSimple";
    public static final String SELECT_ID_SIMPLE_BATCH = DELEMITER + "selectIdSimpleBatch";
    public static final String SELECT_ONE_FIELD_SIMPLE_BATCH = DELEMITER + "selectOneFieldSimpleBatch";
    public static final String INSERT_SIMPLE = DELEMITER + "insertSimple";
    public static final String UPDATE_SIMPLE = DELEMITER + "updateSimple";
    public static final String DELETE_SIMPLE = DELEMITER + "deleteSimple";
    public static final String INSERT_BATCH_SIMPLE = DELEMITER + "insertBatchSimple";
    public static final String DELETE_BATCH_SIMPLE = DELEMITER + "deleteBatchSimple";

    public static final String REFRESH_CACHE = DELEMITER + "refresh";
    public static final String REFRESH_CACHE_BY_NAME = DELEMITER + "refreshByName";
    public static final String REFRESH_CACHE_BY_CUR_USER_ID = DELEMITER + "refreshCacheByCurUserId";
    //endregion

    public static final String FALSE_SQL = " NULL AND NOT NULL ";

    public static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP = new ConcurrentHashMap<>(8);

    static {
        WRAPPER_PRIMITIVE_MAP.put(Boolean.class, boolean.class);
        WRAPPER_PRIMITIVE_MAP.put(Byte.class, byte.class);
        WRAPPER_PRIMITIVE_MAP.put(Character.class, char.class);
        WRAPPER_PRIMITIVE_MAP.put(Double.class, double.class);
        WRAPPER_PRIMITIVE_MAP.put(Float.class, float.class);
        WRAPPER_PRIMITIVE_MAP.put(Integer.class, int.class);
        WRAPPER_PRIMITIVE_MAP.put(Long.class, long.class);
        WRAPPER_PRIMITIVE_MAP.put(Short.class, short.class);
        WRAPPER_PRIMITIVE_MAP.put(String.class, String.class);
    }

    public static StringBuilder getSignOriStr(JSONObject jsonObject) {
        StringBuilder sb = new StringBuilder();
        return getSignOriStr(jsonObject, sb);
    }

    public static StringBuilder getSignOriStr(JSONObject jsonObject, StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder();
        }
        ArrayList<String> keySet = new ArrayList<>(jsonObject.keySet());
        Collections.sort(keySet);
        for (String key : keySet) {
            if ("sign".equals(key)) {
                continue;
            }
            Object obj = jsonObject.get(key);
            // if (sb.toString().length() > 0 && sb.toString().lastIndexOf("{") != sb.toString().length() - 1 && sb.toString().lastIndexOf("[") != sb.toString().length() - 1) {
            //     sb.append("&");
            // }
            sb.append(key);
            // sb.append("=");
            if (obj.getClass().isPrimitive() || WRAPPER_PRIMITIVE_MAP.containsKey(obj.getClass())) {
                sb.append(obj);
            } else if (obj instanceof List) {
                List tmpList = (List) obj;
                Object tmpObj = tmpList.get(0);
                if (tmpObj.getClass().isPrimitive() || WRAPPER_PRIMITIVE_MAP.containsKey(tmpObj.getClass())) {
                    // Collections.sort(tmpList);
                    sb.append(JSON.toJSONString(tmpList));
                } else {
                    // sb.append("[");
                    for (Object innerObj : tmpList) {
                        JSONObject innerJsonObj = JSONObject.parseObject(JSON.toJSONString(innerObj));
                        // sb.append("{");
                        getSignOriStr(innerJsonObj, sb);
                        // sb.append("}");
                    }
                    // sb.append("]");
                }
            } else {
                JSONObject jsonObj = JSONObject.parseObject(JSON.toJSONString(obj));
                // sb.append("{");
                getSignOriStr(jsonObj, sb);
                // sb.append("}");
            }
        }
        return sb;
    }
}
