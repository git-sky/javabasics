package cn.com.freemarker;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeM_DB {

    public static void main(String[] args) {
        try {
            fun();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public static void fun() throws IOException, TemplateException {

        StringTemplateLoader stringLoader = new StringTemplateLoader();

        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

        configuration.setTemplateLoader(stringLoader);


        String templateName = "templateName";
        //************注入模板**************
        String newTemplateContent = "利用SQL语句，从数据库中获取的模板";
        stringLoader.putTemplate(templateName, newTemplateContent);

        //*********获取模板******
        Template template = configuration.getTemplate(templateName);

        //******可以看出来，就是put,然后get

        //*********模板参数-值*******
        Map<String, String> map = new HashMap<String, String>();
        map.put("app", "Myapp");
        //********替换模板**********
        Writer out = new StringWriter();
        template.process(map, out);
        String result = out.toString();

        System.out.println(result);
    }
}