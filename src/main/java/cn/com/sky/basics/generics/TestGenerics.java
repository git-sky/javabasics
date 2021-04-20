package cn.com.sky.basics.generics;

/**
 * <pre>
 *
 * 泛型也叫generics，泛型分泛型方法和泛型类，两种定义方式，泛型还有上界下界的说法。
 *
 * 1.泛型方法：
 * 用于方法的参数或者方法的返回值。要使范型有效，就须在方法的返回类型前加入强制范型转换。
 *
 * 其中，add(T t)的参数用了范型，它的返回值是void型，就在void前用强制类型转换，即加上<T>，强制转换成范型的形式。
 * 而T get(ID id)，由于它的参数和返回类型都用了范型，故要在返回类型T前强制转换，即<T,ID>。
 *
 *
 * 2.泛型类:
 * 把范型声明放在类中，不需要每个方法都写强制类型转换。
 */
public class TestGenerics {

    public static void main(String[] args) {

        TestGenericsClazz<String, String> clazz = new TestGenericsClazz<>();
        clazz.add("a");
        clazz.get("b");

        TestGenericsMethod method = new TestGenericsMethod();
        method.add("a");

    }

}

/**
 * 泛型方法
 */
class TestGenericsMethod {

    public <T> void add(T t) {
    }

    public <T, ID> T get(ID id) {
        return null;
    }

//ID没有强制类型转换，会报错
//	public <T> T get(ID id) {
//		return null;
//	}

}

/**
 * 泛型类
 */
class TestGenericsClazz<T, ID> {

    private T a;

    public void add(T t) {
    }

    public T get(ID id) {
        return null;
    }

}
