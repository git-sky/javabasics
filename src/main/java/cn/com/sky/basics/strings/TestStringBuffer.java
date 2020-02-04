package cn.com.sky.basics.strings;

/**
 * StringBuilder性能比StringBuffer高， StringBuffer加了synchronized同步方法。
 * <p>
 * 性能从高到低： StringBuilder > StringBuffer > String的concat > String的+
 */
public class TestStringBuffer {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        StringBuilder sbd = new StringBuilder();
        String s = new String();
        String s2 = new String();

        Integer count = 100_0000;

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            sb.append(i);
        }

        System.out.println("StringBuffer的append的执行次数:" + count + ",耗时：" + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            sbd.append(i);
        }

        System.out.println("StringBuilder的append的执行次数:" + count + ",耗时：" + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            s.concat(String.valueOf(i));
        }

        System.out.println("String的concat的执行次数:" + count + ",耗时：" + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            s2 = s2 + i;
        }
        System.out.println("String的+执行次数:" + count + ",耗时：" + (System.currentTimeMillis() - start4));

    }
}
