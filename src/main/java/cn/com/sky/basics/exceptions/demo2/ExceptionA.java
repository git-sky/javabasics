package cn.com.sky.basics.exceptions.demo2;

//自定义异常ExceptionA
public class ExceptionA extends Exception {

    public ExceptionA() {
    }

    public ExceptionA(String e) {
        super(e);
    }

    public ExceptionA(String e, Throwable cause) {
        super(e, cause);
    }

    public ExceptionA(Throwable cause) {
        super(cause);
    }

}