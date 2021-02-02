package cn.com.sky.basics.enums;

import java.util.HashMap;

public enum OrderTypeEnum {
    PAY(0, "支付订单"),
    CANCEL(1, "取消订单"),;

    private Integer key;
    private String value;

    private static HashMap<Integer, String> key2value = new HashMap<>();
    private static HashMap<String, Integer> value2key = new HashMap<>();

    static {
        for (OrderTypeEnum demo : OrderTypeEnum.values()) {
            key2value.put(demo.getKey(), demo.getValue());
            value2key.put(demo.getValue(), demo.getKey());
        }
    }

    OrderTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }

    public static String getValue(Integer key) {
        return key2value.get(key);
    }

    public static Integer getKey(String value) {
        return value2key.get(value);
    }

    public static void main(String[] args) {
        System.out.println(getValue(0));
    }


}
