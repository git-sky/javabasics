package cn.com.freemarker;

import com.google.common.collect.Maps;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TestCode {

    public static void main(String[] args) throws Exception {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("name", "Brady");

        String templateContent = "hello ${name}!";

        String result = parseContent(templateContent, paramMap);
        System.out.println(result);
    }

    private static String parseContent(String templateContent, Map<String, Object> dataMap) {
        String content = null;
        try {
            Configuration cfg = new Configuration(Configuration.getVersion());
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            cfg.setTemplateLoader(stringLoader);

            String templateName = "myTemplate";
            stringLoader.putTemplate(templateName, templateContent);

            Template template = cfg.getTemplate(templateName, "utf-8");

            StringWriter stringWriter = new StringWriter();
            template.process(dataMap, stringWriter);
//            cfg.setTemplateLoader(stringLoader);
            content = stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("模板解析失败");
        }
        return content;
    }
}