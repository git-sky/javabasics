package cn.com.sky.basics.exceptions.demo1;

public class MyBusinessException extends RuntimeException {

    public MyBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
