package cn.com.sky.basics.test_file;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class FileTest2 {

    public FileTest2() {
    }

    @Test
    public void readFile() {


        long beginTime = System.currentTimeMillis();

        int begin = 0;
        int end = begin + 140000;

        while (begin < Integer.MAX_VALUE - 10) {

            List<Long> userIds = batch(begin, end);

            if (CollectionUtils.isEmpty(userIds)) {
                System.out.println("run over!!!");
                break;
            }

            write(userIds, begin);

            begin = end;
            end = begin + 140000;
        }

        System.out.println("FileOutputStream执行耗时:" + (System.currentTimeMillis() - beginTime) + " 豪秒");
    }

    public List<Long> batch(int begin, int end) {
        if (begin >= end) {
            return Lists.newArrayList();
        }

        int row = -1;

        List<Long> userIds = Lists.newArrayList();
        BufferedReader br = null;
        try {
            File file = new File("add.txt");
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                if (StringUtils.isBlank(line)) {
                    System.out.println("isBlank");
                    continue;
                }
                if (!StringUtils.isNumeric(line)) {
                    System.out.println("isNumeric");
                    continue;
                }
                row++;
                if (row < begin) {
                    continue;
                }
                if (row >= end) {
                    break;
                }

                System.out.println(Long.valueOf(line));
                userIds.add(Long.valueOf(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userIds;
    }


    public void write(List<Long> userIds, int beginFile) {

        FileOutputStream out = null;

        try {
            File file = new File("add_" + beginFile + ".txt");
            out = new FileOutputStream(file);

            long begin = System.currentTimeMillis();
            for (Long userId : userIds) {
                out.write(String.valueOf(userId).getBytes(Charset.forName("utf-8")));
                out.write("\r\n".getBytes());
            }
            out.close();

            long end = System.currentTimeMillis();

            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 豪秒");

            System.out.println(file.length());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        FileOutputStream out = null;

        long count = 1000000;
        long initial = 10000000;

        try {
            out = new FileOutputStream(new File("add.txt"));

            long begin = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                long number = initial + i;
                out.write(String.valueOf(number).getBytes(Charset.forName("utf-8")));
                out.write("\r\n".getBytes());
            }
            out.close();

            long end = System.currentTimeMillis();

            System.out.println("FileOutputStream执行耗时:" + (end - begin) + " 豪秒");

            File file = new File("add.txt");
            System.out.println(file.length());


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}