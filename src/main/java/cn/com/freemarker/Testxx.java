package cn.com.freemarker;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringReader;

/**
 *
 */
@Slf4j
public class Testxx {

    /**
     * 获取freemarker模板
     *
     * @param name      用于名称标记
     * @param template   字符串模板
     * @return
     */
    public static Template getTemplate(String name, String template){
        Configuration cfg  =   new  Configuration();
        cfg.setDefaultEncoding("UTF-8");
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        cfg.setTemplateLoader(stringTemplateLoader);
        Template temp = null;
        try {
            temp  =  new Template(name, new StringReader(template), cfg, "UTF-8");
        } catch (IOException e) {
            log.error("getTemplate failed! name {}", name, e);
        }
        return temp;
    }
}