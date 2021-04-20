package cn.com.tools.excel;

import cn.com.tools.excel.enums.FieldTypeEnum;
import cn.com.tools.excel.enums.SCEnum;
import cn.com.tools.excel.model.ExcelField;
import cn.com.tools.excel.model.ExcelRoot;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * excel工具类
 */
public class ExcelParser {

    public static final String OFFICE_EXCEL_XLS = "xls";
    public static final String OFFICE_EXCEL_XLSX = "xlsx";

    public static String getCellContent(Cell cell, DataFormatter dataFormatter, FormulaEvaluator formulaEvaluator) {
        if (cell == null) {
            return null;
        }
        String content = dataFormatter.formatCellValue(cell, formulaEvaluator);
        return content.trim();
    }

    /**
     * 读取Excel并生成对应的ExcelRoot
     */
    @SneakyThrows
    public static ExcelRoot create(String filepath) {
        try {
            //读取格式
            Workbook workbook = getWorkbook(filepath);
            return generateExcelRoot(workbook);
        } catch (Exception e) {
//            BaseValidate.FAIL.throwException("parse excel error, please check the configuration format is correct!");
        }
        return null;
    }

    /**
     * 读取Excel并生成对应的ExcelRoot
     */
    @SneakyThrows
    public static ExcelRoot create(MultipartFile file) {
        try {
            //读取格式
            Workbook workbook = getWorkbook(file);
            return generateExcelRoot(workbook);
        } catch (Exception e) {
//            BaseValidate.FAIL.throwException("parse excel error, please check the configuration format is correct!");
        }
        return null;
    }

    /**
     * 读取Excel并生成对应的ExcelRoot
     */
    public static ExcelRoot generateExcelRoot(Workbook workbook)
            throws EncryptedDocumentException, InvalidFormatException, IOException {


        ExcelRoot excelRoot = new ExcelRoot();
        if (workbook != null) {
            workbook.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            evaluator.evaluateAll();
            DataFormatter dataFormatter = new DataFormatter();

            //获得列数量, 其他列可以没有, 但是类型一定要有
            Sheet sheet = workbook.getSheetAt(0);
            Row typeRow = sheet.getRow(2);
            int columNos = typeRow.getLastCellNum();
            for (int i = 0; i < columNos; i++) {
                //去掉空列
                String cellValue = typeRow.getCell(i).getStringCellValue();
                if (StringUtils.isEmpty(cellValue)) {
                    columNos = i - 1;
                    break;
                }
            }

            //获得有效行，按照第一列的内容check，遇到空行截止
            int rowNos = sheet.getLastRowNum();
            for (int i = 0; i <= rowNos; i++) {
                Row row = sheet.getRow(i);
                if(row == null){
                    //空行
                    rowNos = i - 1;
                    break;
                }

                Cell cell = row.getCell(0);
                String content = ExcelParser.getCellContent(cell, dataFormatter, evaluator);

                try {
                    int i1 = Integer.parseInt(content);
                    if (i1 == 0) {
                        rowNos = i - 1;
                        break;
                    }
                } catch (NumberFormatException e) {
                }


                if (StringUtils.isEmpty(content)) {
                    rowNos = i - 1;
                    break;
                }
            }


            //解析每列
            List<ExcelField> fieldList = new ArrayList<>();
            for (int i = 0; i < columNos; ) {
                Cell typeRowCell = typeRow.getCell(i);
                if (typeRowCell == null || StringUtils.isEmpty(getCellContent(typeRowCell, dataFormatter, evaluator))) {
                    System.out.println("parse on row :" + i);
                    break;
                }
                ExcelField excelField = new ExcelField();
                excelField.setRoot(excelRoot);
                fieldList.add(excelField);
                i = parseExcelField(excelField, sheet, i, dataFormatter, evaluator, rowNos);
            }

            excelRoot.setFieldList(fieldList);
            excelRoot.setContentRowNum(rowNos - 3);

            String sheetName = sheet.getSheetName();
            excelRoot.setExcelName(sheetName);

        }

        return excelRoot;
    }

