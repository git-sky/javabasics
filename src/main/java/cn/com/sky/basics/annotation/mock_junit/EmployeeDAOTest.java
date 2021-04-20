package cn.com.sky.basics.annotation.mock_junit;

public class EmployeeDAOTest {

    @MyBefore
    public void init() {
        System.out.println("初始化...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testUpdate() {
        System.out.println("update...");
    }


    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }
}