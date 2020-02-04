package cn.com.lombok;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

/**
 * <pre>
 *
 *     @Data
 * @Data注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
 *
 *  使用Lombok的DataExample，相当于cn.com.lombok.classical.DataExample的写法。
 *
 * </pre>
 */

@Data
public class DataExample {

    private final String name;

    @Setter(AccessLevel.PACKAGE)
    private int age;
    private double score;
    private String[] tags;

    @ToString(includeFieldNames = true)
    @Data(staticConstructor = "of")
    public static class Exercise<T> {
        private final String name;
        private final T value;
    }
}