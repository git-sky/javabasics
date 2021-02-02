package cn.com.lombok.toString;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Parent {
    private String name;
}