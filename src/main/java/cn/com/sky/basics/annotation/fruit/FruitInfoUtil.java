package cn.com.sky.basics.annotation.fruit;

import cn.com.sky.basics.annotation.fruit.anno.FruitColor;
import cn.com.sky.basics.annotation.fruit.anno.FruitName;
import cn.com.sky.basics.annotation.fruit.anno.FruitProvider;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void main(String[] args) {
        getFruitInfo(Apple.class);
    }


    public static void getFruitInfo(Class<?> clazz) {

        //getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的字段。
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                System.out.println(" 水果名称：" + fruitName.value());
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                System.out.println(" 水果颜色：" + fruitColor.fruitColor().toString());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                System.out.println(" 供应商编号：" + fruitProvider.id());
                System.out.println(" 供应商名称：" + fruitProvider.name());
                System.out.println(" 供应商地址：" + fruitProvider.address());
            }
        }
    }

}
