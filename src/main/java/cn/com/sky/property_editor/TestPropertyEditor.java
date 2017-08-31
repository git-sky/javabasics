package cn.com.sky.property_editor;

public class TestPropertyEditor {

	public static void main(String[] args) {
		PersonPropertyEditor editor = new PersonPropertyEditor();
		editor.setAsText("aSam,man,22");
		System.out.println(editor.getValue());
	}
}
