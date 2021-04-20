package cn.com.fileds;

import cn.com.fileds.demo1.GrandSon;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <pre>
 *
 * Java获取类的字段有两个方法：
 * getFields()是获取该类的公共字段，包括父类的。
 * getDeclaredFields()是获取该类的所有字段，但不包括父类。
 *
 * 如果我想获取该类和所有父类的全部字段呢？？？
 * 我们可以调用getDeclareFilds()，先拿到该类的所有字段，然后循环的取父类，然后继续调用getDeclareFilds()，这样我们就可以拿到所有的字段了。我们还可以判断下名字，然后排除掉Ojbect类的那一层。
 *
 *
 * </pre>
 */
public class Main2 {


    public static void main(String[] args) throws Exception {
        UserTaskReq userTaskReq = new UserTaskReq();

        userTaskReq.setMgcId(1L);
//        userTaskReq.setExtraInfo_channel("game");
//        userTaskReq.setExtraInfo_cityId("1");
//        userTaskReq.setExtraInfo_referer("jjddz");

        JSONObject jsonObject = getAllFields(userTaskReq);

        System.out.println(JSON.toJSONString(jsonObject));
        System.out.println(jsonObject.isEmpty());
    }

    public static JSONObject getAllFields(Object object) throws Exception {

        JSONObject jsonObject = new JSONObject();

        // 拿到所有的字段
        List<Field> fieldList = new ArrayList<>();

        Class tempClass = object.getClass();
        while (tempClass != null && !tempClass.getName().toLowerCase().equals("java.lang.object")) {
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }


        String prefix = "extraInfo_";

        // 打印出来
        for (Field field : fieldList) {
            field.setAccessible(true);
            String filedName = field.getName();
            String fieldValue = null;
            Object value = field.get(object);
            if (value != null) {
                fieldValue = value.toString();
            }
            if (filedName.contains(prefix)
                    && fieldValue != null) {
                String name = filedName.substring(prefix.length());
                jsonObject.put(name, fieldValue);
            }
        }

        return jsonObject;
    }
}