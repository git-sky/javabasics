package cn.com.sky.basics.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class PaoWuXian extends JFrame implements ActionListener {

    private int a, b, c, width;
    private int bottom;
    private int offx = 300;
    private int offy = 300;
    private Image img;
    private Image img2;
    private int i;
    private int k;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private Color cc;
    private JPanel panel;
    Graphics2D g2d;
    Graphics g;

    public PaoWuXian() {
        super("�����˶�");
        a = 1;
        b = 1;
        c = 1;
        width = 1;
        cc = Color.red;

        setLayout(null);
        button1 = new JButton("�����ɫ");
        button1.setBounds(460, 120, 90, 20);
        button2 = new JButton("���ϵ��");
        button2.setBounds(460, 40, 90, 20);
        button3 = new JButton("����߿�");
        button3.setBounds(460, 80, 90, 20);
        label1 = new JLabel("a:");
        label1.setBounds(40, 40, 40, 20);
        label2 = new JLabel("b:");
        label2.setBounds(180, 40, 20, 20);
        label3 = new JLabel("c:");
        label3.setBounds(320, 40, 20, 20);
        label4 = new JLabel("�߿�:");
        label4.setBounds(320, 80, 40, 20);
        text1 = new JTextField(3);
        text1.setBounds(70, 40, 80, 20);
        text2 = new JTextField(3);
        text2.setBounds(210, 40, 80, 20);
        text3 = new JTextField(3);
        text3.setBounds(350, 40, 80, 20);
        text4 = new JTextField(3);
        text4.setBounds(350, 80, 80, 20);
        panel = new JPanel();
        panel.setBounds(0, 100, 450, 400);
        add(label1);
        add(text1);
        add(label2);
        add(text2);
        add(label3);
        add(text3);
        add(label4);
        add(text4);
        add(button1);
        add(button2);
        add(button3);
        add(panel);
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        img = panel.createImage(8, 8);
        img2 = panel.createImage(1000, 1000);
        Graphics gimg = img.getGraphics();
        gimg.drawOval(3, 0, 4, 4);
        bottom = -b / (2 * a);
        i = bottom - 10;
    }

    public void paint() {
        int w = a * i * i + b * i + c;
        bottom = -b / (2 * a);
        g = panel.getGraphics();
        g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(Color.black);
        //x��
        g2d.draw(new Line2D.Float(offx - 140, offy, offx + 140, offy));
        // x���ͷ
        g2d.draw(new Line2D.Float(offx + 135, offy - 4, offx + 140, offy));
        g2d.draw(new Line2D.Float(offx + 135, offy + 4, offx + 140, offy));
        // y��
        g2d.draw(new Line2D.Float(offx, offy - 130, offx, offy + 130));
        // y���ͷ
        g2d.draw(new Line2D.Float(offx - 4, offy - 125, offx, offy - 130));
        g2d.draw(new Line2D.Float(offx + 4, offy - 125, offx, offy - 130));

        // x���
        g2d.drawString("x", offx + 135, offy + 16);
        // y���
        g2d.drawString("y", offx - 15, offy - 120);
        // 0����
        g2d.drawString(" " + 0, offx - 10, offy + 10);

        GeneralPath polly = new GeneralPath();
        polly.moveTo(offx + bottom - 11, offy
                - (a * (bottom - 11) * (bottom - 11) + b * (bottom - 11) + c));
        for (int i = bottom - 11; i <= bottom + 11; i++) {
            float x = i;
            float y = (float) (a * x * x + b * x + c);
            polly.lineTo(offx + x, offy - y);
        }
        g2d.setPaint(cc);
        g2d.setStroke(new BasicStroke(width));
        g2d.draw(polly);
        // ��Բ
        g2d.drawImage(img, offx + i - 4, offy - w - 4, panel);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        //����ԭ����Բ
        g2d.drawImage(img2, 0, 100, panel);
        i++;
        k++;
        //�ع�
        if (k % 22 == 0)
            i = bottom - 11;
        paint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "���ϵ��") {

            if (text1.getText().equals("") || text2.getText().equals("")
                    || text3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "����������ϵ��", "��ܰ��ʾ",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    a = Integer.parseInt(text1.getText());
                    b = Integer.parseInt(text2.getText());
                    c = Integer.parseInt(text3.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����������", "��ܰ��ʾ",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (e.getActionCommand() == "�����ɫ") {
            cc = JColorChooser.showDialog(((Component) e.getSource())
                    .getParent(), "��ɫ", Color.blue);
        } else if (e.getActionCommand() == "����߿�") {
            if (text4.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "�������߿?", "��ܰ��ʾ",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    width = Integer.parseInt(text4.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "����������", "��ܰ��ʾ",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public static void main(String args[]) {
        PaoWuXian x = new PaoWuXian();
        x.paint();
    }

}

