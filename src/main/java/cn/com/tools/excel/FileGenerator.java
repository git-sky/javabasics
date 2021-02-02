package cn.com.tools.excel;

import cn.com.tools.excel.enums.FieldTypeEnum;
import cn.com.tools.excel.enums.FtlEnum;
import cn.com.tools.excel.enums.SCEnum;
import cn.com.tools.excel.model.ExcelField;
import cn.com.tools.excel.model.ExcelRoot;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件生成器
 *
 * @Author jialiangliu
 * @date Date : 2019年11月01日 6:31 PM
 */
public class FileGenerator {


    public static void writeJavaFile(ExcelRoot excelRoot, String targetPath, String targetPackagePath, FtlEnum ftl) throws TemplateException {
        makeDir(targetPath);
        Writer out = null;
        try {
            // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
            Configuration configuration = new Configuration(Configuration.getVersion());

            // 第二步：设置模板文件所在的路径。
            configuration.setClassForTemplateLoading(ExcelRoot.class, "/template");

            // 第三步：设置模板文件使用的字符集。一般就是utf-8.
            configuration.setDefaultEncoding("utf-8");

            // 第四步：加载一个模板，创建一个模板对象。
            Template template = configuration.getTemplate(ftl.getFtl());

            // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
            out = new FileWriter(new File(targetPath + excelRoot.getExcelName() + ".java"));

            // 第七步：调用模板对象的process方法输出文件。
            Map<String, Object> map = new HashMap<>();
            map.put("ExcelRoot", excelRoot);
            map.put("targetPackagePath", targetPackagePath);
            map.put("fieldTypes", FieldTypeEnum.values());
            template.process(map, out);

            // 生成子文件
            List<ExcelField> fieldList = excelRoot.getFieldList();
            for (ExcelField excelField : fieldList) {
                if (excelField.getFieldType() == FieldTypeEnum.OBJECT) {
                    ExcelRoot subRoot = new ExcelRoot();
                    subRoot.setExcelName(excelField.getGenericType());
                    subRoot.setFieldList(excelField.getSubFieldList());
                    writeJavaFile(subRoot, targetPath, targetPackagePath, ftl);
                } else if (excelField.getFieldType() == FieldTypeEnum.LIST) {
                    ExcelField subExcelField = excelField.getSubFieldList().get(0);
                    if (subExcelField.getFieldType() == FieldTypeEnum.OBJECT) {
                        ExcelRoot subRoot = new ExcelRoot();
                        subRoot.setExcelName(excelField.getListGenericType());
                        subRoot.setFieldList(subExcelField.getSubFieldList());
                        writeJavaFile(subRoot, targetPath, targetPackagePath, ftl);
                    }
                }
            }

            // 第八步：关闭流。
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 写json
     *
     * @param scEnum
     * @param excelRoot
     * @param targetPath
     */
    public static void writeJsonFile(SCEnum scEnum, ExcelRoot excelRoot, String targetPath) {

        makeDir(targetPath);

        Writer out = null;
        try {

            String s = excelRoot.toJsonArray(scEnum).toJSONString();
            out = new FileWriter(new File(targetPath + excelRoot.getExcelName() + ".json"));
            out.write(s);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getAllFileNameWithPath(String path, ArrayList<String> fileNameList) {
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                String suffiex = ExcelParser.getSuffiex(tempList[i].getName());
                if (!StringUtils.isBlank(suffiex) && (ExcelParser.OFFICE_EXCEL_XLS.equals(suffiex) || ExcelParser.OFFICE_EXCEL_XLSX.equals(suffiex))) {
                    fileNameList.add(tempList[i].getAbsolutePath());
                }
            }
            if (tempList[i].isDirectory()) {
                getAllFileNameWithPath(tempList[i].getAbsolutePath(), fileNameList);
            }
        }
    }


    public static void makeDir(String targetPath) {
        File file = new File(targetPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    public static void main(String[] args) {
        String[] arrays = {"app_config.xlsx", "package_config.xlsx", "uri_config.xlsx"};
        for (String arr : arrays) {
            String resourcesPath = "/Users/sky/Downloads/配置中心/" + arr;
            // targetPath路径后缀一定要有/
            String targetPath = "/Users/sky/Downloads/配置中心/";
            String packagePath = "com.sankuai.fe.game.servertree.auto.config";
            try {
                ExcelRoot excelRoot = ExcelParser.create(resourcesPath);
                ExcelRoot classRoot = excelRoot.genClassRoot();
                if (classRoot != null) {
                    FileGenerator.writeJavaFile(classRoot, targetPath, packagePath, FtlEnum.JAVA);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
