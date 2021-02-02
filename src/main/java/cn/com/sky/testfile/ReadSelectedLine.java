package cn.com.sky.testfile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class ReadSelectedLine {

    /**
     * 读取文件指定行。
     */
    public static void main(String[] args) throws IOException {

        String nameFile = System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads/mail.txt";

        // 指定读取的行号
        int lineNumber = 12;
        // 读取文件
        File sourceFile = new File(nameFile);
        // 读取指定的行
        readAppointedLineNumber(sourceFile, lineNumber);
        // 获取文件的内容的总行数
        System.out.println("总行数：" + getTotalLines(sourceFile));
    }

    // 读取文件指定行。
    static void readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = null;
        int line = 1;
        if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("不在文件的行数范围之内。");
        } else {

            System.out.println("当前行号为:" + reader.getLineNumber());

            reader.setLineNumber(lineNumber);
            System.out.println("更改后行号为:" + reader.getLineNumber());
            long i = reader.getLineNumber();
            while ((s = reader.readLine()) != null) {//更改行号，对实际读取位置没影响，所以此处还是读的第一条数据。
                System.out.println("s=" + s);
                line++;
                if (i == line) {
                    s = reader.readLine();
                    System.out.println(s);
                    break;
                }
            }
        }

        reader.close();
        in.close();

    }

    // 文件内容的总行数。
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
}// 最后一行
