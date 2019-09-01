package cn.com.sky.basics.number;


import org.junit.Test;

public class TestByte {

    @Test
    public void test() {
        byte b = new Byte("1");
        byte c = (byte) 1;
        System.out.println(b == 1);
        System.out.println(c == 1);
        System.out.println(b == c);
    }


}