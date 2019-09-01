package cn.com.sky.basics.compare;


class Dog implements Comparable<Dog> {

    private int a;
    private int b;

    public Dog(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Dog o) {
//        return (this.a > o.a || this.b > o.b) ? 1 : 0;
        if (this.a - o.a == 0) {
            return this.b - o.b;
        } else {
            return this.a - o.a;
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}