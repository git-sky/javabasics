package cn.com.sky.basics.callback.template;


public class TaskTemplateImpl extends TaskTemplate {

    @Override
    protected <T> T method() {
        System.out.println("a");
        return (T)"a";
    }
}