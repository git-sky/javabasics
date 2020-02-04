package cn.com.sky.exceptions;


import org.junit.Test;

import javax.management.relation.RoleUnresolved;

public class TestCheckException {

    @Test
    public void test() {

        try {
            try {
//                throw new CheckParamException();
                throw new Exception();

            } catch (CheckParamException ce) {
                System.out.println(".............");
                throw new Exception(ce);
            } catch (Exception e) {
                System.out.println("=============");
            }
        } catch (Exception e) {
            System.out.println("+++++++++++++++++++");
        }

    }
}