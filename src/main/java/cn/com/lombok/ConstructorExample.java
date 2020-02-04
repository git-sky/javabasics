package cn.com.lombok;

import cn.com.sky.basics.initial.demo1.C;
import lombok.*;
import org.quartz.SimpleTrigger;

/**
 * <pre>
 *     @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
 * 无参构造器、部分参数构造器、全参构造器。Lombok没法实现多种参数构造器的重载。
 *
 * </pre>
 */

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConstructorExample<T> {
    private int x, y;
    @NonNull
    private T description;

    @NoArgsConstructor
    @AllArgsConstructor
    public static class NoArgsExample {
        @NonNull
        private String field;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructorExample.NoArgsExample());
        System.out.println(new ConstructorExample.NoArgsExample("abc"));
        System.out.println(new ConstructorExample<String>(1,2,"x"));


    }
}