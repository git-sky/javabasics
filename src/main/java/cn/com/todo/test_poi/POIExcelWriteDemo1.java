package cn.com.todo.test_poi;

/*
 * POI�÷�
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExcelWriteDemo1
{
 
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        try
        {
        	XSSFWorkbook wb = new XSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            XSSFSheet sheet = wb.createSheet("�����ǵ�һҳ");
           // XSSFSheet sheet = workbook.getSheetAt(0); 
 
            // ������
            Row row = sheet.createRow((short) 0);
            // ������Ԫ�񣬷���1
            Cell cell = row.createCell(0);
            cell.setCellValue(1);
            // ֱ�Ӵ�����Ԫ�񣬷���2
            row.createCell(1).setCellValue(1.2);
            row.createCell(2)
                    .setCellValue(createHelper.createRichTextString("��Һã����Ǹߺ�ΰ"));
            row.createCell(3).setCellValue(
                    createHelper.createRichTextString("QQ��21807822"));
            row.createCell(4).setCellValue(true);
 
            // д���ļ�
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("f:/gaohw.xlsx");
            wb.write(fileOut);
            fileOut.close();
            System.out.println("д��ɹ������н�����");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
