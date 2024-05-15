package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，标识需要进行自动填充的方法
 * @author Zhou
 * @creat 2024-05-15 17:07
 */
// 将注解添加到方法上
@Target(ElementType.METHOD)
// 生命周期为RUNTIME，用于反射获取
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    // 数据库操作类型：UPDATE/INSERT
    OperationType value();
}
