package cn.com.java8lambdasexercises.chapter4.default_method;

import cn.com.java8lambdasexercises.chapter4.default_method.ParentImpl;

public class OverridingParent extends ParentImpl {

//    重写 welcome 默认实现的父类
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }

}

