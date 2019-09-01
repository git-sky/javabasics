package cn.com.sky.basics.gui;

import java.awt.*;
import java.awt.event.*;

public class OuterMonitor extends MouseMotionAdapter implements ActionListener {
    private TextArea msgBoard;
    private Button[] buttons;
    private String clipBoard = "";

    public OuterMonitor(TextArea msgBoard, Button[] buttons) {
        this.msgBoard = msgBoard;
        this.buttons = buttons;
    }

    public void setClipBoard(String text) {
        this.clipBoard = text;
    }

    public String getClipBoard() {
        return this.clipBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int positon = msgBoard.getSelectionStart();
        String s = e.getActionCommand();
        if (s.equals("RESET")) {
            msgBoard.setText("");
        } else if (s.equals("SUBMIT")) {
            System.out.println("�������Ϊ��\n  " + msgBoard.getText());
        } else if (s.equals("COPY")) {
            clipBoard = msgBoard.getSelectedText();
            msgBoard.setSelectionStart(msgBoard.getSelectionEnd());
        } else if (s.equals("CUT")) {
            clipBoard = msgBoard.getSelectedText();
            this.delete();
        } else if (s.equals("PASTE")) {
            //msgBoard.insert(clipBoard,msgBoard.getCaretPosition());
            String content = msgBoard.getText();
            String alter = content.substring(0, positon) + clipBoard + content.substring(positon);
            msgBoard.setText(alter);
        } else if (s.equals("DELETE")) {
            this.delete();
        }
        this.switchButtons();
    }

    public void delete() {
        int start = msgBoard.getSelectionStart();
        int end = msgBoard.getSelectionEnd();
        String content = msgBoard.getText();
        String alter = content.substring(0, start) + content.substring(end);
        msgBoard.setText(alter);
    }

    public void switchButtons() {
        boolean clipped = (clipBoard != null) && (clipBoard.length() > 0);
        buttons[2].setEnabled(clipped);
        boolean selected = msgBoard.getSelectionEnd() != msgBoard.getSelectionStart();
        buttons[0].setEnabled(selected);
        buttons[1].setEnabled(selected);
        buttons[3].setEnabled(selected);
    }

    @Override
    public void mouseDragged(MouseEvent te) {
        this.switchButtons();
    }
}