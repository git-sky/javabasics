package cn.com.sky.basics.generics.one_generic_clazz;

/**
 * 一个泛型类型
 */
public class TestOneGeneric {

    public static void main(String args[]) {
        //=== demo1传入String ===//
        Point<String> p = new Point<>();
        p.setVar("abc");
        String str = p.getVar();
        System.out.println(p.getVar());
        System.out.println(p.getVar().length());

        //=== demo2传入Integer  ===//
        Point<Integer> pInt = new Point<>();
        pInt.setVar(123);
        Integer sInt = pInt.getVar();
        System.out.println();
    }

}

class Point<T> { // 此处可以随便写标识符号，T是type的简称
    private T var; // var的类型由T指定，即：由外部指定

    public T getVar() { // 返回值的类型由外部决定
        return var;
    }

    public void setVar(T var) { // 设置的类型也由外部决定
        this.var = var;
    }
};


