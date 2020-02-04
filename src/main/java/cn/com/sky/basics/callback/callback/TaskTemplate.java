package cn.com.sky.basics.callback.callback;

/**
 * 操作模板
 */
public class TaskTemplate {

    public <T> T execute(Callback<T> action) {
        before();
        T result = action.doInTask();
        after();
        return result;
    }

    private void before() {
        System.out.println("before...");
    }

    public void after() {
        System.out.println("after...");
    }
}