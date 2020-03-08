package cn.com.sky.basics.exceptions.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常链的用武之地：保存异常信息，在抛出另外一个异常的同时不丢失原来的异常。
 */
@Slf4j
public class NeverCaught {

    static void f() throws ExceptionB {
        throw new ExceptionB("exception b");
    }

    static void g() throws ExceptionC {
        try {
            f();
        } catch (ExceptionB e) {
            ExceptionC c = new ExceptionC("exception c");

//			c.initCause(e);// 异常链,不写这一句，异常链就会丢失。
            throw c;
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (ExceptionC e) {
//            e.printStackTrace();
            log.error("s",e);
        }
    }

}
