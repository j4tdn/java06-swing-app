/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author phanv
 */
public class Ex04 extends JFrame {

    private static final String TEXT_CONVERTION_APP_TITILE = "Ảnh ngẫu nhiên";
    private static final int TEXT_CONVERTION_APP_WIDTH = 500;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 500;
    private static final String IMAGE_DIRECTORY = "D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\";
    private static final String[] IMAGE_NAMES = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg"};
    private static final String[] IMAGE_CONTROL = {"pauseIcon.jpg", "play.jpg"};
    private final Container conn = getContentPane();
    private static Thread threadRandom;
    private static boolean isRunning;
    private JLabel lbImage;
    private JButton btStop;

    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        ex04.setVisible(true);
    }

    public Ex04() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setTitle(TEXT_CONVERTION_APP_TITILE);
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        conn.setBackground(Color.MAGENTA);
        conn.setLayout(null);

        lbImage = new JLabel();
        lbImage.setBounds(150, 50, 200, 300);
        ImageIcon icon = new ImageIcon();
        icon.setImage(ImageUtils.load(IMAGE_DIRECTORY + IMAGE_NAMES[0]));
        lbImage.setIcon(ImageUtils.load(IMAGE_DIRECTORY + IMAGE_NAMES[0], 200, 400));
        conn.add(lbImage);

        btStop = new JButton();
        btStop.setBounds(215, 400, 50, 50);
        btStop.setIcon(ImageUtils.load(IMAGE_DIRECTORY + IMAGE_CONTROL[0], 50, 50));

        btStop.setFocusPainted(false);
        conn.add(btStop);

    }

    private void initEvents() {
        randomImage();
        btStopEvents();

    }

    private void btStopEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isRunning) {
                    isRunning = !isRunning;
                    btStop.setIcon(ImageUtils.load(IMAGE_DIRECTORY + IMAGE_CONTROL[1], 50, 50));
                    threadRandom.suspend();
                } else {
                    isRunning = !isRunning;
                    btStop.setIcon(ImageUtils.load(IMAGE_DIRECTORY + IMAGE_CONTROL[0], 50, 50));
                    threadRandom.resume();
                }
            }
        });

    }

    private void randomImage() {
        threadRandom = new Thread(() -> {
            Random rd = new Random();
            isRunning=true;
            while (true) {
                try {
                    Thread.sleep(500);
                    lbImage.setIcon(ImageUtils.load(IMAGE_DIRECTORY + IMAGE_NAMES[rd.nextInt(IMAGE_NAMES.length)], 200, 400));
                } catch (InterruptedException ex) {
                    ex.getStackTrace();
                }

            }
        });
        threadRandom.start();
    }
}
