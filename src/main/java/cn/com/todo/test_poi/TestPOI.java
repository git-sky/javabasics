package cn.com.todo.test_poi;

/*
 * POI�÷�
 */

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class TestPOI {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// ����һ��EXCEL
		Workbook wb = new HSSFWorkbook();
		DataFormat format = wb.createDataFormat();
		CellStyle style;
		// ����һ��SHEET
		Sheet sheet1 = wb.createSheet("��Ʒ�嵥");
		String[] title = { "���", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����", "��������", "����", "�Ƿ����" };
		int i = 0;
		// ����һ��
		Row row = sheet1.createRow((short) 0);
		// ������
		for (String s : title) {
			Cell cell = row.createCell(i);
			cell.setCellValue(s);
			i++;
		}
		Row row1 = sheet1.createRow((short) 1);
		// �������������
		row1.createCell(0).setCellValue(20071001);
		row1.createCell(1).setCellValue("������");
		// ����һ����Ԫ����
		Cell cell2 = row1.createCell(2);
		// ����Ʒ�۸�
		cell2.setCellValue(2.45);
		style = wb.createCellStyle();
		style.setDataFormat(format.getFormat("#.##"));
		// �趨��ʽ
		cell2.setCellStyle(style);
		// ����Ʒ����
		row1.createCell(3).setCellValue(200);
		/**
		 * ������ʾ���ڵĹ�����ʽ ��:yyyy-MM-dd hh:mm
		 * */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newdate = sdf.format(new Date());
		// ����������
		row1.createCell(4).setCellValue(newdate);
		row1.createCell(5).setCellValue("��������");
		/**
		 * ��ʾ����ֵ
		 * */
		row1.createCell(6).setCellValue(true);
		/**
		 * �ϲ���Ԫ�� ͨ��writablesheet.mergeCells(int x,int y,int m,int n);��ʵ�ֵ�
		 * ��ʾ��first row, last row,first column,last column
		 * 
		 * */
		Row row2 = sheet1.createRow((short) 2);
		Cell cell3 = row2.createCell((short) 0);
		cell3.setCellValue("�ϲ���������Ԫ��");
		sheet1.addMergedRegion(new CellRangeAddress(2, 2, 0, 2));

		FileOutputStream fileOut = new FileOutputStream("f:\\test_poi.xls");
		wb.write(fileOut);
		fileOut.close();
	}
}