package cn.com.sky.tools.pinyin4j;

/**
 * 根据汉字得到对应的拼音
 */
public class MyPinYin {

    public static void main(String[] args) {
        Hanyu hanyu = new Hanyu();
        // 中英文混合的一段文字
        String str = "中国银行";
        String strPinyin = hanyu.getStringPinYin(str);
        System.out.println(strPinyin);
    }
}
