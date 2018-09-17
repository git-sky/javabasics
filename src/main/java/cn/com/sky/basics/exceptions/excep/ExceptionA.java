package cn.com.sky.basics.exceptions.excep;

//自定义异常ExceptionA
public class ExceptionA extends Exception{

    public ExceptionA(String e) {
        super(e);
    }
    public ExceptionA() {
    }
    public ExceptionA(String e,Throwable cause)
    {
        super(e,cause);
    }
    public  ExceptionA(Throwable cause) {
        super(cause);
    }
}