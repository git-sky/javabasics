package cn.com.lombok.classical;


public class NonNullExample {
    private String name;

    public NonNullExample(String str) {

        if (str == null) {
            throw new NullPointerException("str");
        }
        this.name = str;
    }
}