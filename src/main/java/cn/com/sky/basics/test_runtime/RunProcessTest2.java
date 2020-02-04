package cn.com.sky.basics.test_runtime;

import java.io.IOException;

public class RunProcessTest2 {

    public static void main(String[] args) {
        try {
            Process proc = Runtime.getRuntime().exec("notepad");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}