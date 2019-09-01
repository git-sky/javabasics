package cn.com.sky.basics.annotation.table.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 应用于类、接口、enum、注解类型
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}