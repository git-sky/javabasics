package cn.com.sky.basics.callback.callback;


/**
 * <pre>
 *
 * Template模式也即模板模式，用于对一些不太变化的流程进行模板化，与callback结合，可以将变化的部分出离出来，使用callback实现。
 *
 *
 * </pre>
 */
public class TestCallback {

    public static void main(String[] args) {

        String say = "are you ok?";
        String param = "param";

        TaskTemplate taskTemplate = new TaskTemplate();

        taskTemplate.execute(new Callback<String>() {
            @Override
            public String doInTask() {
                System.out.println("a: " + say);
                return "a";
            }
        });

        System.out.println("==============================");

        taskTemplate.execute(new Callback<String>() {
            @Override
            public String doInTask() {
                System.out.println("b: " + say);
                return "b";
            }
        });

    }
}