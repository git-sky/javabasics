package cn.com.freemarker;

import cn.com.json_tools.jackson.JsonUtils;
import com.google.gson.JsonElement;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

/**
 *
 */
public class TestFree {


    public static void main(String[] args) {
        String templateName = "name1";
        String dataMap = "";
        String templateContent = "";


        String s = parseContent(templateName, templateContent, JsonUtils.json2Map(dataMap, true));

        System.out.println(s);
    }


//    private static String process(String context) {
//        Map dataMap = JsonUtils.parseObject(context.getResult().toString(), Map.class);
//        String templateName = context.getApiConfig().getResponseConfig().getTemplateName();
//        String templateContent = context.getApiConfig().getResponseConfig().getDataDsl();
//        return parseContent(templateName, templateContent, dataMap);
//    }

    private static String parseContent(String templateName, String templateContent, Object dataMap) {
        String content = null;
        try {
            freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.getVersion());
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            cfg.setTemplateLoader(stringLoader);

            stringLoader.putTemplate(templateName, templateContent);

            Template template = cfg.getTemplate(templateName, "utf-8");

            StringWriter stringWriter = new StringWriter();
            template.process(dataMap, stringWriter);
            content = stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException("模板解析失败", e);
        }
        return content;
    }

}