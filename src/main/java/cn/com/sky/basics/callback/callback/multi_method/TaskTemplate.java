package cn.com.sky.basics.callback.callback.multi_method;

/**
 * 操作模板
 */
public class TaskTemplate {

    /**
     * execute是模板方法，action是callback；
     *
     * @param action
     * @param <T>
     * @return
     */
    public <T> T execute(Callback<T> action) {
        before();
        T result = action.doInTask();
        after();
        return result;
    }

    public <T> T executeQuery(QueryCallback<T> action) {
        before();
        T result = action.query();
        after();
        return result;
    }

    public <T> T executeUpdate(UpdateCallback<T> action) {
        before();
        T result = action.update();
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