package cn.com.json_tools.jackson.annotation;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class TestAnnotation {

    @Test
    public void testa() throws ParseException, IOException {

        /**
         * <pre>
         *
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         *
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         *
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         *
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         *
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         *
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         *
         * </pre>
         */
        ObjectMapper mapper = new ObjectMapper();


        System.out.println("***************单个对象转Json************************");
        Student student = new Student();
        student.setId("20123094");
        student.setAge("22");
        student.setName("Bin");
        student.setSex("男");
        Date date = new Date();
        student.setBirth(date);
        String studentJson = mapper.writeValueAsString(student);
        System.out.println("studentJson=" + studentJson);
        System.out.println();

        System.out.println("***************多个对象转Json************************");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student);
        students.add(student);
        String studentsJson = mapper.writeValueAsString(students);
        System.out.println("studentsJson=" + studentsJson);
        System.out.println();


        System.out.println("***************json转对象************************");
        Student newStu = new Student();
        newStu = mapper.readValue(studentJson, Student.class);
        System.out.println("json转换后结果如下：");
        System.out.println("newStu.getName()=" + newStu.getName() + "|newStu.getSex()=" + newStu.getSex());
        System.out.println("newStu.getAge()=" + newStu.getAge() + "|newStu.getId()=" + newStu.getId());
        System.out.println("newStu.getBirth()=" + newStu.getBirth());


    }

}