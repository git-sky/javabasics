package cn.com.sky.basics.annotation.user.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类注解
 */

//表示该注解用于类上面
@Target(value = ElementType.TYPE)
// 运行时可以通过反射取得
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    public String name() default "";
}