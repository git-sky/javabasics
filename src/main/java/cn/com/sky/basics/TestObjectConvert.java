package cn.com.sky.basics;

/**
 * 类型转换 
 */
public class TestObjectConvert {

	public static void main(String[] args) {

		Object a = "3";
		//类型转换错误
		Integer b = (Integer) a;
		System.out.println(b);

		
		System.out.println(Integer.valueOf((String) a));

		Integer c = Integer.parseInt((String) a);
		System.out.println(c);

		Integer d = Integer.parseInt(String.valueOf(a));
		System.out.println(d);

	}

}
