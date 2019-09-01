package cn.com.sky.basics.annotation.fruit.anno;

import java.lang.annotation.*;

/**
 * 水果名称注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
	String value() default "";
}