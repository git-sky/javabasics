package cn.com.sky.basics.callback.template;

public class TaskTemplateImpl2 extends TaskTemplate {

    @Override
    protected <T> T method() {
        System.out.println("b");
        return (T) "b";
    }
}