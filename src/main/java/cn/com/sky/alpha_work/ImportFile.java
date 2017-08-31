package cn.com.sky.alpha_work;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImportFile {

	public static final Logger LOGGER =  LoggerFactory.getLogger(ImportFile.class);

	public static void main(String[] args) {

		readFileByLines();

	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static List<String> readFileByLines() {

		List<String> clist = new ArrayList<>();
		File file = new File("e:/a.txt");
		BufferedReader reader = null;
		try {
			LOGGER.info("以行为单位读取文件内容，一次读一整行：");
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 0;
//			System.out.print("array_name=(");
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
//				LOGGER.info("line " + line + ": " + tempString);
				// 显示行号
//				System.out.println("line " + line + ": " + tempString);
				
				String[] arr=tempString.split(",");
				String fileName=arr[0].trim();
				String merchantId=arr[2].trim();
				String merchantName=arr[1].trim()+"_返利";
				
				
				String exec="java -Xms256m -Xmx256m -XX:MaxPermSize=128m -DfileName=/gomeo2o/rebate/rebate-import/gome/"+fileName+" -DmerchantId="+merchantId+" -DmerchantName="+merchantName+"  -Dbegin=\"2016-10-01 00:00:00\" -Dend=\"2016-12-31 23:59:59\" -DtemplateId=3207 -Dfile.encoding=UTF-8  -Drebate.conf.path=/gomeo2o/rebate/rebate-import/conf -DprojectName=import -DappName=gome_rebate_config -classpath ./lib/*:./rebate-import-0.0.1-SNAPSHOT.jar cn.com.gome.rebate.ImportFile  >> /gomeo2o/rebate/rebate-import/info_result.log";
				
				System.out.println(exec+"");
				
				
				if ("".equals(tempString.trim())) {
					continue;
				}
				line++;
			}
//			System.out.println(")");

//			LOGGER.info("读取行数：" + line);
			System.out.println("读取行数：" + line);
			reader.close();
			// System.exit(0);
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

}
