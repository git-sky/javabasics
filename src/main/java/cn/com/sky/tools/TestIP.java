package cn.com.sky.tools;

public class TestIP {

    public static void main(String[] args) {

        String ip = "192.168.1.1";
        Long l = new TestIP().ipToInt(ip);
        System.out.println("a=" + l + "=b");
    }

    private long ipToInt(String ip) {
        String[] arr = ip.split("\\.");
        long ret = 0;
        for (int i = 0; i < arr.length; i++) {
            long l = 1;
            for (int j = 0; j < i; j++) {
                l *= 256;
            }
            try {
                ret += Long.parseLong(arr[arr.length - i - 1]) * l;
            } catch (Exception e) {
                ret += 0;
            }
        }
        return ret;
    }

}
