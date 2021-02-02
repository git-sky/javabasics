//package cn.com.sky.tools.test_poi;
//
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.ss.usermodel.*;
//
//import java.io.File;
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//public class TestPoi2 {
//    public static void main(String[] args) {
//
//        File tempExcel = new File("a.xlsx");
//
//        Workbook workbook;
//        try {
//            workbook = WorkbookFactory.create(tempExcel);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
//
//        Sheet sheet = workbook.getSheetAt(0);
//
//        int lastRowNum = sheet.getLastRowNum();
//        System.out.println("lastRowNum=" + lastRowNum);
//        for (int i = 0; i < lastRowNum; i++) {
//            Row row = sheet.getRow(i);
//            if (row == null) {
//                continue;
//            }
//
//
//            //品牌id，品牌名称，品牌别名，品牌logo，品牌官网，品牌官方电话，品牌加盟电话，品牌创立时间，品牌标语，品牌介绍，品牌故事
//            String dateStr = getCellValue(row.getCell(0));
//            String date = getCellValue(row.getCell(1));
//
//            System.out.println("date:" + date);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            try {
//                Date d = sdf.parse(date);
//                System.out.println("日期：" + d);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }
//
//
//    private static String getCellValue(Cell cell) {
//        if (cell == null) {
//            return null;
//        }
//
//        try {
//            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//
//                if (DateUtil.isCellDateFormatted(cell)) {
//
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//                    String s = sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
//                    System.out.println(s);
//
//                    return s;
//
////                    double value = cell.getNumericCellValue();
////                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
////
////                    System.out.println(date);
//                }
//
//                System.out.println("sss");
//                DecimalFormat df = new DecimalFormat("#");
//                return df.format(cell.getNumericCellValue());
//            }
//
//
//            return cell.getStringCellValue().trim();
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//}
