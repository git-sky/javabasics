package cn.com.sky.basics.inherits;

/**
 * 编译会出错。
 * c 中的两个方法相同，会出现已定义的错误；
 * c 中的void m没有实现b中的方法。
 */
//interface a {
//    public double m(int i);
//}
//
//interface b {
//    public void m(int j);
//}
//
//public class c implements a, b {
//
////    public double m(int j) {
////        return 2.0 * j;
////    }
//
//    public void m(int j) {
//        System.out.println(j);
//    }
//
//    public static void main(String args[]) {
//        c cc = new c();
//        cc.m(4);
//    }
//
//}