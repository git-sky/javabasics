package cn.com.sky.basics.compare;


class Cat {

    private int a;
    private int b;

    public Cat(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}