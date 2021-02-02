package cn.com.tools;

/**
 * 三位数的版本号比较大小。
 */
public class VersionCompareUtils {

    public static void main(String[] args) {
        System.out.println(biggerThan("1.2.3", "1.2.3"));
        System.out.println(biggerThan("1.2.3", "1.2.4"));
        System.out.println(biggerThan("1.2.4", "1.2.3"));
        System.out.println(biggerThan("1.2.3", "1.3.1"));
        System.out.println(biggerThan("1.3.4", "1.2.5"));
        System.out.println(biggerThan("9997.3.4", "9996.4.5"));
    }


    private static boolean biggerThan(String aVersion, String bVersion) {
        String[] aversions = aVersion.split("\\.");
        String[] bversions = bVersion.split("\\.");

        if (aversions.length != bversions.length) {
            throw new RuntimeException();
        }
        if (compare(aversions, bversions) == 1) {
            return true;
        }

        return false;
    }

    private static int compare(String[] aversions, String[] bversions) {
        for (int i = 0; i < aversions.length; i++) {
            if (Integer.valueOf(aversions[i]).intValue() > Integer.valueOf(bversions[i]).intValue()) {
                return 1;
            } else if (Integer.valueOf(aversions[i]).intValue() < Integer.valueOf(bversions[i]).intValue()) {
                return -1;
            }
        }
        return 0;
    }
}