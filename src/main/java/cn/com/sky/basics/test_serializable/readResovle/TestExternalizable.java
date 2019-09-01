package cn.com.sky.basics.test_serializable.readResovle;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestExternalizable implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) throws Exception {

        TestExternalizable et = new TestExternalizable();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File("test")));
        et = (TestExternalizable) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    /**
     * <pre>
     *
     * 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
     *
     * 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象，而被创建的对象则会被垃圾回收掉。
     *
     * </pre>
     */
    private Object readResolve() {
        TestExternalizable t = new TestExternalizable();
        t.setContent("readSolve");
        return t;
    }
}