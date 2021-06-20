package cn.com.sky.basics.exceptions.demo2;

public class TestExceptionTraversal {

    public static void main(String[] args) {
        try {
            testa();
        } catch (ExceptionA e) {
            e.printStackTrace();
            //对异常信息进行遍历，输出异常信息中的原始异常，直到找到最终的原始异常
            Throwable throwable = e;
            while (throwable != null) {
                System.out.println(throwable);
//                System.out.println(throwable.getMessage());
                throwable = throwable.getCause();
            }
        }

    }

    public static void testa() throws ExceptionA {
        try {
            testb();
        } catch (ExceptionB e) {
            throw new ExceptionA("产生了异常A", e);
        }
    }

    public static void testb() throws ExceptionB {
        try {
            throw new Exception("产生了异常");
        } catch (Exception e) {
            throw new ExceptionB("产生了异常B", e);
        }
    }
}
