package cn.com.sky.testfile;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Ex7 {


    public void dataReader(String nameFile, int start, int finish) {
        if (start > finish) {
            System.out.println("Error start or finish!");
            return;
        }
        InputStream inputStream = null;
        LineNumberReader reader = null;
        try {
            inputStream = new FileInputStream(new File(nameFile));
            reader = new LineNumberReader(
                    new InputStreamReader(inputStream));
            int lines = getTotalLines(new File(nameFile));
            if (start < 0 || finish < 0 || finish > lines || start > lines) {
                System.out.println("Line not found!");
                return;
            }

            String line = reader.readLine();
            lines = 0;
            while (line != null) {
                lines++;
                if (lines >= start && lines <= finish) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }
            inputStream.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Error");
            System.exit(0);
        }

    }

    private int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String line = reader.readLine();
        int lines = 0;
        while (line != null) {
            lines++;
            line = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    public static void main(String[] args) {
        String nameFile = System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads/mail.txt";

        new Ex7().dataReader(nameFile, 2, 4);
        System.out.println("========================================================");
        new Ex7().dataReader(nameFile, 3, 8);
    }

}