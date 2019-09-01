package cn.com.sky.basics.strings;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestTrim {

    @Test
    public void test() {

        String loginName = " a我是中华            公民b ";
        System.out.println(loginName.length());
        System.out.println(loginName.trim().length());
        System.out.println(loginName.length());

        loginName = loginName.trim();

        System.out.println(loginName);
        System.out.println(loginName.length());

        if (loginName.length() > 5) {
            String begin = loginName.substring(0, 2);
            String end = loginName.substring(loginName.length() - 2, loginName.length());

            loginName = begin + "*" + end;
        }

        System.out.println(loginName);

    }

    @Test
    public void tests() {

        String a = " a ";
        String b = "A  ";

        System.out.println(StringUtils.equals(a, b));
        System.out.println(StringUtils.equalsIgnoreCase(a, b));

        System.out.println(a);
        System.out.println(StringUtils.trimToEmpty(a));

        System.out.println(StringUtils.equals(StringUtils.trimToEmpty(a),StringUtils.trimToEmpty(b)));


        System.out.println(StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(a),StringUtils.trimToEmpty(b)));
    }

}
