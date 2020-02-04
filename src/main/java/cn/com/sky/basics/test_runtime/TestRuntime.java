package cn.com.sky.basics.test_runtime;

public class TestRuntime {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();

        System.out.println("freeMemory=" + freeMemory);
        System.out.println("totalMemory=" + totalMemory);
        System.out.println("maxMemory=" + maxMemory);

        String msg = "Max:" + (maxMemory / 1024 / 1024) + "M, Total:" + (totalMemory / 1024 / 1024) + "M, Free:" + (freeMemory / 1024 / 1024) + "M, Use:"
                + ((totalMemory / 1024 / 1024) - (freeMemory / 1024 / 1024)) + "M";

        System.out.println(msg);
    }

}
