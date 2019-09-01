package cn.com.sky.collections;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCollectionsSort {

    @Test
    public void sortString() {
        List<String> list = new ArrayList<>();
        list.add("ca");
        list.add("ga");
        list.add("ab");
        list.add("bd");
        list.add("eg");
        list.add("fa");
        list.add("aa");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("---------------------------");

        Collections.sort(list, new DicComparator());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
    }

    class DicComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }

    @Test
    public void sortLong() {
        List<Long> list = new ArrayList<>();
        list.add(12L);
        list.add(33L);
        list.add(71L);
        list.add(2L);
        list.add(4L);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("---------------------------");

        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
    }


    @Test
    public void sortModel() {
        List<Model> list = new ArrayList<>();
        list.add(new Model(19, "zhang", 165L, new BigDecimal("3.55")));
        list.add(new Model(21, "wang", 115L, new BigDecimal("1.59")));
        list.add(new Model(3, "li", 25L, new BigDecimal("1.05")));
        list.add(new Model(45, "liu", 445L, new BigDecimal("5.12")));
        list.add(new Model(3, "alia", 25L, new BigDecimal("1.01")));
        list.add(new Model(3, "alia", 12L, new BigDecimal("1.05")));
        list.add(new Model(3, "alia", 12L, new BigDecimal("1.02")));


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();
        System.out.println("---------------------------");

        Collections.sort(list, new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                if (!o1.getId().equals(o2.getId())) {
                    return o1.getId().compareTo(o2.getId());
                } else {
                    if (!o1.getName().equals(o2.getName())) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        if (!o1.getHeight().equals(o2.getHeight())) {
                            return o1.getHeight().compareTo(o2.getHeight());
                        } else {
                            return o1.getMoney().compareTo(o2.getMoney());
                        }
                    }
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    class Model {
        private Integer id;
        private String name;
        private Long height;
        private BigDecimal money;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getHeight() {
            return height;
        }

        public void setHeight(Long height) {
            this.height = height;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }

        public Model() {
        }

        public Model(Integer id, String name, Long height, BigDecimal money) {
            this.id = id;
            this.name = name;
            this.height = height;
            this.money = money;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", height=" + height +
                    ", money=" + money +
                    '}';
        }
    }


}
