package cn.com.sky.basics.anti_if.boolean_model;


import org.junit.Test;

/**
 * 模式1：布尔参数（Boolean Params）
 * <p>
 * 问题： 在看到这段代码时，实际上是将两个方法捆绑到一起，布尔参数的出现导致在代码中定义了一个概念。
 * <p>
 * 适用范围： 通常看到这种情况，如果在编译时我们可以算出代码要采用哪种路径，就可以放心使用这种模式。
 * <p>
 * 解决方案： 将这个方法拆分成两个新的方法，然后if就不见了。
 */
public class TestBooleanIf {

    @Test
    public void example() {
        FileUtils.createFile("name.txt", "file contents", false);
        FileUtils.createFile("name_temp.txt", "file contents", true);
    }
}