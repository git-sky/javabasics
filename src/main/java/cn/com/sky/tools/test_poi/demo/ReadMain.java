package cn.com.sky.tools.test_poi.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.storm.guava.collect.Lists;
import org.apache.storm.guava.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java -DinputFileName=ElkData_0501-08.csv  -DtemplateFileName=Plus-社交部分-428促销-监控数据.xlsx -DoutputFileName=out_Plus-社交部分-428促销-监控数据.xlsx -DsheetName=501  -Dbegin="2017-05-01 08:00:00" -Dend="2017-05-01 08:59:59" -Dfile.encoding=UTF-8  -Drebate.conf.path=/gomeo2o/rebate/rebate-import/conf -DprojectName=import -DappName=gome_rebate_config -classpath ./lib/*:./rebate-import-0.0.1-SNAPSHOT.jar cn.com.gome.rebate.PlatformShareFile  >> /gomeo2o/rebate/rebate-import/info_result.log

public class ReadMain {

	public static final Logger LOGGER = LoggerFactory.getLogger(ReadMain.class);

	static HashMap<String, List<String>> map = Maps.newHashMap();

	public static void main(String[] args) {
		Config config = new Config().invoke();

		readFile(config);
		outFile(config);

		System.exit(0);

	}

	public static List<String> readFile(Config config) {

		List<String> clist = new ArrayList<>();
		File file = new File(config.getInputFileName());
		BufferedReader reader = null;
		try {

			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 0;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				LOGGER.info("line " + line + ": " + tempString);
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				if ("".equals(tempString.trim())) {
					continue;
				}

				String[] arr = tempString.split(",");// 一行数据

				if (arr.length >= 5) {
					// 服务接口 总请求量 失败请求 平均响应时间（ms） 95Line(ms)

					String interfaces = arr[0].trim();
					String allRequsts = arr[1].trim();
					String failRequests = arr[2].trim();
					String avgTimes = arr[3].trim();
					String line95 = arr[4].trim();

					List<String> list = Lists.newArrayList();
					list.add(allRequsts);
					list.add(failRequests);
					list.add(avgTimes);
					list.add(line95);
					map.put(interfaces, list);

					line++;
				}
			}

			LOGGER.info("读取行数：" + line);
			System.out.println("读取行数：" + line);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

		return clist;
	}

	public static void outFile(Config config) {

		try {
			InputStream is = new FileInputStream(config.getTemplateFileName());
			XSSFWorkbook wb = new XSSFWorkbook(is);

			for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {// 遍历sheet页面
				XSSFSheet st = wb.getSheetAt(sheetIndex);
				System.out.println(st.getSheetName());
				if (!st.getSheetName().equalsIgnoreCase(config.getSheetName())) {
					continue;
				}
				System.out.println("时间段	服务接口	总请求量	失败请求	平均响应时间（ms）	95Line(ms) ");

				boolean findRow = false;
				for (int rowIndex = 0; rowIndex <= st.getLastRowNum(); rowIndex++) {
					XSSFRow row = st.getRow(rowIndex);
					XSSFCell cell0 = row.getCell(0);
					cell0.setCellType(XSSFCell.CELL_TYPE_STRING);
					String cell0Con = cell0.getStringCellValue();

					if (config.getDateFormat().equalsIgnoreCase(cell0Con)) {
						findRow = true;
					}
					if (!findRow) {
						continue;
					}

					XSSFCell cell1 = row.getCell(1);
					cell1.setCellType(XSSFCell.CELL_TYPE_STRING);
					String cell1Con = cell1.getStringCellValue();

					List<String> list = map.get(cell1Con);
					for (int i = 2; i < list.size() + 2; i++) {

						// content
						XSSFCell cell = row.getCell(i);
						cell.setCellType(XSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(list.get(i - 2));

					}

				}
			}

			// 默认导出
			FileOutputStream out = new FileOutputStream(config.getOutputFileName());
			wb.write(out);
			out.close();

		} catch (Exception e) {
			System.out.println("处理失败");
			e.printStackTrace();
		}
	}

	private static class Config {

		private String inputFileName;

		private String templateFileName;

		private String outputFileName;

		private String sheetName;

		private Date beginDate;
		private Date endDate;

		private String dateFormat;

		public String getDateFormat() {
			return dateFormat;
		}

		public void setDateFormat(String dateFormat) {
			this.dateFormat = dateFormat;
		}

		public String getInputFileName() {
			return inputFileName;
		}

		public void setInputFileName(String inputFileName) {
			this.inputFileName = inputFileName;
		}

		public String getTemplateFileName() {
			return templateFileName;
		}

		public void setTemplateFileName(String templateFileName) {
			this.templateFileName = templateFileName;
		}

		public String getOutputFileName() {
			return outputFileName;
		}

		public void setOutputFileName(String outputFileName) {
			this.outputFileName = outputFileName;
		}

		public Date getBeginDate() {
			return beginDate;
		}

		public void setBeginDate(Date beginDate) {
			this.beginDate = beginDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public String getSheetName() {
			return sheetName;
		}

		public void setSheetName(String sheetName) {
			this.sheetName = sheetName;
		}

		public Config invoke() {
			templateFileName = System.getProperty("templateFileName");
			outputFileName = System.getProperty("outputFileName");
			inputFileName = System.getProperty("inputFileName");
			sheetName = System.getProperty("sheetName");

			System.out.println(templateFileName);

			try {
				beginDate = DateUtils.parseDate(System.getProperty("begin"), "yyyy-MM-dd HH:mm:ss");
				endDate = DateUtils.parseDate(System.getProperty("end"), "yyyy-MM-dd HH:mm:ss");

				DateFormat df = new SimpleDateFormat("HH:mm");

				String beginDateFormat = df.format(beginDate);
				String endDateFormat = df.format(endDate);

				dateFormat = beginDateFormat + "-" + endDateFormat;

			} catch (ParseException e) {
				System.out.println("日期格式不正确!!!!!!!!");
				e.printStackTrace();
			}

			return this;
		}
	}
}