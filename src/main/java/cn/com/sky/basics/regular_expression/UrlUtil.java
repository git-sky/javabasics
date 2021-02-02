package cn.com.sky.basics.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtil {

    public static boolean isHttpUrl(String url) {
        String regex = "^(http|https)\\://([a-zA-Z0-9_\\-]+)([\\.][a-zA-Z0-9_\\-]+)+((:80|:443)?)(/($|[a-zA-Z0-9\\.\\?\\\\\\+&amp;%\\$#\\=~_\\-]+))*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

}