package cn.com.sky.basics.callback.callback.multi_method;


/**
 * <pre>
 *
 * Template模式也即模板模式，用于对一些不太变化的流程进行模板化，与callback结合，可以将变化的部分出离出来，使用callback实现。
 *
 *
 * 为什么spring不用传统的模板方法，而加之以Callback进行配合呢？
 * 试想，如果父类中有10个抽象方法，而继承它的所有子类则要将这10个抽象方法全部实现，子类显得非常臃肿。而有时候某个子类只需要定制父类中的某一个方法该怎么办呢？这个时候就要用到Callback回调了。
 *
 *
 * Spring不论是与ibatis，还是与Hibernate的结合中，都使用到了Template模式与callback技术，来达到简化代码实现的目的。
 * Template模式也即模板模式，用于对一些不太变化的流程进行模板化，与callback结合，可以将变化的部分出离出来，使用callback实现。
 * 然后根据不同的情况，向template注入不同的callback。那些模板代码就没有必要重复写了。
 *
 *
 * "Template模式 + Callback模式"相结合
 *
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
                return "Callback a";
            }
        });

        taskTemplate.execute(new Callback<String>() {
            @Override
            public String doInTask() {
                System.out.println("b: " + say);
                return "Callback b";
            }
        });

        System.out.println("==============================");

        taskTemplate.executeQuery(new QueryCallback<String>() {
            @Override
            public String query() {
                System.out.println("QueryCallback...");
                return "QueryCallback";
            }
        });

        System.out.println("==============================");

        taskTemplate.executeUpdate(new UpdateCallback<String>() {
            @Override
            public String update() {
                System.out.println("UpdateCallback...");
                return "UpdateCallback";
            }
        });

    }
}