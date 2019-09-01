package cn.com.sky.basics.anti_if.polymorphism.replace;

public class NorwegianBird extends AbstractBird {
    private boolean isNailed;

    @Override
    public double getSpeed() {
        return isNailed ? 0 : getBaseSpeed();
    }

}