package cn.com.sky.tools.serializable.hessian;

import cn.com.sky.tools.serializable.Student;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 使用Hessian也需要 Serializable对象。
 */
public class TestHessian {

    public static void main(String[] args) throws IOException {

        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(22);

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //Hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);

        ho.writeObject(student);

        byte[] zhansanByte = os.toByteArray();

        ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
        //Hessian的反序列化读取对象
        HessianInput hi = new HessianInput(is);
        Student person = (Student) hi.readObject();
        System.out.println("姓名：" + person.getName());
        System.out.println("年龄：" + person.getAge());

    }
}