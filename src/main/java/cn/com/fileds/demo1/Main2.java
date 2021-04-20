package cn.com.fileds.demo1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        GrandSon grandSon = new GrandSon();
        grandSon.setGrandSonField("gameloft9");
        grandSon.setSonField("son");
        grandSon.setParentField("parent");

        getAllFields(grandSon);
    }

    public static void getAllFields(Object request) throws Exception {
        // 拿到所有的字段
        List<Field> fieldList = new ArrayList<>();

        Class tempClass = request.getClass();
        while (tempClass != null && !tempClass.getName().toLowerCase().equals("java.lang.object")) {
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); // 拿到父类
        }

        // 打印出来
        for (Field field : fieldList) {
            field.setAccessible(true); // 设置字段的可访问性
            System.out.println(field.getName() + "=" + field.get(request).toString());

        }
    }
}