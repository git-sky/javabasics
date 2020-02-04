package cn.com.sky.basics.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableExample {
    public static void main(String args[]) {
        JFrame myFrame = new JFrame("Table Example");
        Object data[][] = {{1, "����", "��", "18", "010.82607080"},
                {2, "����", "Ů", "24", "021.68720890"},
                {3, "����", "��", "43", "0459.4990893"},
                {4, "����", "��", "32", "010.67887098"},
                {5, "����", "Ů", "15", "010.84682089"},
                {6, "���", "��", "76", "010.63540177"},};
        String columnNames[] = {"���", "����", "�Ա�", "����", "�绰"};
        JTable table = new JTable(data, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // JScrollPane pane = new JScrollPane(table);
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);

        myFrame.add("Center", pane);
        myFrame.setSize(350, 150);
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        myFrame.setVisible(true);
    }
}