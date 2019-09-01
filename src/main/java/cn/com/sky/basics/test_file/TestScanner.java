package cn.com.sky.basics.test_file;

import java.math.BigDecimal;

public class TestScanner {

    public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		String str = s.next();
//		System.out.println(str);
//		Integer i = s.nextInt();
//		System.out.println(i);
//		Double d = s.nextDouble();
//		System.out.println(d);
//		String sl = s.nextLine();
//		System.out.println(sl);


//		System.out.println(new Double((Double.valueOf(0.1234123412341123) * 100d)).intValue());
        String ratio = "0.255234";

        ratio = new BigDecimal(ratio).setScale(2, BigDecimal.ROUND_HALF_UP).toString();

        System.out.println(ratio);


    }

}
