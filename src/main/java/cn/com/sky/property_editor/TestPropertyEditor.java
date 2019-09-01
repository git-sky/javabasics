package cn.com.sky.property_editor;

/**
 * <pre>
 *
 * PropertyEditor是属性编辑器的接口，它规定了将外部设置值转换为内部JavaBean属性值的转换接口方法。
 *
 * 任何实现java.beans.PropertyEditor接口的类都是属性编辑器。属性编辑器的主要功能就是将外部的设置值转换为JVM内部的对应类型，所以属性编辑器其实就是一个类型转换器。
 *
 * </pre>
 */
public class TestPropertyEditor {

    public static void main(String[] args) {
        PersonPropertyEditor editor = new PersonPropertyEditor();
        editor.setAsText("Tom,man,22");
        System.out.println(editor.getValue());
    }
}
