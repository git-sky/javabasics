package cn.com.sky.alpha_work;

public class TestA {
    public static void main(String[] args) {

        String path = "/610/599/601/911/607/606/606";

        String[] pathArray = path.split("/");
        for (int i = 1; i < pathArray.length; i++) {
            System.out.println(i + " " + pathArray[i]);
        }

//		String a = null;
//
//		System.out.println("abdc" + a + "xx");
//
//		Boolean b = null;
//		if (b) {
//			System.out.println("aaaaaaaaaa");
//		}


        System.out.println(Long.MAX_VALUE);
//		4382 24668 70451 29756
//		9    00719 92547 40992
//		9223 36911  59370 66154
//
//		9223 37203  68547 75807
    }

}
