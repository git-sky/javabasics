package cn.com.sky.basics.test_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.nio.charset.Charset;

public class FileTest {

    public FileTest() {
    }

    public static void main(String[] args) {

        FileOutputStream out = null;
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        FileWriter fw = null;

        long count = 1000000;
        long initial = 1000000000;

        try {
            out = new FileOutputStream(new File("add.txt"));

            long begin = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                long number = initial + i;
                out.write(String.valueOf(number).getBytes(Charset.forName("utf-8")));
//                out.write("\r\n".getBytes());
            }
            out.close();

            long end = System.currentTimeMillis();

            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 豪秒");

            File file = new File("add.txt");
            System.out.println(file.length());

            outSTr = new FileOutputStream(new File("add0.txt"));
            Buff = new BufferedOutputStream(outSTr);

            long begin0 = System.currentTimeMillis();

            for (int i = 0; i < count; i++) {
                Buff.write("测试java文件操作\r\n".getBytes());
            }

            Buff.flush();
            Buff.close();

            long end0 = System.currentTimeMillis();

            System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 豪秒");

            fw = new FileWriter("add2.txt");

            long begin3 = System.currentTimeMillis();

            for (int i = 0; i < count; i++) {
                fw.write("测试java文件操作\r\n");
            }

            fw.close();

            long end3 = System.currentTimeMillis();

            System.out.println("FileWriter执行耗时:" + (end3 - begin3) + " 豪秒");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                fw.close();
                Buff.close();
                outSTr.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}