package com.dynamic.util.inter;

import com.dynamic.util.db.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/20 16:56
 */

@Target({ElementType.PACKAGE,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {


    /**
     * default DataSourceEnum
     *
     * @return
     */
    DataSourceEnum value() default  DataSourceEnum.first;

}
