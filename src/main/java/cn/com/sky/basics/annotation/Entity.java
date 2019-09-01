package cn.com.sky.basics.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *
 * 实体注解接口
 */
@Target(value = {ElementType.TYPE}) //仅应用于类、接口、enum声明、注解类型
@Retention(value = RetentionPolicy.RUNTIME) //运行时有效
public @interface Entity {
    /***
     * 实体默认firstLevelCache属性为false
     * @return boolean
     */
    boolean firstLevelCache() default false;

    /***
     * 实体默认secondLevelCache属性为true
     * @return boolean
     */
    boolean secondLevelCache() default true;

    /***
     * 表名默认为空
     * @return String
     */
    String tableName() default "";

    /***
     * 默认以""分割注解
     */
    String split() default "";
}