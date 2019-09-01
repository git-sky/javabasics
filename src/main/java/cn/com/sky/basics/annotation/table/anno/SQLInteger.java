package cn.com.sky.basics.annotation.table.anno;

import cn.com.sky.basics.annotation.table.anno.Constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//FIELD  用于变量名
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    String name() default "";

    Constraints constraints() default @Constraints;
}
