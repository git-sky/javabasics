package cn.com.sky.basics.callback.template;

/**
 * <pre>
 *
 * 所谓模板板式，就是在父类中定义算法的主要流程，而把一些个性化的步骤延迟到子类中去实现，父类始终控制着整个流程的主动权，子类只是辅助父类实现某些可定制的步骤。
 *
 * 每一次个性化需求，都需要一个子类。 因此可以考虑使用回调方式，减少子类数量。
 *
 * 为什么spring不用传统的模板方法，而加之以Callback进行配合呢？
 * 试想，如果父类中有10个抽象方法，而继承它的所有子类则要将这10个抽象方法全部实现，子类显得非常臃肿。而有时候某个子类只需要定制父类中的某一个方法该怎么办呢？这个时候就要用到Callback回调了。
 *
 * </pre>
 */
public class TestTemplate {

    public static void main(String[] args) {
        TaskTemplate t1 = new TaskTemplateImpl();
        t1.execute();

        System.out.println("==============================");

        TaskTemplate t2 = new TaskTemplateImpl2();
        t2.execute();
    }
}