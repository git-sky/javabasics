package cn.com.java8lambdasexercises.chapter8.command;

public class Close implements Action {

    private final Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }

}
