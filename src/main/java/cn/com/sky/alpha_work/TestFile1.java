package cn.com.sky.alpha_work;

import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TestFile1 {
    public static final Logger LOGGER = LoggerFactory.getLogger(cn.com.sky.alpha_work.ImportFile.class);

    public static void main(String[] args) {
        readFileByLines();
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<String> readFileByLines() {

        List<String> clist = new ArrayList<>();
        File file = new File(System.getProperty("user.home") + "/Downloads/needRerun.csv");
        BufferedReader reader = null;
        try {
            LOGGER.info("以行为单位读取文件内容，一次读一整行：");
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;

            Set<Integer> set = Sets.newHashSet();
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                int id = Integer.valueOf(tempString);
                set.add(id);
            }

            System.out.println("======================================");
            for (Integer id : set) {
                System.out.println(id);
            }

            System.out.println("======================================");

            System.out.println(set.size());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return clist;
    }

}
