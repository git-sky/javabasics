package cn.com.sky.tools.test_poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExcelWriteDemo1 {

	public static void main(String[] args) {
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();
			XSSFSheet sheet = wb.createSheet("这里是第一页");
			// XSSFSheet sheet = workbook.getSheetAt(0);

			// 创建行
			Row row = sheet.createRow((short) 0);
			// 创建单元格，方法1
			Cell cell = row.createCell(0);
			cell.setCellValue(1);
			// 直接创建单元格，方法2
			row.createCell(1).setCellValue(1.2);
			row.createCell(2).setCellValue(createHelper.createRichTextString("大家好，我是xxx"));
			row.createCell(3).setCellValue(createHelper.createRichTextString("QQ：123456"));
			row.createCell(4).setCellValue(true);

			// 写入文件
			FileOutputStream fileOut;
			fileOut = new FileOutputStream("abc.xlsx");
			wb.write(fileOut);
			fileOut.close();
			System.out.println("写入成功，运行结束！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
