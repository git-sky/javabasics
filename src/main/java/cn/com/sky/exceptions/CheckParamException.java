package cn.com.sky.exceptions;


public class CheckParamException extends RuntimeException {

    public CheckParamException() {
    }

    public CheckParamException(String message, Throwable cause) {
        super(message, cause);
    }
}