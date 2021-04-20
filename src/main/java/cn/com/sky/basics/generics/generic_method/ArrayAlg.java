package cn.com.sky.basics.generics.generic_method;

public class ArrayAlg {

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static void main(String[] args) {

        //在这种情况(实际也是大多数情况)下， 方法调用中可以省略 <String> 类型参数。编译器有足够的信息能够推断出所调用的方法。
        String middle = ArrayAlg.<String>getMiddle("]ohnM", "Q.n", "Public");
        System.out.println(middle);

        String middle2 = ArrayAlg.getMiddle("]ohn", "Q.", "Public");
        System.out.println(middle2);

    }

}