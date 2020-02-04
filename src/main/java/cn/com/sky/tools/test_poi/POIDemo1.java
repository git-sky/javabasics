package cn.com.sky.tools.test_poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String fin = "f:/a.xlsx";
            String fout = "f:/b.xlsx";
            InputStream fis = new FileInputStream(new File(fin));
            OutputStream fos = new FileOutputStream(new File(fout));
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row r = sheet.createRow(1);
            Cell c = r.createCell(0);
            c.setCellValue("aaaaaa");

            wb.write(fos);
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
