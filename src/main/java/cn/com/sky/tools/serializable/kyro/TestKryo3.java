package cn.com.sky.tools.serializable.kyro;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

class Student {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class TestKryo3 {
    public static void main(String[] args) throws Exception {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("student.db"));
        Student kirito = new Student("kirito");
        kryo.writeObject(output, kirito);
        output.close();
        Input input = new Input(new FileInputStream("student.db"));
        Student kiritoBak = kryo.readObject(input, Student.class);
        input.close();

        System.out.println(kiritoBak);
        assert "kirito".equals(kiritoBak.getName());
    }
}