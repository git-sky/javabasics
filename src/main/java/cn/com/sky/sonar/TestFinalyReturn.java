package cn.com.sky.sonar;

/**
 * <pre>
 *
 *  Jump statements should not occur in "finally" blocks （跳转语句不应该放在finally语句块里面）
 * 解析：
 *
 * 在finally语句块里面使用return，break，throw 等等会抑制 在try或者catch 语句块中抛出的未处理的异常
 *
 * 这个规则引发了一个问题：跳出语句（break, continue, return, throw, and goto）会强制控制流离开finally语句块
 *
 * </pre>
 */
public class TestFinalyReturn {

    public static void main(String[] args) {
        try {
            doSomethingWhichThrowsException();
            System.out.println("OK");   // incorrect "OK" message is printed
        } catch (RuntimeException e) {
            System.out.println("ERROR");  // this message is not shown
        }
    }

    public static void doSomethingWhichThrowsException() {
        try {
            throw new RuntimeException();
        } finally {
//            int q = 2;
//            for (int i = 0; i < 10; i++) {
//                if (q == i) {
//                    break; // ignored
//                }
//            }

            //此处return，会导致吞掉异常，导致上层代码捕捉不到异常。
            return;      // Noncompliant - prevents the RuntimeException from being propagated
        }
    }
}