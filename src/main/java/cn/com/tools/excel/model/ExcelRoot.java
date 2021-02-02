package cn.com.tools.excel.model;

import cn.com.tools.excel.enums.FieldTypeEnum;
import cn.com.tools.excel.enums.SCEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author jialiangliu
 * @date Date : 2019年11月01日 5:11 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelRoot {

    /**
     * 字段列表
     */
    private List<ExcelField> fieldList = new ArrayList<>();

    /**
     * 表名字
     */
    private String excelName;

    /**
     * 内容行数
     */
    private int contentRowNum;

    /**
     * 枚举字段列表
     */
    private List<ExcelField> enumFieldList = new ArrayList<>();


    public JSONArray toJsonArray(SCEnum scEnum) {
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < contentRowNum; i++) {

            JSONObject jsonObject = new JSONObject();

            for (int j = 0; j < fieldList.size(); j++) {
                ExcelField excelField = fieldList.get(j);
                excelField.toJson(scEnum, jsonObject, i);
            }

            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    public JSONArray toHeadJsonArray() {
        JSONArray array = new JSONArray();
        for (ExcelField field : fieldList) {
            JSONObject item = new JSONObject();
            field.toHeadJson(item);
            array.add(item);
        }
        return array;
    }

    /**
     * 生成枚举的构造方法签名
     *
     * @param colunmNum
     * @return
     */
    public String getEnumVal(int colunmNum) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        for (int i = 0; i < fieldList.size(); i++) {
            ExcelField excelField = fieldList.get(i);

            if (excelField.getFieldType() == FieldTypeEnum.LIST) {
                stringBuffer.append("Arrays.asList(");
                int length = stringBuffer.length();
                List<ExcelField> subFieldList = excelField.getSubFieldList();
                for (int i1 = 0; i1 < subFieldList.size(); i1++) {
                    ExcelField subField = subFieldList.get(i1);
                    if (subField.getFieldType() == FieldTypeEnum.LIST || subField.getFieldType() == FieldTypeEnum.OBJECT) {
                        continue;
                    }

                    Object subVal = subField.getContentList().get(colunmNum);
                    if (subVal == null) {
                        continue;
                    }

                    if (subVal instanceof Integer) {
                        if ((int) subVal == 0) {
                            continue;
                        }
                    }
                    if (subVal instanceof String) {
                        String subVal1 = (String) subVal;
                        if (StringUtils.isEmpty(subVal1)) {
                            continue;
                        }

                        subVal = ("\"" + subVal1 + "\"");
                    }
                    stringBuffer.append(subVal).append(",");
                }
                if (stringBuffer.length() > length) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                stringBuffer.append(")");
            } else {
                Object value = excelField.getContentList().get(colunmNum);
                if (excelField.isEnumKey()) {
                    stringBuffer.insert(0, value);
                    continue;
                } else {
                    if (excelField.getFieldType() == FieldTypeEnum.STRING) {
                        stringBuffer.append("\"");
                    }
                    stringBuffer.append(value);
                    if (excelField.getFieldType() == FieldTypeEnum.STRING) {
                        stringBuffer.append("\"");
                    }
                }
            }

            if (i < fieldList.size() - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(")");

        return stringBuffer.toString();
    }

    public void test() {
        for (int i = 0; i < contentRowNum; i++) {
            String enumVal = getEnumVal(i);
            System.out.println(enumVal);
        }
    }

    /**
     * 生成class Root
     *
     * @return
     */
    public ExcelRoot genClassRoot() {
        if (enumFieldList.size() == fieldList.size()) {
            //都是枚举字段，不生成javaClass了
            return null;
        }

        //过滤掉枚举字段
        List<ExcelField> excelFields = new ArrayList<>();
        for (ExcelField excelField : fieldList) {
            if (excelField.isEnum() && !excelField.isEnumIndex()) {
                //非索引的枚举字段不参与生成class
                continue;
            }
            excelFields.add(excelField);
        }

        ExcelRoot excelRoot = new ExcelRoot();
        excelRoot.setExcelName(excelName);
        excelRoot.setFieldList(excelFields);
        excelRoot.setContentRowNum(contentRowNum);
        return excelRoot;
    }

    /**
     * 生成枚举root
     *
     * @return
     */
    public ExcelRoot genEnumRoot() {
        if (enumFieldList.isEmpty()) {
            return null;
        }

        boolean hasKey = false;
        boolean hasIndex = false;
        for (ExcelField excelField : enumFieldList) {
            if (excelField.isEnumIndex()) {
                hasIndex = true;
            }
            if (excelField.isEnumKey()) {
                hasKey = true;
            }
        }
        if (!hasIndex || !hasKey) {
            return null;
        }

        ExcelRoot excelRoot = new ExcelRoot();
        excelRoot.setExcelName("E" + excelName);
        excelRoot.setFieldList(enumFieldList);
        excelRoot.setContentRowNum(contentRowNum);
        return excelRoot;
    }
}
