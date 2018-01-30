package cn.com.sky.basics.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 
 * 什么时候用到finally呢?
 * 某些事物（除内存外）在异常处理完后需要恢复到原始状态，如：开启的文件，网络连接等。
 * 
 * 
 * 根据分析，汇总一下答案：
 * 
 * 1.try语句没有被执行，如在try语句之前就返回了，这样finally语句就不会执行；因此说明了finally语句被执行的必要而非充分条件是：相应的try语句一定被执行到。
 * 2.如果在try代码块中执行System.exit(0)语句;那么将终止Java虚拟机JVM，因此，finally语句也不会被执行到。
 * 3.finally块的语句在try或catch中的return语句执行之后返回之前执行且finally里的修改语句可能影响也可能不影响try或catch中return已经确定的返回值，
 * 如果返回值类型为传址类型，则影响；传值类型，则不影响。若finally里也有return语句则覆盖try或catch中的return语句直接返回。
 * 
 */
public class TestFinalyReturn {

	public static void main(String[] args) {
		// System.out.println("return: " + test1());

		// System.out.println("return: " + test2());

//		System.out.println("return: " + test21());

        System.out.println("return: " + test3());

		System.out.println("return: " + Arrays.toString(test31()));

        System.out.println("return: " + test5());


        // System.out.println("return: " + test4());

	}

	/**
	 * <pre>
	 * 
	 * 结果：
	 * try...
	 * finally...
	 * finally...  i=12
	 * return: 11
	 * 
	 * 总结：finally代码块是在try代码块中的return语句执行之后，返回之前执行的。
	 */
	private static int test1() {
		int i = 1;
		try {
			System.out.println("try...");
			return i += 10;// 11
		} catch (Exception e) {
			System.out.println("catch...");
		} finally {
			i++;// 12
			System.out.println("finally...");
			System.out.println("finally...  i=" + i);
		}
		return i;
	}

	/**
	 * <pre>
	 * 
	 * 结果：
	 * try...
	 * finally...
	 * finally... i=12
	 * return: 12
	 * 
	 * 总结：finally代码块中的return语句覆盖try代码块中的return语句。
	 */
	private static int test2() {
		int i = 1;
		try {
			System.out.println("try...");
			return i += 10;// 11
		} catch (Exception e) {
			System.out.println("catch...");
		} finally {
			i++;// 12
			System.out.println("finally...");
			System.out.println("finally... i=" + i);
			return i;
		}
	}

	private static Integer test21() {
		Integer i = 3331;
		try {
			System.out.println("try...");
			return i += 10;// 11
		} catch (Exception e) {
			System.out.println("catch...");
		} finally {
			i++;// 12
			i = new Integer(3333333);
			System.out.println("finally...");
			System.out.println("finally... i=" + i);
			// return i;
		}
		System.out.println(".............");
		return i;
	}

	/**
	 * <pre>
	 * 结果：
	 * 
	 * try... 
	 * finally...
	 * return: {KEY=FINALLY}
	 * 
	 * 总结： 如果finally语句中没有return语句覆盖返回值，那么原来的返回值可能因为finally里的修改而改变也可能不变。传值类型的返回值：不变；传址类型的返回值：会变。
	 * 
	 * 这里引入来一个新的问题，怎么判断一个变量是传值还是传址？
	 * 传值：8种基本数据类型及其包装类，字符常量。
	 * 传址：数组和对象。
	 * 
	 * 原因：
	 * 其实看一下你那个类的class字节码文件就知道了。 return的时候是复制了一个变量然后返回，所以之后finally操作的变量如果是基本类型的话不会影响返回值。
	 * 但是如果返回值是引用类型的话，因为指向同一个对象所以还是有影响的。
	 * 返回基础类型变量时是值，返回引用类型时是指向某个对象的地址；而且基础类型是被分配在栈中的，对象是被分配在堆中的，只要有引用指向这个对象，系统就不会回收此对象，所以可以在后面的finally块中改变引用指向的对象的内容，却无法改变try语句中return要返回的值，因为这个值已经与变量b无关了。
	 */
	private static Map<String, String> test3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("KEY", "INIT");
		try {
			System.out.println("try...");
			map.put("KEY", "TRY");
			return map;
		} catch (Exception e) {
			System.out.println("catch...");
			map.put("KEY", "CATCH");
		} finally {
			System.out.println("finally...");
			map.put("KEY", "FINALLY");
			map = null;
		}
		return map;
	}

	private static int[] test31() {
		int[] arr = { 1, 2, 3 };
		System.out.println(Arrays.toString(arr));
		try {
			System.out.println("try...");
			return arr;
		} catch (Exception e) {
			System.out.println("catch...");
			arr[0] = 5;
			System.out.println(Arrays.toString(arr));
		} finally {
			System.out.println("finally...");
			arr[0] = 4;
			System.out.println(Arrays.toString(arr));
			arr = null;
		}
		return arr;
	}


    private static String test5() {
        String arr = "abc";
        System.out.println(arr);
        try {
            System.out.println("try...");
            arr="try";
            return arr;
        } catch (Exception e) {
            System.out.println("catch...");
            arr="catch";
        } finally {
            System.out.println("finally...");
            arr="finally";
        }
        return arr;
    }

	/**
	 * <pre>
	 * 结果：
	 * try...
	 * catch...
	 * finally...
	 * finally... i=2
	 * return: 1
	 * 
	 * 总结： try代码块中的return语句在异常的情况下不会被执行，这样具体返回哪个看情况；catch中的return执行情况与未发生异常时try中return的执行情况完全一样。
	 * 
	 */
	private static int test4() {
		int i = 1;
		try {
			System.out.println("try...");
			i = i / 0;
			return i += 10;
		} catch (Exception e) {
			System.out.println("catch...");
			return i;
		} finally {
			i++;
			System.out.println("finally...");
			System.out.println("finally... i=" + i);
		}
	}

}
