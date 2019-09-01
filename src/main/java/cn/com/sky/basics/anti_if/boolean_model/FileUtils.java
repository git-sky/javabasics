package cn.com.sky.basics.anti_if.boolean_model;


public class FileUtils {


    //使用if
    public static void createFile(String name, String contents, boolean temporary) {
        if (temporary) {
            // save temp file
        } else {
            // save permanent file
        }
    }

    //不用if，定义两个方法
    public static void createFile(String name, String contents) {
        // save permanent file
    }

    public static void createTemporaryFile(String name, String contents) {
        // save temp file
    }

}