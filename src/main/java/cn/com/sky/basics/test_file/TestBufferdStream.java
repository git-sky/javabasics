package cn.com.sky.basics.test_file;

import java.io.*;

public class TestBufferdStream {
    public static void main(String args[]) {
        try {
            FileInputStream fis = new FileInputStream("c.txt");

            BufferedInputStream bis = new BufferedInputStream(fis);
            int c = 0;
            System.out.println(bis.read());
            System.out.println(bis.read());
            bis.mark(100);
            for (int i = 0; i < 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c + " ");
            }
            System.out.println();
            bis.reset();
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c + " ");
            }
            bis.close();


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
