package cn.com.sky.basics.test_runtime;

import java.io.IOException;

public class RunProcessTest {

    public static void main(String[] args) {
        try {
            //String exeFullPathName = "C:/Program Files/Internet Explorer/IEXPLORE.EXE";
            String exeFullPathName = "C:/Users/sky/AppData/Local/Google/Chrome/Application/chrome.exe";
            String message = "www.baidu.com";
            String[] cmd = {exeFullPathName, message};
            Process proc = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}