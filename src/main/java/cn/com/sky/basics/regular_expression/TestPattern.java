package cn.com.sky.basics.regular_expression;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    @Test
    public void test2() {
        Pattern p = Pattern.compile("\\d{2}");
        Matcher m = p.matcher("one cat two cat3452345s in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            // m.appendReplacement(sb, "dog");
            System.out.println(m.group());
        }
        // m.appendTail(sb);
        // System.out.println(sb.toString());

        String str = "        10元 1000人   民币  10000元   100000RMB       ";

        System.out.println(str);
        str = str.replaceAll("^\\s+|\\s+$", "");
        System.out.println(str);

        String h = "步行者[东1]";
        h = h.substring(0, h.length() - 4);
        System.out.println(h);

    }

    @Test
    public void test1() {
        Pattern p = Pattern.compile("\\[.*]");
        Matcher m = p.matcher("步行者[中国]sdfsd等会发狂似的");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            System.out.println(m.group());
        }

        String s = m.replaceAll("");
        System.out.println(s);
    }

    @Test
    public void test3() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "");
        jsonObject.put("b", "");
        jsonObject.put("c", "123");

        List<ParamPattern> bodyParams = Lists.newArrayList(new ParamPattern("a", "^[^\\s]+$"), new ParamPattern("b", ""), new ParamPattern("c", "\\-?[1-9]\\d+"), new ParamPattern("d", "\\-?[1-9]\\d+"));
        for (ParamPattern param : bodyParams) {
            if (jsonObject.get(param.getName()) == null) {
                System.out.println("false");
            } else {
                System.out.println(Pattern.matches(param.getPattern(), (String) jsonObject.get(param.getName())));
            }
        }
    }

}
