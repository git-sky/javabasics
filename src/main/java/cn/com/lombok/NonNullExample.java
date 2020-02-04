package cn.com.lombok;

import lombok.NonNull;

/**
 * <pre>
 *
 *     @NonNull
 * 该注解用在属性或构造器上，Lombok会生成一个非空的声明，可用于校验参数，能帮助避免空指针。
 *
 * </pre>
 */
public class NonNullExample {
    private String name;

    public NonNullExample(@NonNull String str) {
        this.name = str;
    }
}