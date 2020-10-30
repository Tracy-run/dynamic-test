package com.dynamic.util.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.HashMap;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/20 16:29
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

     /**
     * ThreadLocal 用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其它线程里的变量。
     * 也就是说 ThreadLocal 可以为每个线程创建一个【单独的变量副本】，相当于线程的 private static 类型变量。
     */
     private static  final ThreadLocal<DataSourceEnum> dataSourceName = new ThreadLocal<DataSourceEnum>();

    /**
     * 支持以包名的粒度选择数据源
     */
     private static final Map<String,DataSourceEnum> packageDataSource = new HashMap<String,DataSourceEnum>();

    public DynamicDataSource(DataSource firstDateSource,Map<Object,Object> targetDataSource){
        setDefaultTargetDataSource(firstDateSource);
        setTargetDataSources(targetDataSource);
        afterPropertiesSet();
    }


    /**
     * 获取与线程上下文绑定的数据源名称（存储在threadLocal中）
     * @return 数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceEnum dbName = dataSourceName.get();
        dataSourceName.remove();
        return dbName;
    }


    /**
     * 设置数据源
     * @param dataSource
     */
    public static void setDataSourceName(DataSourceEnum dataSource){
        dataSourceName.set(dataSource);
    }

    /**
     *
     * @param pkName
     */
    public static void setPackageDataSourceKey(String pkName){
        dataSourceName.set(packageDataSource.get(pkName));
    }

    /**
     *
     * @return
     */
    public Map<String,DataSourceEnum> getPackageDataSource(){
        return packageDataSource;
    }

    /**
     *
     * @param packageDataSource
     */
    public void setPackageDataSource(Map<String,DataSourceEnum> packageDataSource){
        this.packageDataSource.putAll(packageDataSource);
    }


}
