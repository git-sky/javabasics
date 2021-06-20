package cn.com.sky.basics.exceptions.demo1;


public class CheckParamException extends RuntimeException {

    public CheckParamException() {
        super();
    }

    public CheckParamException(String message) {
        super(message);
    }

    public CheckParamException(String message, Throwable cause) {
        super(message, cause);
    }
}