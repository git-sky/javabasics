package cn.com.tools.excel.enums;

import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SCEnum {

    //全部
    ALL(-1, "sc"),
    //服务器
    SERVER(1 << 0, "s"),
    //客户端
    CLIENT(1 << 1, "c"),;

    @Getter
    private int index;

    @Getter
    private String excelName;

    private static final Map<Integer, SCEnum> indexEnumMap = new HashMap<>();

    private static final Map<String, SCEnum> nameEnumMap = new HashMap<>();

    static {
        EnumSet<SCEnum> scEnums = EnumSet.allOf(SCEnum.class);
        for (SCEnum scEnum : scEnums) {
            indexEnumMap.put(scEnum.index, scEnum);
            nameEnumMap.put(scEnum.excelName, scEnum);
        }
    }

    SCEnum(int index, String excelName) {
        this.index = index;
        this.excelName = excelName;
    }

    public static SCEnum indexOf(int index) {
        return indexEnumMap.get(index);
    }

    public static SCEnum excelNameOf(String excelName) {
        return nameEnumMap.get(excelName);
    }

    public boolean isServer() {
        return this == SERVER || this == ALL;
    }

    public boolean isClient() {
        return this == CLIENT || this == ALL;
    }

    /**
     * 两个集合是否有交集
     *
     * @param scEnum
     * @return
     */
    public boolean hasIntersect(SCEnum scEnum) {
        return (scEnum.index & this.index) != 0;
    }

}
