package cn.com.sky.basics.strings;

import org.junit.Test;

public class TestString {


    // 按字典顺序比较两个字符串。该比较基于字符串中各个字符的 Unicode 值。将此 String
    // 对象表示的字符序列与参数字符串所表示的字符序列进行比较。如果按字典顺序此 String
    // 对象在参数字符串之前，则比较结果为一个负整数。如果按字典顺序此 String
    // 对象位于参数字符串之后，则比较结果为一个正整数。如果这两个字符串相等，则结果为 0；compareTo 只有在方法 equals(Object)
    // 返回 true 时才返回 0。
    @Test
    public void testCompareTo() {
//		String now = "20130911";
//		String end = "20130915";
//		if (now.compareTo(end) < 0) {
//			System.out.println(end);
//			System.out.println(now);
//			end = now;
//		}
//		System.out.println(end);
//		System.out.println(now);

        String API_VERSION_2_0_0 = "2.0";

        String client_version = "2.0.0";

        if (client_version.compareTo(API_VERSION_2_0_0) > 0) {
            System.out.println(client_version);
        }

    }

    @Test
    public void test2() {
        String sch = "";
        StringBuffer all_schedule = new StringBuffer();
        all_schedule.append("31");
        all_schedule.append("-");
        all_schedule.append("23");
        all_schedule.append("-");
        if (all_schedule.length() > 0) {
            sch = all_schedule.substring(0, all_schedule.length() - 1);
        }
        System.out.println(sch);
    }

    @Test
    public void testChar() {
        String sch = "abcdefg中国";
        for (int i = 0; i < sch.length(); i++) {
            System.out.println(sch.charAt(i));
            System.out.println((int) sch.charAt(i));
            System.out.println(sch.codePointAt(i));
        }
    }

    @Test
    public void testString() {

        String tv_ids = "2,23,2,1,3,4,5,2,1,2,3,5";

        StringBuilder sb = new StringBuilder();

        String[] tvs = tv_ids.split(",");

        for (int i = 0; i < tvs.length; i++) {
            if (tvs[i].equals("")) {
                continue;
            }
            sb.append(tvs[i]);
            sb.append(",");
        }

        String str = sb.substring(0, sb.length() - 1);
        System.out.println(str);
    }

    @Test
    public void testStr3() {
        Integer score = 1110558810;
//		String score_str = String.valueOf(score);
//		int len = score_str.length();
//
//		StringBuffer sb = new StringBuffer();
//		for (int i = len - 1, j = 0; i >= 0; i--, j++) {
//			if (j == 3) {
//				sb.append(",");
//				j = 0;
//			}
//			char c = score_str.charAt(i);
//			sb.append(c);
//		}
//		String score_comma = sb.reverse().toString();
//		System.out.println(score_comma);


        //积分中添加逗号进行分隔显示
        String score_str = String.valueOf(score);
        int len = score_str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            if (j == 3) {
                sb.append(",");
                j = 0;
            }
            char c = score_str.charAt(i);
            sb.append(c);
        }
        String score_comma = sb.reverse().toString();
        System.out.println(score_comma);
    }


    @Test
    public void testFormatMessage() {
        String message = "aaa={}, bbb={},cc={}, dd";

        String result = formatMessage(message, 1, 2, 3);
        System.out.println(result);
    }

    /**
     * 格式化信息
     *
     * @param message
     * @param parameters
     * @return
     */
    private static String formatMessage(String message, Object... parameters) {
        if (message != null && message.contains("{}")) {
            message = message.replace("{}", "%s");
        }

        System.out.println(message);
        System.out.println(parameters);

        String format = String.format(message, parameters);
        return format;
    }
}
