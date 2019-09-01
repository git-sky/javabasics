package cn.com.sky.basics.anti_if.polymorphism.replace;

/**
 * 解决方案： 使用多态，添加新类型时大家都不会忘记添加相关行为。
 */
public abstract class AbstractBird {


    public abstract double getSpeed();

    protected double getLoadFactor() {
        return 3;
    }

    protected double getBaseSpeed() {
        return 10;
    }

}