package cn.com.sky.basics.enums;


public enum Operation {

    PLUS {
        @Override
        public double eval(double a, double b) {
            return a + b;
        }
    },
    MINUS {
        @Override
        public double eval(double a, double b) {
            return a - b;
        }
    },
    MULTI {
        @Override
        public double eval(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public double eval(double a, double b) {
            return a / b;
        }
    };

    public abstract double eval(double a, double b);

    public static void main(String[] args) {
        for (Operation o : Operation.values()) {
            System.out.println(o.eval(1, 2));
        }
    }
}