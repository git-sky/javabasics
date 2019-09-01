package cn.com.sky;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class TestFiled {

    @Test
    public void testFileDelete() {

        List<File> delFiles = new ArrayList<>();
        File fileDir = new File("/tmp");
        Pattern pattern = Pattern.compile("^atalos");

        for (File f : fileDir.listFiles()) {
            if (f.isFile()) {
                String fileName = f.getName();
                boolean result = pattern.matcher(fileName).find();
                if (result) {
                    delFiles.add(f);
                }
            }
        }

        for (File file1 : delFiles) {
            System.out.println(file1.getName());
            file1.delete();
        }
    }


}



