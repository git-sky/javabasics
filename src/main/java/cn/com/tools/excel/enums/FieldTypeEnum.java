package cn.com.tools.excel.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字段类型枚举
 *
 * @Author jialiangliu
 * @date Date : 2019年11月13日 5:47 PM
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum FieldTypeEnum {
    INT(0, "Integer", Integer.class, "int", "", "") {
        @Override
        public Object toJavaObject(String content) {
            return StringUtils.isNotEmpty(content) ? Integer.parseInt(content) : null;
        }
    },
    LONG(1, "Long", Long.class, "long", "", "") {
        @Override
        public Object toJavaObject(String content) {
            return StringUtils.isNotEmpty(content) ? Long.parseLong(content) : null;
        }
    },
    BOOL(2, "Boolean", Boolean.class, "bool", "", "") {
        @Override
        public Object toJavaObject(String content) {
            return StringUtils.isNotEmpty(content) ? Boolean.parseBoolean(content) : null;
        }
    },
    STRING(3, "String", String.class, "string", "", "") {
        @Override
        public Object toJavaObject(String content) {
            return content;
        }
    },
    DOUBLE(4, "Double", Double.class, "double", "", "") {
        @Override
        public Object toJavaObject(String content) {
            return StringUtils.isNotEmpty(content) ? Double.parseDouble(content) : null;
        }
    },
    FLOAT(5, "Float", Float.class, "float", "", "") {
        @Override
        public Object toJavaObject(String content) {
            return StringUtils.isNotEmpty(content) ? Float.parseFloat(content) : null;
        }
    },
    LIST(6, "java.util.List", List.class, "[", "]", "") {
        @Override
        public Object toJavaObject(String content) {
            return null;
        }
    },
    OBJECT(7, "Object", Object.class, "(", ")", "") {
        @Override
        public Object toJavaObject(String content) {
            return null;
        }
    },
    ENUM(8, "Enum", Object.class, "enum", "id", "key") {
        @Override
        public Object toJavaObject(String content) {
            return content;
        }
    },;

    @Getter
    private int id;

    @Getter
    private String javaName;

    @Getter
    private Class innerClazz;

    @Getter
    private final String excelName;

    @Getter
    private final String excelEndName;

    @Getter
    private final String excelEnumKey;

    private static final Map<String, FieldTypeEnum> excelNameMap = new HashMap<>();

    static {
        for (FieldTypeEnum fieldTypeEnum : FieldTypeEnum.values()) {
            excelNameMap.put(fieldTypeEnum.getExcelName(), fieldTypeEnum);
        }
    }

    FieldTypeEnum(int id, String javaName, Class type, String excelName, String excelEndName, String excelEnumKey) {
        this.id = id;
        this.javaName = javaName;
        this.innerClazz = type;
        this.excelName = excelName;
        this.excelEndName = excelEndName;
        this.excelEnumKey = excelEnumKey;
    }

    public abstract Object toJavaObject(String content);

    public static FieldTypeEnum findFieldTypeByExcelName(String excelName) {
        return excelNameMap.get(excelName);
    }
}
