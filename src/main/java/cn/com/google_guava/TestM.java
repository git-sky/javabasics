package cn.com.google_guava;

/**
 *
 */
public class TestM {
    public static void main(String[] args) {
        String fileName = "mgc_manin.mgcpkg";
        Integer lastIdx = fileName.lastIndexOf(".mgcpkg");
        if (lastIdx > 0) {
            fileName = fileName.substring(0, lastIdx);
        }

        System.out.println(lastIdx);
        System.out.println(fileName);

        System.out.println("mgcw2ssmpu1pj72t".length());
        System.out.println("2ad22ac6cd7c4197898ed9b10896f917".length());
    }
}