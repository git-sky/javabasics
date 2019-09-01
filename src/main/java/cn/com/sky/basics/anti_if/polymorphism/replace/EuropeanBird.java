package cn.com.sky.basics.anti_if.polymorphism.replace;


public class EuropeanBird extends AbstractBird {
    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }
}
