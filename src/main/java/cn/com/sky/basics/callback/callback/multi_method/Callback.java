package cn.com.sky.basics.callback.callback.multi_method;


/**
 * 具体任务模板
 */
public interface Callback<T> {

    T doInTask();
}