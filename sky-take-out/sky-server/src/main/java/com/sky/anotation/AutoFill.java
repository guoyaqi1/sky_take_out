package com.sky.anotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:guoyaqi
 * @Date: 2024/10/21 23:34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface AutoFill {

    //数据库操作类型 UPDATA INSERT
    OperationType value();

}
