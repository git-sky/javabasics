package cn.com.sky.basics.exceptions.demo2;

//自定义异常ExceptionB
public class ExceptionB extends Exception {

    public ExceptionB() {
    }

    public ExceptionB(String e) {
        super(e);
    }

    public ExceptionB(String e, Throwable cause) {
        super(e, cause);
    }

    public ExceptionB(Throwable cause) {
        super(cause);
    }

}