package cn.com.sky.exceptions;


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