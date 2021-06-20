package cn.com.sky.basics.exceptions.demo3;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常链的用武之地：保存异常信息，在抛出另外一个异常的同时不丢失原来的异常。
 */
@Slf4j
public class TestCause {


    public static void main(String[] args) {
        try {
            test1();
        } catch (ExceptionC e) {
            e.printStackTrace();
//            log.error("s", e);
//            System.out.println(e);
        }
    }

    public static void test1() throws ExceptionC {
        try {
            test2();
        } catch (ExceptionB e) {
            ExceptionC c = new ExceptionC("exception c");

			c.initCause(e);// 异常链,不写这一句，异常链就会丢失。
            throw c;
        }
    }

    public static void test2() throws ExceptionB {
        throw new ExceptionB("exception b");
    }


}
