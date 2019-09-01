package cn.com.sky.basics.array;

public class TestNewArray {

    public static void main(String[] args) {

        //创建有10个元素的数组，默认值是null。
        People[] people = new People[10];

        //length是10。
        System.out.println(people.length);


        for (int i = 0; i < 5; i++) {
            people[i] = new People();
        }


        System.out.println(people.length);

        for (People p : people) {
            System.out.println(p);
            System.out.println(p.getName());
        }

    }

    static final class People {

        private String name;

        People() {
            System.out.println("People()............");
        }

        People(String name) {
            System.out.println("People(String name)........");
            this.setName(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
