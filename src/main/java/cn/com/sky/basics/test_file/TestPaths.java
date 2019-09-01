package cn.com.sky.basics.test_file;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPaths {

    public static void main(String[] args) {

        Path basePath = Paths.get("c:/");
        Path workRelative = Paths.get("hh");

        Path p = basePath.resolve(workRelative);

        System.out.println(p);
    }

}
