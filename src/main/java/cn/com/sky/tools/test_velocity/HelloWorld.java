package cn.com.sky.tools.test_velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

public class HelloWorld {

    public static void main(String[] args) {

        /* first, get and initialize an engine */
        // 初始化Velocity模板引擎：
        VelocityEngine ve = new VelocityEngine();
        ve.init();

        /* next, get the Template */
        // Velocity获取模板文件，得到模板引用：
        Template t = ve.getTemplate("hellosite.vm");

        /* create a context and add data */
        // 取得velocity的上下文context
        VelocityContext context = new VelocityContext();

        // 把数据填入上下文
        context.put("name", "Eiffel Qiu");
        context.put("site", "http://www.eiffelqiu.com");

        List temp = new ArrayList();
        temp.add("1");
        temp.add("2");
        context.put("list", temp);

        /* now render the template into a StringWriter */
        // 将环境变量和输出部分结合：
        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        System.out.println(writer.toString());
    }
}