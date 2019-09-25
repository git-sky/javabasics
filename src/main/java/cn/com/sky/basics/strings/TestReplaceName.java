package cn.com.sky.basics.strings;

import org.junit.Test;


public class TestReplaceName {

    @Test
    public void test() {
        String sname = "艺龙-高德地图";
        sname = sname.replace("携程", "CT");
        sname = sname.replace("艺龙", "EL");
        sname = sname.replace("去哪儿", "QN");
        sname = sname.replace("飞猪", "FZ");
        sname = sname.replace("阿里去啊", "ALQA");
        sname = sname.replace("高德地图", "GDDT");

        System.out.println(sname);
    }
}