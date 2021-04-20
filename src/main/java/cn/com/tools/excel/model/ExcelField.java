package cn.com.tools.excel.model;

import cn.com.tools.excel.enums.FieldTypeEnum;
import cn.com.tools.excel.enums.SCEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * excel字段
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelField {

    /**
     * 当前字段的根字段
     */
    private ExcelField owner;

    /**
     * excel的根
     */
    private ExcelRoot root;

    /**
     * 字段类型
     */
    private FieldTypeEnum fieldType;

    /**
     * 字段类型名称，当fieldType = FieldTypeEnum.OBJECT 时取子类名称，否则取fieldType.javaName
     */
    private String genericType;

    /**
     * 字段子列,{{@link FieldTypeEnum}
     * 当fieldType = FieldTypeEnum.OBJECT 时, 描述一个对象的所有字段
     * 当fieldType = FieldTypeEnum.LIST 时, 描述列表的每个值
     */
    private List<ExcelField> subFieldList;

    /**
     * 字段子列类型, 当fieldType = FieldTypeEnum.LIST 时有效, 泛型描述
     */
    private String listGenericType;

    /**
     * 字段注释
     */
    private String annotation;

    /**
     * 字段名字
     */
    private String fieldName;

    /**
     * SCEnum {{@link SCEnum} 字段所属,s服务器,c客户端,sc两个都有
     */
    private SCEnum scEnum;

    /**
     * {{@link SCEnum} 字段所属,s服务器,c客户端,sc两个都有
     */
    private String areaType;

    /**
     * 字段值 {{@link FieldTypeEnum} 其中的一种}
     */
    private List contentList;

    /**
     * 是否已经完成初始化
     */
    private boolean isFinish = false;

    /**
     * 是否是枚举
     */
    private boolean isEnum = false;

    /**
     * 是否是枚举id
     */
    private boolean isEnumIndex = false;

    /**
     * 是否是枚举key
     */
    private boolean isEnumKey = false;

    public void toJsonArray(SCEnum scEnum, JSONArray jsonArray, int row) {
        if (!this.scEnum.hasIntersect(scEnum)) {
            return;
        }

        if (fieldType == FieldTypeEnum.OBJECT) {
            JSONObject jsonObject = new JSONObject();
            for (ExcelField subExcelType : subFieldList) {
                subExcelType.toJson(scEnum, jsonObject, row);
            }
            jsonArray.add(jsonObject);
        } else if (fieldType == FieldTypeEnum.LIST) {
            JSONArray jsonArray1 = new JSONArray();
            for (ExcelField subExcelType : subFieldList) {
                subExcelType.toJsonArray(scEnum, jsonArray1, row);
            }
            jsonArray.add(jsonArray1);
        } else {
            //字段为空时，不注入参数
            Object content = contentList.get(row);
            if(content != null){
                jsonArray.add(content);
            }
        }
    }

    public void toJson(SCEnum scEnum, JSONObject jsonObject, int row) {

        if (!scEnum.hasIntersect(this.scEnum)) {
            return;
        }

        if (fieldType == FieldTypeEnum.LIST) {
            //列表类型
            JSONArray subJsonArray = new JSONArray();
            for (ExcelField excelField : subFieldList) {
                excelField.toJsonArray(scEnum, subJsonArray, row);
            }
            jsonObject.put(fieldName, subJsonArray);
        } else if (fieldType == FieldTypeEnum.OBJECT) {
            //对象类型
            JSONObject subJsonObject = new JSONObject();
            for (ExcelField excelField : subFieldList) {
                excelField.toJson(scEnum, subJsonObject, row);
            }
            jsonObject.put(fieldName, subJsonObject);
        } else {
            //普通类型
            jsonObject.put(fieldName, contentList.get(row));
        }
    }

    public void toHeadJson(JSONObject item) {
        item.put("field", fieldName);
        item.put("fieldName", fieldName);
        item.put("fieldType", fieldType);
        item.put("desc", annotation);
        item.put("validator", "");
        item.put("ext", "");
        if (fieldType == FieldTypeEnum.LIST || fieldType == FieldTypeEnum.OBJECT) {
            //列表类型
            JSONArray subJsonArray = new JSONArray();
            for (ExcelField excelField : subFieldList) {
                JSONObject sub = new JSONObject();
                excelField.toHeadJson(sub);
                subJsonArray.add(sub);
            }
            item.put("sub", subJsonArray);
        } else {
            //普通类型
            item.put("sub", null);
        }
    }

}
