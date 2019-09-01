package cn.com.sky.basics.annotation.table.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 字段注解接口
 */
@Target(value = {ElementType.FIELD})//注解可以被添加在属性上
@Retention(value = RetentionPolicy.RUNTIME)//注解保存在JVM运行时刻,能够在运行时刻通过反射API来获取到注解的信息
public @interface Column {
    String name();//注解的name属性
}

