/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author PC
 */
public class Bai4 extends JFrame {

    private static final int TEXT_CONVERTION_APP_WIDTH = 500;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 700;
    private final Container container = getContentPane();

    private JButton btStop;
    private JLabel lbImage;

    private Thread imageThread;
    private Random rd = new Random();

    String path = "E:\\StudyIT\\JAVA_BKIT_NB\\Lesson18Exercise\\src\\main\\java\\image\\";

    public Bai4() {
        initComponent();
        initEvent();

    }

    public static void main(String[] args) {
        Bai4 bai4 = new Bai4();
        bai4.setVisible(true);
    }

    private void initComponent() {

        setDefaultCloseOperation(3);
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        container.setBackground(Color.PINK);
        container.setLayout(null);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setBounds(200, 600, (int) btStop.getPreferredSize().getWidth(), (int) btStop.getPreferredSize().getHeight());
        container.add(btStop);

        lbImage = new JLabel();
        lbImage.setIcon(new ImageIcon());
        lbImage.setBounds(50, 50, 400, 500);
        start();
        container.add(lbImage);

        
    }

    void start() {

        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int n = rd.nextInt(8) + 1;
                    path = path + n + ".jpg";
                    System.out.println("xuat anh");
                    lbImage.setIcon(new ImageIcon(path));
                    sleep(2d);
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

    private void initEvent() {
        btExitEvent();
    }

    private void btExitEvent() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}
