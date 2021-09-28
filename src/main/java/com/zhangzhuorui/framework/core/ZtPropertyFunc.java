package com.zhangzhuorui.framework.core;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
@FunctionalInterface
public interface ZtPropertyFunc<T, R> extends Function<T, R>, Serializable {
}
