package cn.com.sky.basics.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <pre>
 *
 * 属性的数据类型：
 * 八种基本数据类型
 * String
 * 枚举
 * Class
 * 注解类型
 * 以上类型的一维数组
 *
 *
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    int intValue();

    long longValue();

    String strValue();

    Class classValue();


}