package com.dynamic;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.dynamic.util.config.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * https://www.liangzl.com/get-article-detail-207976.html
 *
 *感兴趣的可以去下载
 * https://gitee.com/itwalking/springboot-dynamic-datasource，
 * https://gitee.com/itwalking/ssm-dynamic-datasource
 *
 */
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@Import({DynamicDataSourceConfig.class})
@MapperScan(basePackages = "com.dynamic.demo.mapper")
public class DynamicTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicTestApplication.class, args);
    }

}
