package cn.com.sky.basics.test_file;

import java.io.*;

public class testIn {
    public static void main(String args[]) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
            while (s != null) {
                if (s.equalsIgnoreCase("exit"))
                    break;
                System.out.print(s.toUpperCase());
                s = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
