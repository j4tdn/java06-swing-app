
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.ColorEnum;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import util.SizeUtils;

/**
 *
 * @author qphan
 */
public class Ex02 extends JFrame {

    private final Container conn = getContentPane();
    private final common.ColorEnum[] colors = common.ColorEnum.values();
    private JLabel lbColor;
    private JButton btStop;
    private Thread imageThread;

    public Ex02() {
        initComponents();
        initEvents();

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random background");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        conn.setLayout(null);
        conn.setBackground(Color.GREEN);

        lbColor = new JLabel();
        lbColor.setText("RANDOM: GREEN");
        lbColor.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbColor.setBounds(140, 20, SizeUtils.getPreWidth(lbColor), SizeUtils.getPreHeight(lbColor));

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFocusPainted(false);
        btStop.setFont(new Font("Tahoma", Font.BOLD, 22));
        btStop.setBounds(200, 200, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));

        conn.add(lbColor);
        conn.add(btStop);

        randomColor();
    }

    private void initEvents() {
        btStopEvents();
    }

    private void btStopEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imageThread.stop();
                sleep(3);
                System.exit(0);
            }
        });
    }

    private void randomColor() {
        Random rd = new Random();

        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ColorEnum colorEnum = colors[rd.nextInt(colors.length)];
                    System.out.println("xx: " + colorEnum.name());
                    lbColor.setText("RANDOM: " + colorEnum.name());
                    conn.setBackground(colorEnum.getColor());
                    sleep(0.5d);
                }
            }
        });
        imageThread.start();

    }

    private void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.setVisible(true);
    }
}

