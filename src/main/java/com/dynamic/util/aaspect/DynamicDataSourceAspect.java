package com.dynamic.util.aaspect;

import com.dynamic.util.db.DataSourceEnum;
import com.dynamic.util.db.DynamicDataSource;
import com.dynamic.util.inter.CurDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 动态数据源切面类
 * 被切中的，则先判断方法上是否有CurDataSource注解
 * 然后判断方法所属类上是否有CurDataSource注解
 * 其次判断是否配置了包级别的数据源
 *
 * 优先级为方法、类、包
 * 若同时配置则优先按方法上的
 *
 * @Author: 逍遥子
 * @Date: 2020/10/20 17:19
 */

@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.dynamic.util.inter.CurDataSource)")
    public void choseDatasourceByAnnotation(){}

    @Pointcut("@within(com.dynamic.util.inter.CurDataSource)")
    public void choseDataSourceByClass(){}

    @Pointcut("execution(* com.dynamic.demo.service..*(..))")
    public void choseDataSourceByPackage(){}

    @Around("choseDatasourceByAnnotation() || choseDataSourceByClass() || choseDataSourceByPackage()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        DataSourceEnum datasourceKey = getDatasourceKey(signature);
        if(!Objects.isNull(datasourceKey)){
            DynamicDataSource.setDataSourceName(datasourceKey);
        }
        return joinPoint.proceed();
    }



    private DataSourceEnum getDatasourceKey(Signature signature) {
        if(signature == null){
            return null;
        }else{
            if(signature instanceof MethodSignature){
                MethodSignature methodSignature = (MethodSignature)signature;
                Method method = methodSignature.getMethod();
                if(method.isAnnotationPresent(CurDataSource.class)){
                    return this.dsSettingInMethod(method);
                }
                Class<?> declaringClass = method.getDeclaringClass();
                if(declaringClass.isAnnotationPresent(CurDataSource.class)){
                    return this.dsSettingConstrutor(declaringClass);
                }
                Package apackage = declaringClass.getPackage();
                this.dsSettingInPackage(apackage);
            }
            return null;
        }
    }

    private DataSourceEnum dsSettingConstrutor(Class<?> declaringClass){
        CurDataSource dataSource = declaringClass.getAnnotation(CurDataSource.class);
        return dataSource.value();
    }


    private DataSourceEnum dsSettingInMethod(Method method){
        CurDataSource dataSource = method.getAnnotation(CurDataSource.class);
        return dataSource.value();
    }

    private void dsSettingInPackage(Package pkage){
        DynamicDataSource.setPackageDataSourceKey(pkage.getName());
    }
}
