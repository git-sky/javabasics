package cn.com.sky.basics.regular_expression;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Test2 {


    public static void main(String[] strings) {
        String s = "测试文件名称";

        boolean b = isValidFileName(s);
        System.out.println(b);

    }

    public static boolean isValidFileName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return false;
        }

        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (StringUtils.equalsIgnoreCase(suffixName, "txt")) {
            return true;
        }
        return false;
    }


}