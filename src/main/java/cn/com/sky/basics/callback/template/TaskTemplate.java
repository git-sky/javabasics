package cn.com.sky.basics.callback.template;


public abstract class TaskTemplate {

    //模板方法
    public <T> T execute() {
        before();
        T result = method();
        after();
        return result;
    }

    private void before() {
        System.out.println("before...");
    }

    public void after() {
        System.out.println("after...");
    }

    protected abstract <T> T method();//子类负责实现业务逻辑

}