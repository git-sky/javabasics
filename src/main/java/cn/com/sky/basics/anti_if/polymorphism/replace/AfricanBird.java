package cn.com.sky.basics.anti_if.polymorphism.replace;


public class AfricanBird extends AbstractBird {

    @Override
    public double getSpeed() {
        return getBaseSpeed() - getLoadFactor();
    }
}
