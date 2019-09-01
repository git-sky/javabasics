package cn.com.sky.basics.anti_if.boolean_model;


import org.junit.Test;

/**
 * 使用两个方法，替换if判断
 **/
public class TestBooleanIfReplace {

    @Test
    public void example() {
        FileUtils.createFile("name.txt", "file contents");
        FileUtils.createTemporaryFile("name_temp.txt", "file contents");
    }

}