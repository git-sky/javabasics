package cn.com.sky.exceptions;


import org.junit.Test;

import javax.management.relation.RoleUnresolved;

public class TestCheckException {

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