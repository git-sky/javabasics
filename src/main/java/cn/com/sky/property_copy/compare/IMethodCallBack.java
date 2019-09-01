package cn.com.sky.property_copy.compare;

public interface IMethodCallBack {

    String getMethodName();

    ToBean callMethod(FromBean frombean) throws Exception;

}