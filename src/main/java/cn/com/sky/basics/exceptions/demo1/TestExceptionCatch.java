package cn.com.sky.basics.exceptions.demo1;


import org.junit.Test;

public class TestExceptionCatch {

    @Test
    public void test() {

        try {
            try {
                throw new CheckParamException();
//                throw new CheckParamException("哈哈哈");
//                throw new Exception();

            } catch (CheckParamException ce) {
                System.out.println(".............");
                ce.printStackTrace();
                throw new Exception(ce);
            } catch (Exception e) {//此处的catch，不能捕获上一个catch抛出的Exception。
                System.out.println("=============" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("+++++++++++++++++++" + e.getMessage());
        }

    }
}