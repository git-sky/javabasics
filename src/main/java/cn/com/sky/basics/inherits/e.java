//package cn.com.sky.basics.inherits;
//
//interface a {
//    public int m(int i);
//}
//
//class b {
//    public void m(int i) {
//        System.out.println(i);
//    }
//}
//
//public class e extends b implements a {
//    //返回类型不兼容
//    public int m(int i) {
//        System.out.println("e");
//        System.out.println(i);
//        return i;
//    }
//
//    public static void main(String args[]) {
//        e cc = new e();
//        cc.m(5);
//    }
//
//}