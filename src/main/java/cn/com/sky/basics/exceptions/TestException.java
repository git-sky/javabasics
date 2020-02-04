package cn.com.sky.basics.exceptions;

/**
 * <pre>
 *
 * 【推荐】定义时区分unchecked / checked 异常，避免直接使用RuntimeException抛出，更不允许抛出Exception或者Throwable，应使用有业务含义的自定义异常。
 * 推荐业界已定义过的自定义异常，如：DaoException / ServiceException等。
 *
 *  未检查异常 unchecked exception
 * 1> Error类及其子类不需要捕获异常。
 * 2> RuntimeException类及其子类不需要捕获异常。
 *
 * 已检查异常 checked exception
 * 非 unchecked exception得异常都需要捕获。
 */
public class TestException {

    public static void main(String[] args) {

        // 不用捕获
        try {
            new TestException().getError();
        } catch (Error e) {
            System.out.println("Error ");
            e.printStackTrace();
            System.out.println("Error ");
        }

        // 不用捕获
        try {
            new TestException().getRuntimeException();
        } catch (Exception e) {
            System.out.println("RuntimeException ");
            e.printStackTrace();
            System.out.println("RuntimeException ");
        }

        // 必须捕获
        try {
            new TestException().getException();
        } catch (Exception e) {
            System.out.println("Exception ");
            e.printStackTrace();
        }

        // 必须捕获
        try {
            new TestException().getThrowable();
        } catch (Throwable e) {
            System.out.println("Throwable ");
            e.printStackTrace();
        }

    }

    private void getError() {
        throw new Error();
    }

    private void getRuntimeException() {
        throw new RuntimeException();
    }

    private void getException() throws Exception {
        throw new Exception();
    }

    private void getThrowable() throws Throwable {
        throw new Throwable();
    }

}
