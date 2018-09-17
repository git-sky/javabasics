package cn.com.sky.basics.exceptions.excep;

//自定义异常ExceptionB
public class ExceptionB extends Exception{

    public ExceptionB(String e) {
        super(e);
    }
    public ExceptionB() {
        // TODO Auto-generated constructor stub
    }
    public ExceptionB(String e,Throwable cause)
    {
        super(e,cause);
    }
    public  ExceptionB(Throwable cause) {
        super(cause);
    }

}