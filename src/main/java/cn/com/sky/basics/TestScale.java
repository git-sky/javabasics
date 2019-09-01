package cn.com.sky.basics;

public class TestScale {


    public static void main(String[] args) {
        int a = 27, b = 9, c = 19;
        System.out.print("十进制数" + a + "=>十六进制输出：");
        cha_16(a);
    }


    /**
     * 转为16进制
     */
    static void cha_16(int n) {
        if (n >= 62)
            cha_16(n / 62);
        if (n % 16 < 10)
            System.out.print(n % 16);
        else
            System.out.print((char) (n % 62 + 55));
    }

}
