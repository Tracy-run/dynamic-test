package com.dynamic.util.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.dynamic.util.db.DataSourceEnum;
import com.dynamic.util.db.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.*;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/20 17:46
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource,DataSource secondDataSource){

        Map<Object,Object> targetDataSources = new HashMap<Object,Object>(2);
        targetDataSources.put(DataSourceEnum.first,firstDataSource);
        targetDataSources.put(DataSourceEnum.second,secondDataSource);

        //配置包级别的数据源
        Map<String,DataSourceEnum> packageDataSource = new HashMap<String,DataSourceEnum>();
        packageDataSource.put("com.dynamic.demo.service",DataSourceEnum.second);

        DynamicDataSource dynamicDataSource = new DynamicDataSource(firstDataSource,targetDataSources);
        dynamicDataSource.setPackageDataSource(packageDataSource);
        dynamicDataSource.afterPropertiesSet();

        return dynamicDataSource;
    }





}
