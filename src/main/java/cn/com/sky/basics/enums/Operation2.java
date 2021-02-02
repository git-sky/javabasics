package cn.com.sky.basics.enums;

public enum Operation2 {

    PLUS, MINUS, MULTI, DIVIDE;

    public double eval(double a, double b) {
        switch (this) {
            case PLUS:
                return a + b;
            //因为前面有return语句，所以后面的break语句永远不会被执行
            //break;
            case MINUS:
                return a - b;
            //break;
            case MULTI:
                return a * b;
            //break;
            case DIVIDE:
                return a / b;
            //break;
            //从java语法的角度来看，因为该方法有返回值，所以default语句是必须的
            //但从实际的语义来看，因为this代表的是枚举类的实例，而枚举类的实例是固定的，
            //所以default语句是完全多余的
            default:
                return 0.0;
            //break;
        }
    }

    public static void main(String[] args) {
        for (Operation o : Operation.values()) {
            System.out.println(o.eval(1, 2));
        }
    }
}