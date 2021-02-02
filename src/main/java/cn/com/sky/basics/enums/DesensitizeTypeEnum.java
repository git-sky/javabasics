package cn.com.sky.basics.enums;


import org.apache.commons.lang.StringUtils;


public enum DesensitizeTypeEnum {

    adminCard("adminCard", 2, 14, 2, 2) {
        @Override
        public String getShiftContent(String oldValue, Integer prefix, Integer middle, Integer suffix, Integer minLength) {
            if (oldValue != null && oldValue.length() >= minLength) {
                return oldValue.substring(0, prefix)
                        + StringUtils.repeat("*", middle)
                        + oldValue.substring(oldValue.length() - suffix);
            }
            return oldValue;
        }
    },
    phone("phone", 3, 4, 4, 4) {
        @Override
        public String getShiftContent(String oldValue, Integer prefix, Integer middle, Integer suffix, Integer minLength) {
            if (oldValue != null && oldValue.length() >= minLength) {
                return oldValue.substring(0, prefix)
                        + StringUtils.repeat("*", middle)
                        + oldValue.substring(oldValue.length() - suffix);
            }
            return oldValue;
        }
    },
    mobile("mobile", 3, 4, 4, 4) {
        @Override
        public String getShiftContent(String oldValue, Integer prefix, Integer middle, Integer suffix, Integer minLength) {
            if (oldValue != null && oldValue.length() >= minLength) {
                return oldValue.substring(0, prefix)
                        + StringUtils.repeat("*", middle)
                        + oldValue.substring(oldValue.length() - suffix);
            }
            return oldValue;
        }
    },
    adminPhone("adminPhone", 3, 4, 4, 4) {
        @Override
        public String getShiftContent(String oldValue, Integer prefix, Integer middle, Integer suffix, Integer minLength) {
            if (oldValue != null && oldValue.length() >= minLength) {
                return oldValue.substring(0, prefix)
                        + StringUtils.repeat("*", middle)
                        + oldValue.substring(oldValue.length() - suffix);
            }
            return oldValue;
        }
    },;

    private String fieldName;
    private Integer prefix;
    private Integer middle;
    private Integer suffix;
    private Integer minLength;


    DesensitizeTypeEnum(String fieldName, Integer prefix, Integer middle, Integer suffix, Integer minLength) {
        this.fieldName = fieldName;
        this.prefix = prefix;
        this.middle = middle;
        this.suffix = suffix;
        this.minLength = minLength;
    }


    public abstract String getShiftContent(String oldValue, Integer prefix, Integer middle, Integer suffix, Integer minLength);

    public String getContent(String oldValue) {
        return getShiftContent(oldValue, this.prefix, this.middle, this.suffix, this.minLength);
    }

    public static String replace(String oldValue, DesensitizeTypeEnum type) {
        return type.getContent(oldValue);
    }

    public static void main(String[] args) {
        System.out.println(adminCard.getContent("1234"));
        System.out.println(phone.getContent("1234"));

        System.out.println(replace("1212", adminCard));
        System.out.println(replace("1212", phone));

    }



}
