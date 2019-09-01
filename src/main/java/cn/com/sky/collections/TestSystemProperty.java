package cn.com.sky.collections;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Properties;

/**
 * System.getProperty()方法。
 */
public class TestSystemProperty {

    public static void main(String[] args) {

        Properties prop = System.getProperties();
        Enumeration enumeration = prop.keys();

        String property = "";
        String constantName = "";
        String note = "";

        while (enumeration.hasMoreElements()) {
            property = (String) enumeration.nextElement();
            note = "\t//" + System.getProperty(property) + "\n";
            constantName = "\tpublic final static String " + property.replace(".", "_").toUpperCase() + " = " + property;
            System.out.println(note + constantName);
        }
        System.out.println("}");
    }


    @Test
    public void testa() {

        System.out.println("file.separator=" + System.getProperty("file.separator"));
        System.out.println("java.io.tmpdir=" + System.getProperty("java.io.tmpdir"));

    }
}