    private static String toLowerCaseFirstOne(String s) {
        if (StringUtils.isEmpty(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }


    private static String toUpperCaseFirstOne(String s) {
        if (StringUtils.isEmpty(s)) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    private static String getStrValFromCell(Row row, int columnNum, String defaultStr, DataFormatter dataFormatter, FormulaEvaluator evaluator) {
        Cell cell = row.getCell(columnNum);
        if (cell != null) {
            return getCellContent(cell, dataFormatter, evaluator);
        }
        return defaultStr;
    }

    /**
     * 解析Excel
     * <p>
     * <p>
     * Note:
     * <p>
     * 几种配表的方式:
     * 1.基础类型 int long string
     * 列=> |1     |2     |3       |4      |5      |
     * 值=> |int   |long  |string  |double |float  |
     * 行=> |1     |2     |s       |25.1   |5.2    |
     * 直接配置即可
     * <p>
     * <p>
     * <p>
     * 2.对象<Object>:
     * 列=> |1           |2       |3       |4      |5      |
     * 值=> |FuncData.(  |int     |string  |int    |string)|
     * 行=> |            |1       |s       |2      |v      |
     * 子类型用 "." 隔开, "FuncData.(" 表示对象FuncData的内容从(开始, int值为第一个字段的类型，可以是任意类型,后面的字段每一个都作为本对象的内容，直到)结束
     * <p>
     * <p>
     * <p>
     * 2.基础对象列表list<integer>:
     * 列=> |1           |2       |3       |4      |5    |
     * 值=> |int.[       |int     |int     |int    |int] |
     * 行=> |            |1       |2       |2      |3    |
     * int.[ 表示接下来的内容为子类型int的数组, 从第2列开始未数组的内容，直到第一个]结束.
     * <p>
     * <p>
     * <p>
     * 3.复杂对象列表list<Object>:
     * 列=> |1           |2       |3       |4      |5      |6     |7      |8     |9        |
     * 值=> |FuncData.[  |(int    |string  |int    |string)|(int  |string |int   |string)] |
     * 行=> |            |1       |v       |2      |s      |1     |v      |2     |z        |
     * FuncData.[ 表示接下来的内容为子类型FuncData的数组, 第2列开始的(表示这个数组的第一个FuncData对象开始，直到)结束，整个数组持续到第一个]结束.
     * <p>
     * <p>
     * <p>
     * 4.枚举<enum>:
     * 列=> |1           |2             |3           |
     * 值=> |enum.id     |enum.key      |enum.string |
     * 行=> |1           |PLAYER_LOGIN  |玩家登录场景  |
     * 当类型头为"enum."时，代表这个字段是个枚举值
     * 一个枚举最少有两个字段"id,key"才可以生成枚举对象，其中id代表枚举的索引，必须为int型，key必须为string型，代表枚举的内容.
     * 一个excel中被标注为枚举的内容，除enum.id外不会再序列化到对应class中，只会保留一个枚举id字段，如果excel中全部为枚举字段，则只生成枚举类.
     * 枚举中的字段仅支持基础类型以及基础类型的list, 如list<Integer>, 目前不支持自定义对象
     *
     * @param excelField       当前字段
     * @param sheet            当前页签
     * @param currentColumnNum 当前列号
     * @param rowNos           有效行号 从0开始
     * @return
     */
    private static int parseExcelField(ExcelField excelField, Sheet sheet, int currentColumnNum, DataFormatter dataFormatter, FormulaEvaluator evaluator, int rowNos) {
        try {

            //System.out.println(currentColumnNum);
            //注释，名称，类型，域
            Row annotationRow = sheet.getRow(0);
            Row nameRow = sheet.getRow(1);
            Row typeRow = sheet.getRow(2);
            Row areaRow = sheet.getRow(3);


            //注释内容
            String annotation = getStrValFromCell(annotationRow, currentColumnNum, "", dataFormatter, evaluator);
            //原始字段名称
            String originName = getStrValFromCell(nameRow, currentColumnNum, "", dataFormatter, evaluator);
            //域类型 sc s c
            String area = getStrValFromCell(areaRow, currentColumnNum, "", dataFormatter, evaluator);
            //字段类型
            String typeName = getStrValFromCell(typeRow, currentColumnNum, "", dataFormatter, evaluator);
            //对象类型名
            String objectTypeName = null;

            //当前字段是否为枚举字段
            boolean isEnumField = false;
            //当前字段是否为枚举id字段
            boolean isEnumIndexField = false;
            //当前字段是否为枚举key字段
            boolean isEnumKeyField = false;
            //当前字段类型
            FieldTypeEnum fieldType = null;
            //如果当前字段是列表类型，这里为对应的子类型
            FieldTypeEnum listFieldType = null;

            //解析类型
            boolean isListObjectStart = typeName.startsWith(FieldTypeEnum.OBJECT.getExcelName());
            if (isListObjectStart) {
                //去掉开头的( et: (int (FuncData.(    (FuncData.[
                typeName = typeName.substring(1, typeName.length());
            }

            //处理头的情况
            boolean containsSubType = typeName.contains(".");
            if (containsSubType) {
                //有子类型 et: FuncData.( int.[ FuncData.[
                String[] split = typeName.split("\\.");
                objectTypeName = split[0];
                String endType = split[1];

                if (objectTypeName.equals(FieldTypeEnum.ENUM.getExcelName())) {
                    //枚举
                    isEnumField = true;

                    if (endType.equals(FieldTypeEnum.ENUM.getExcelEndName())) {
                        fieldType = FieldTypeEnum.INT;
                        isEnumIndexField = true;
                    } else if (endType.equals(FieldTypeEnum.ENUM.getExcelEnumKey())) {
                        fieldType = FieldTypeEnum.STRING;
                        isEnumKeyField = true;
                    }

                    objectTypeName = endType;
                    if (split.length > 2) {
                        //这是个list enum.int.[  重写参数 后面按照int.[来解析
                        endType = split[2];
                        if (!endType.equals(FieldTypeEnum.LIST.getExcelName())) {
                            //只支持list
                            throw new RuntimeException("enum field only support simple list:" + typeName);
                        }
                    }

                    if (fieldType == null) {
                        fieldType = FieldTypeEnum.findFieldTypeByExcelName(objectTypeName);
                    }
                }

                if (endType.equals(FieldTypeEnum.LIST.getExcelName())) {
                    //列表
                    fieldType = FieldTypeEnum.LIST;

                    //如果子类型不是基础类型，则为对应的对象类型
                    listFieldType = FieldTypeEnum.findFieldTypeByExcelName(objectTypeName);
                    if (listFieldType == null) {
                        listFieldType = FieldTypeEnum.OBJECT;
                    }
                } else if (endType.equals(FieldTypeEnum.OBJECT.getExcelName())) {
                    //只是一个子类
                    fieldType = FieldTypeEnum.OBJECT;
                }

                if (fieldType == null) {
                    throw new RuntimeException("unknow type:" + typeName);
                }

            } else {
                //处理尾的情况, 从左到右依次找到对应的终止符 ])
                ExcelField target = excelField.getOwner();
                for (char t : typeName.toCharArray()) {
                    if (FieldTypeEnum.OBJECT.getExcelEndName().charAt(0) == t || FieldTypeEnum.LIST.getExcelEndName().charAt(0) == t) {
                        //每找到一个，就标记为终止，并指向上级
                        target.setFinish(true);
                        target = target.getOwner();
                    }
                }

                //去掉所有的终止符，获取真实的类型
                typeName = typeName.replace(FieldTypeEnum.OBJECT.getExcelEndName(), "");
                typeName = typeName.replace(FieldTypeEnum.LIST.getExcelEndName(), "");

                fieldType = FieldTypeEnum.findFieldTypeByExcelName(typeName);
            }

            System.out.println("coloumn " + currentColumnNum + " parse field :" + typeName + ", get type:" + fieldType);

            //如果是列表类型或者对象，这里是对应的字段容器
            List<ExcelField> subFieldList = null;


            //根据字段类型封装对象
            switch (fieldType) {
                case INT:
                case LONG:
                case STRING:
                case BOOL:
                case DOUBLE:
                case FLOAT:
                    break;
                case ENUM: {
                    //不存在单纯的enum类型
                    throw new RuntimeException("unknow type:" + typeName);
                }
                //单个对象类型
                case OBJECT: {
                    currentColumnNum++;
                    subFieldList = new ArrayList<>();

                    //循环创建，直到对象解析完毕
                    while (!excelField.isFinish()) {
                        ExcelField subExcelField = new ExcelField();
                        subExcelField.setRoot(excelField.getRoot());
                        subExcelField.setOwner(excelField);
                        subFieldList.add(subExcelField);

                        currentColumnNum = parseExcelField(subExcelField, sheet, currentColumnNum, dataFormatter, evaluator, rowNos);
                    }
                    currentColumnNum--;
                    break;
                }

                //列表类型
                case LIST: {
                    currentColumnNum++;
                    subFieldList = new ArrayList<>();

                    //循环创建，直到对象解析完毕
                    while (!excelField.isFinish()) {
                        ExcelField subExcelField = new ExcelField();
                        subExcelField.setRoot(excelField.getRoot());
                        subExcelField.setOwner(excelField);

                        if (listFieldType == FieldTypeEnum.OBJECT) {
                            //子对象不是基本对象，需要初始化
                            //这个field本身不是一个有数据的列，只是一个结构化的节点
                            subExcelField.setOwner(excelField);
                            subExcelField.setFieldName(toLowerCaseFirstOne(objectTypeName));
                            subExcelField.setFieldType(FieldTypeEnum.OBJECT);
                            subExcelField.setAnnotation("");
                            subExcelField.setScEnum(SCEnum.excelNameOf(area));
                            subExcelField.setAreaType(area);

                            List<ExcelField> listSubField = new ArrayList<>();
                            subExcelField.setSubFieldList(listSubField);
                            //装载子对象各个字段的内容
                            while (!subExcelField.isFinish()) {
                                ExcelField objectInnerField = new ExcelField();
                                objectInnerField.setRoot(excelField.getRoot());
                                objectInnerField.setOwner(subExcelField);
                                listSubField.add(objectInnerField);
                                currentColumnNum = parseExcelField(objectInnerField, sheet, currentColumnNum, dataFormatter, evaluator, rowNos);
                            }
                        } else {
                            //基本对象，直接装载即可
                            currentColumnNum = parseExcelField(subExcelField, sheet, currentColumnNum, dataFormatter, evaluator, rowNos);
                        }

                        subFieldList.add(subExcelField);
                    }
                    currentColumnNum--;
                    break;
                }
                default:
                    throw new IllegalArgumentException("type is illegal," + typeName);
            }

            //填充内容
            List list = new ArrayList();
            if (fieldType != FieldTypeEnum.LIST && fieldType != FieldTypeEnum.OBJECT) {
                //这两种情况不需要填充内容
                for (int r = 4; r <= rowNos; r++) {
                    Row row = sheet.getRow(r);
                    Cell cell = row.getCell(currentColumnNum);

                    String content = getCellContent(cell, dataFormatter, evaluator);
                    if (content == null) {
                        content = "";
                    }
                    list.add(fieldType.toJavaObject(content));
                }
            }

            //初始化当前字段
            excelField.setAnnotation(annotation);
            excelField.setFieldName(toLowerCaseFirstOne(originName));
            if (listFieldType != null) {
                excelField.setListGenericType(listFieldType == FieldTypeEnum.OBJECT ? toUpperCaseFirstOne(objectTypeName) : listFieldType.getJavaName());
            }
            excelField.setScEnum(SCEnum.excelNameOf(area));
            excelField.setAreaType(area);
            excelField.setFieldType(fieldType);
            excelField.setSubFieldList(subFieldList);
            excelField.setContentList(list);

            if (isEnumField) {
                //枚举字段特殊处理，需要把字段存入root
                excelField.setEnum(isEnumField);
                excelField.setEnumIndex(isEnumIndexField);
                excelField.setEnumKey(isEnumKeyField);
                ExcelRoot root = excelField.getRoot();
                root.getEnumFieldList().add(excelField);
            }

            //设置字段类型名
            excelField.setGenericType(fieldType == FieldTypeEnum.OBJECT ? toUpperCaseFirstOne(objectTypeName) : fieldType.getJavaName());

            return currentColumnNum + 1;
        } catch (Exception e) {
            System.out.println("wrong on column : " + currentColumnNum);
            throw e;
        }
    }

    /**
     * 根据文件路径获取Workbook对象
     *
     * @param filepath 文件全路径
     */
    public static Workbook getWorkbook(String filepath)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        InputStream is = null;
        Workbook wb = null;
        if (StringUtils.isBlank(filepath)) {
            throw new IllegalArgumentException("文件路径不能为空");
        } else {
            String suffiex = getSuffiex(filepath);
            if (StringUtils.isBlank(suffiex)) {
                throw new IllegalArgumentException("文件后缀不能为空");
            }
            if (OFFICE_EXCEL_XLS.equals(suffiex) || OFFICE_EXCEL_XLSX.equals(suffiex)) {
                try {
                    is = new FileInputStream(filepath);
                    wb = WorkbookFactory.create(is);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("该文件非Excel文件");
            }
        }
        return wb;
    }



    /**
     * 根据文件路径获取Workbook对象
     *
     * @param file 文件
     */
    public static Workbook getWorkbook(MultipartFile file) throws EncryptedDocumentException, IOException {
        InputStream is = null;
        Workbook wb = null;
        if (file == null) {
            throw new IllegalArgumentException("文件不能为空");
        } else {
            String suffiex = getSuffiex(file.getOriginalFilename());
            if (StringUtils.isBlank(suffiex)) {
                throw new IllegalArgumentException("文件后缀不能为空");
            }
            if (OFFICE_EXCEL_XLS.equals(suffiex) || OFFICE_EXCEL_XLSX.equals(suffiex)) {
                try {
                    is = file.getInputStream();
                    wb = WorkbookFactory.create(is);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("该文件非Excel文件");
            }
        }
        return wb;
    }

    /**
     * 获取后缀
     *
     * @param filepath filepath 文件全路径
     */
    public static String getSuffiex(String filepath) {
        if (StringUtils.isBlank(filepath)) {
            return "";
        }
        int index = filepath.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        return filepath.substring(index + 1, filepath.length());
    }

    public static void readTitle(String srcFile) {
        File file = new File(srcFile);
        String name = file.getName();
    }


}
