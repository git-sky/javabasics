package cn.com.sky.basics.anti_if.polymorphism;

/**
 * 模式2：使用多态（Polymorphism）
 * <p>
 * 问题： 在添加新的类型时，我们必须要记得更新switch语句，此外随着不同bird的概念添加进来，bird类的凝聚力越来越糟。
 * <p>
 * 适用范围：根据类型做单次切换是可行的，如果switch太多，在添加新类型时如果忘记更新现有隐藏类型中的所有switch，就会导致bug出现，8thlight博客关于这种情况有详细描述。
 * <p>
 * 解决方案： 使用多态，添加新类型时大家都不会忘记添加相关行为。
 */
public class Bird {

    private enum Species {
        EUROPEAN, AFRICAN, NORWEGIAN_BLUE;
    }

    private boolean isNailed;
    private Species type;

    public double getSpeed() {
        switch (type) {
            case EUROPEAN:
                return getBaseSpeed();
            case AFRICAN:
                return getBaseSpeed() - getLoadFactor();
            case NORWEGIAN_BLUE:
                return isNailed ? 0 : getBaseSpeed();
            default:
                return 0;
        }
    }

    private double getLoadFactor() {
        return 3;
    }

    private double getBaseSpeed() {
        return 10;
    }
}
