package cn.com.tools.excel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xuanlingzeng
 */
@AllArgsConstructor
public enum FtlEnum {

    JAVA("tree.java.ftl", "java 类"),
    ENUM("enum.java.ftl", "enum 类"),
    ;

    @Getter
    private String ftl;

    @Getter
    private String desc;


}
