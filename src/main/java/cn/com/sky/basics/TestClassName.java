package cn.com.sky.basics;

class Box {
    class Inner {
    }
}

public class TestClassName {

    public static void main(String[] args) throws Exception {
        System.out.println("Box.class.getCanonicalName(): " + Box.class.getCanonicalName());
        System.out.println("Box.class.getName():          " + Box.class.getName());
        System.out.println("Box.class.getSimpleName():    " + Box.class.getSimpleName());

        System.out.println("Box.Inner.class.getCanonicalName(): " + Box.Inner.class.getCanonicalName());
        System.out.println("Box.Inner.class.getName():          " + Box.Inner.class.getName());
        System.out.println("Box.Inner.class.getSimpleName():    " + Box.Inner.class.getSimpleName());

        System.out.println("args.getClass().getCanonicalName(): " + args.getClass().getCanonicalName());
        System.out.println("args.getClass().getName():          " + args.getClass().getName());
        System.out.println("args.getClass().getSimpleName():    " + args.getClass().getSimpleName());
    }

}