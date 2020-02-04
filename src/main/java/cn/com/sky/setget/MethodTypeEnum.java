package cn.com.sky.setget;

public enum MethodTypeEnum {
    SET("set"),

    GET("get");

    private final String methodName;

    private MethodTypeEnum(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String toString() {
        return getMethodName();
    }
}