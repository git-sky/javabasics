package cn.com.sky.exceptions;

public class MyBusinessException extends RuntimeException {

    public MyBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
