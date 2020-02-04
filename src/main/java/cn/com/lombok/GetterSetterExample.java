package cn.com.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


/**
 * <pre>
 *
 *     @Getter/@Setter
 * 如果觉得@Data太过残暴（因为@Data集合了@ToString、@EqualsAndHashCode、@Getter/@Setter、@RequiredArgsConstructor的所有特性）不够精细，可以使用@Getter/@Setter注解，此注解在属性上，可以为相应的属性自动生成Getter/Setter方法.
 *
 * </pre>
 */
public class GetterSetterExample {
    @Getter
    @Setter
    private int age = 10;
    @Setter(AccessLevel.PROTECTED)
    private String name;

    @Override
    public String toString() {
        return String.format("%s (age: %d)", name, age);
    }
}