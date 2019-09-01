package cn.com.java8lambdasexercises.chapter4.default_method;

import org.junit.Assert;
import org.junit.Test;


/**
 * 默认方法的优先级
 */
public class TestDefaultMethod {

    @Test
    public void parentDefaultUsed() {
        //Parent 接口定义了一个默认方法 welcome，调用该方法时，发送一条信息。
        // ParentImpl 类没有实现 welcome 方法，因此它自然继承了该默认方法。
        Parent parent = new ParentImpl();
        parent.welcome();
        Assert.assertEquals("Parent: Hi!", parent.getLastMessage());
    }


    @Test
    public void childOverrideDefault() {
        Child child = new ChildImpl();
        child.welcome();
        Assert.assertEquals("Child: Hi!", child.getLastMessage());
    }


    @Test
    public void concreteBeatsDefault() {
        //任何时候，默认方法一旦与类中定义的方法产生冲突，都要优先选择类中定义的方法。
        //调用的是类中的具体方法，而不是默认方法。
        Parent parent = new OverridingParent();
        parent.welcome();
        Assert.assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }


    @Test
    public void concreteBeatsCloserDefault() {
        //与接口中定义的默认方法相比，类中重写的方法更具体;
        //类中重写的方法优先级高于接口中定义的默认方法;
        Child child = new OverridingChild();
        child.welcome();
        Assert.assertEquals("Class Parent: Hi!", child.getLastMessage());
    }
}

