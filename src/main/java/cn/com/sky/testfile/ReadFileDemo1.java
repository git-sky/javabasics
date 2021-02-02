package cn.com.sky.testfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDemo1 {

    /**
     * 获取错误文件中的记录号
     *
     * @param sourceFile
     * @return
     */
    public static int[] readBadFile(String sourceFile) {
        FileReader in = null;
        LineNumberReader reader = null;
        int[] array = new int[0];
        try {
            //获取文件总行数
            long totalLine = Files.lines(Paths.get(sourceFile)).count();
            //构建数组
            array = new int[(int) (totalLine)];
            in = new FileReader(sourceFile);
            reader = new LineNumberReader(in);
            String s = reader.readLine();
            int i = 0;
            while (s != null) {
                System.out.println(s);
                int index = s.indexOf(":");
                array[i++] = Integer.parseInt(s.substring(2, index)) + 1;
                s = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResource(in, reader);
        }
        return array;
    }

    /**
     * 读取文件指定行数(读取一行)
     *
     * @param filePath
     * @param lineNumber
     */
    public static String readAppointedLineNumber(String filePath, int lineNumber) {
        String appointedLine = "";
        FileReader in = null;
        LineNumberReader reader = null;
        try {
            in = new FileReader(filePath);
            reader = new LineNumberReader(in);
            long totalLine = Files.lines(Paths.get(filePath)).count();
            if (lineNumber < 0 || lineNumber > totalLine) {
                return "指定行【" + lineNumber + "】不在文件行数范围内";
            }
            int line = 1;
            reader.setLineNumber(lineNumber);
            long i = reader.getLineNumber();
            String s = "";
            while ((s = reader.readLine()) != null) {
                if (i == line) {
                    appointedLine = s;
                    break;
                }
                line++;
            }
            return appointedLine;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(in, reader);
        }
        return appointedLine;
    }

    /**
     * 读取文件指定行数(读取多行)
     *
     * @param filePath
     * @param lineArray
     */
    public static List<String> readAppointedLineNumberArray(String filePath, int[] lineArray) {
        FileReader in = null;
        LineNumberReader reader = null;
        List<String> resultStr = new ArrayList<String>();
        //对数组按从小到大排序
        lineArray = sortArray(lineArray);
        if (lineArray.length == 0) {
            return new ArrayList<String>();
        }
        try {
            in = new FileReader(filePath);
            reader = new LineNumberReader(in);
            int lineNumber = lineArray.length;
            int line = 1;
            int i = 0;
            String s = "";
            while ((s = reader.readLine()) != null) {
                if (i < lineNumber && line == lineArray[i]) {
                    i++;
                    System.out.println(s);
                    resultStr.add(s);
                }
                line++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(in, reader);
        }
        return resultStr;
    }


    /**
     * 关闭资源
     *
     * @param in
     * @param reader
     */
    public static void closeResource(FileReader in, LineNumberReader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}