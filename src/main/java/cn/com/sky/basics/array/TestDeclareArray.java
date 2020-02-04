package cn.com.sky.basics.array;

public class TestDeclareArray {

    //arr1与arr2都成功声明成了数组
    int[] arr1, arr2;

    {
        System.out.println("aaaaaaaaaaaa");
    }

    //只有arr3成功声明成了数组，arr4是int类型而非数组类型
    int arr3[], arr4;

    public static void main(String args[]) {
        System.out.println("main............");
        new TestDeclareArray().print();
        System.out.println("after print............");
    }

    public void print() {
        arr1 = new int[5];
        arr2 = new int[5];
        arr3 = new int[5];
//		arr4=new int[5]; 报错，不是数组类型
        System.out.println(arr1.getClass().isArray());
        System.out.println(arr2.getClass().isArray());
        System.out.println(arr3.getClass().isArray());
//		System.out.println(arr4.getClass().isArray());//Cannot invoke getClass() on the primitive type int
    }
}
