package cn.com.sky.testfile;

/**
 *
 */

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class LineNumberReaderTest {


    public static void main(String[] args) throws Exception {

        File f = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads/mail.txt");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        int lineNumber = getFileLineNumber(f.getPath());

        System.out.println("the line number of specified file is " + lineNumber);
    }


    public static int getFileLineNumber(String filePath) throws Exception {


        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath));

        // it will return the number of characters actually skipped
        lineNumberReader.skip(0);

        int lineNumber = lineNumberReader.getLineNumber();

        lineNumber++;

        lineNumberReader.close();

        return lineNumber;
    }
}