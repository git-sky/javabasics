package cn.com.sky.lamda;

public class FunctionDemo {

    @FunctionalInterface
    public interface FunctionQuote {
        public void print(String arg);
    }

    public static void process(FunctionQuote functionQuote) {
        String str = "http://blog.csdn.net/u013256816";
        functionQuote.print(str);
    }

    public static void main(String[] args) {
        process((String s) -> System.out.println(s));
        process(System.out::println);
    }
}