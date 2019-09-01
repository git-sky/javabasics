package cn.com.sky.tools.json.jackson;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class JacksonTester {

    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student
        try {
            //反序列化JSON到对象。
            Student student = mapper.readValue(jsonString, Student.class);
            System.out.println(student);
            System.out.println("--------------------------------------------------------");

            //序列化对象到JSON
            jsonString = mapper.writeValueAsString(student);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> studentDataMap = new HashMap<>();
        int[] marks = {1, 2, 3};

        Student student = new Student();
        student.setAge(10);
        student.setName("Mahesh");
        // JAVA Object
        studentDataMap.put("student", student);
        // JAVA String
        studentDataMap.put("name", "Mahesh Kumar");
        // JAVA Boolean
        studentDataMap.put("verified", Boolean.FALSE);
        // Array
        studentDataMap.put("marks", marks);

        mapper.writeValue(new File("student.json"), studentDataMap);

        System.out.println("studentDataMap=" + studentDataMap);


        Map<String, Object> readMap = mapper.readValue(new File("student.json"), Map.class);

        System.out.println(readMap.get("student"));
        System.out.println(readMap.get("name"));
        System.out.println(readMap.get("verified"));
        System.out.println(readMap.get("marks"));


    }

    @Test
    public void tes1() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String, UserData> userDataMap = new HashMap<>();
            UserData studentData = new UserData();
            int[] marks = {1, 2, 3};

            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");
            // JAVA Object
            studentData.setStudent(student);
            // JAVA String
            studentData.setName("Mahesh Kumar");
            // JAVA Boolean
            studentData.setVerified(Boolean.FALSE);
            // Array
            studentData.setMarks(marks);
            TypeReference ref = new TypeReference<UserData>() {
            };

            userDataMap.put("studentData1", studentData);
            mapper.writeValue(new File("student.json"), userDataMap);
            //{
            //   "studentData1":
            //	 {
            //		"student":
            //		{
            //			"name":"Mahesh",
            //			"age":10
            //      },
            //      "name":"Mahesh Kumar",
            //      "verified":false,
            //      "marks":[1,2,3]
            //   }
            //}
            userDataMap = mapper.readValue(new File("student.json"), ref);

            System.out.println(userDataMap.get("studentData1").getStudent());
            System.out.println(userDataMap.get("studentData1").getName());
            System.out.println(userDataMap.get("studentData1").getVerified());
            System.out.println(Arrays.toString(userDataMap.get("studentData1").getMarks()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

