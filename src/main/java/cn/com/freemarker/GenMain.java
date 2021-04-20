package cn.com.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

public class GenMain {
    // 模板目录
    public static final String TEMPLATE_DIRECTORY = "src/test/resources/template";
    // 模板生成后存放目录
    public static String TARGET_PATH;

    static {
        try {
            TARGET_PATH = new File("").getCanonicalPath() + "/src/test/java/p";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Java模板名称
//    public static final String JAVA_TEMPLATE_FILE = "test.java";
    // Json模板名称
    public static final String JSON_TEMPLATE_FILE = "test.json.ftl";
    // XML模板名称
//    public static final String XML_TEMPLATE_FILE = "test.xml";
    // 生成文件时候覆盖原有文件
    public static final Boolean FILE_COVER = true;


    private static Map<String, Object> getConfigMapByEachProperties(AutoTestConfig o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Field[] field = o.getClass().getDeclaredFields();
        HashMap<String, Object> map = new HashMap<>();
        for (Field f : field) {
            f.setAccessible(true);
            String key = f.getName();
            Object value = f.get(o);
            if (ObjectUtils.allNotNull(value)) {
                map.put(key, value);
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        AutoTestConfig c = AutoTestConfig.builder()
                .appKey("a")
                .serviceName("b")
                .url("c")
                .methodName("d")
                .paramTypes("java.lang.Integer")
                .desc("查询bizType")
                .request("1")
                .build();
//        genJava(c);
//        genXml(c);
        genJson(c);
    }

//    private static void genJava(AutoTestConfig config) throws IOException, InvocationTargetException, IllegalAccessException {
//        // 参数值
//        Map<String, Object> map = getConfigMapByEachProperties(config);
//        // 模板生成后存放目录
//        String targetPath = TARGET_PATH + "/" + config.getServiceName() + "/testsuites";
//        // 模板生成后新文件名
//        String fileName = config.getServiceName() + "Test.java";
//        // 创建文件夹
//        new File(targetPath).mkdirs();
//        File nFile = new File(targetPath + "/" + fileName);
//        if (!FILE_COVER && nFile.exists()) {
//            throw new RuntimeException("File \'" + fileName + "\' already exists");
//        }
//
//        // 生成目标文件
//        try (Writer writer = new FileWriter(nFile)) {
//            Template template = getConfiguration(TEMPLATE_DIRECTORY).getTemplate(JAVA_TEMPLATE_FILE, "UTF-8");
//            template.process(map, writer);
//        } catch (TemplateException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private static void genJson(AutoTestConfig config) throws InvocationTargetException, IllegalAccessException {
        // 参数值
        Map<String, Object> map = getConfigMapByEachProperties(config);

        // 模板生成后存放目录
        String targetPath = TARGET_PATH + "/" + config.getServiceName() + "/data";
        // 模板生成后新文件名
        String fileName = config.getServiceName() + "Test.json";
        // 创建文件夹
        new File(targetPath).mkdirs();
        File nFile = new File(targetPath + "/" + fileName);
        if (!FILE_COVER && nFile.exists()) {
            throw new RuntimeException("File \'" + fileName + "\' already exists");
        }

        // 生成目标文件
        try (Writer writer = new FileWriter(nFile)) {
            Template template = getConfiguration(TEMPLATE_DIRECTORY).getTemplate(JSON_TEMPLATE_FILE, "UTF-8");
            template.process(map, writer);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }
    }


//    private static void genXml(AutoTestConfig config) throws InvocationTargetException, IllegalAccessException, IOException {
//        // 参数值
//        Map<String, Object> map = getConfigMapByEachProperties(config);
//        // 模板生成后存放目录
//        String targetPath = new File("").getCanonicalPath() + "/src/test";
//        // 模板生成后新文件名
//        String fileName = config.getAppKey() + ".xml";
//        // 创建文件夹
//        new File(targetPath).mkdirs();
//        File nFile = new File(targetPath + "/" + fileName);
//        if (!FILE_COVER && nFile.exists()) {
//            throw new RuntimeException("File \'" + fileName + "\' already exists");
//        }
//
//        // 生成目标文件
//        try (Writer writer = new FileWriter(nFile)) {
//            Template template = getConfiguration(TEMPLATE_DIRECTORY).getTemplate(XML_TEMPLATE_FILE, "UTF-8");
//            template.process(map, writer);
//        } catch (TemplateException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private static Configuration getConfiguration(String templateDirectory) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configuration;
    }
}

@Data
@Builder
@AllArgsConstructor
class AutoTestConfig {
    private String appKey;//服务appKey
    private String serviceName;//服务名称（服务appKey下划线转驼峰命名）
    private String url;//rpc调用的url
    private String methodName;//rpc调用的方法名
    private String paramTypes;//请求参数的全限定名
    private String desc;//测试点的描述
    private String request;//请求的参数（非基本数据类型使用json字符串）
    private String response;//期望的返回值（选填）
}