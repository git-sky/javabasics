package cn.com.sky.basics.strings;

public class StringCount {

    //统计字符串中各字符个数
    public static void main(String args[]) {
        String ss = "asdfdfsdfgdfg的发生大发fgdfgffffffffa";
        int i = ss.length();
        System.out.println(i);
        char a[] = new char[i];
        char b[] = new char[i];
        for (int j = 0; j < i; j++) {
            a[j] = ss.charAt(j);
        }

        for (int j = 0; j < i; j++) {
            boolean tag = false;
            int k = 0;
            char test;
            test = a[j];
            for (k = 0; b[k] != '\0'; k++) {
                if (test == b[k]) {
                    tag = true;
                }
            }
            if (!tag) {
                b[k] = test;
            }
        }

        for (int j = 0; b[j] != '\0'; j++) {
            int num = 0;
            int k = 0;
            char test;
            test = b[j];
            for (k = 0; k < i; k++) {
                if (test == a[k]) {
                    num++;
                }
            }
            System.out.println(b[j] + ":" + num);
        }

    }
}
