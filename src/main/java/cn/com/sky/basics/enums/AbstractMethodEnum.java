package cn.com.sky.basics.enums;

/**
 * 带有抽象方法的枚举类
 */
public class AbstractMethodEnum {

    public static void main(String[] args) {
        System.out.println(Grade.A.getValue() + " 分为：" + Grade.A.localeVlaue());
        System.out.println(Grade.B.getValue() + " 分为：" + Grade.B.localeVlaue());
        System.out.println(Grade.C.getValue() + " 分为：" + Grade.C.localeVlaue());
        System.out.println(Grade.D.getValue() + " 分为：" + Grade.D.localeVlaue());
        System.out.println(Grade.E.getValue() + " 分为：" + Grade.E.localeVlaue());
    }

    enum Grade {

        //实现抽象方法
        A("100-90") {
            @Override
            public String localeVlaue() {
                return "优";
            }
        },
        B("89-80") {
            public String localeVlaue() {
                return "良";
            }
        },
        C("79-70") {
            public String localeVlaue() {
                return "中";
            }
        },
        D("69-60") {
            public String localeVlaue() {
                return "差";
            }
        },
        E("59-0") {
            public String localeVlaue() {
                return "不及格";
            }
        };


        private String value;

        Grade(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        /**
         * 设置该枚举类的抽象方法,不同的枚举值返回不同的结果。
         */
        public abstract String localeVlaue();
    }
}