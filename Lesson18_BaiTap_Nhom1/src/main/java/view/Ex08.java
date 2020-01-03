/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
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
public class Ex08 extends JFrame implements Runnable {

    private final Container conn = getContentPane();
    private JLabel lbImage;
    private JButton btStop;
    private static Thread imageThread;
    private final String imageDir = "D:\\Java_Swing\\Lesson18\\src\\main\\java\\java_swing\\images\\";
    private final String[] images = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg"};
    private final String initialImage = images[0];
    private final String pauseIcon = imageDir + "pauseIcon.jpg";
    private final String resumeIcon = imageDir + "play.jpg";
    private boolean isRunning = true;

    public Ex08() {
        initComponents();
        initEvents();

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Image");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        conn.setLayout(null);
        conn.setBackground(Color.GREEN);

        lbImage = new JLabel();

        Image image = ImageUtils.load(imageDir + initialImage).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbImage.setIcon(new ImageIcon(image));

        lbImage.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbImage.setBounds(160, 20, SizeUtils.getPreWidth(lbImage), SizeUtils.getPreHeight(lbImage));

        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setIcon(ImageUtils.load(pauseIcon, 50, 50));
        btStop.setBounds(200, 250, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));

        conn.add(lbImage);
        conn.add(btStop);
    }

    private void initEvents() {
        btStopEvents();
    }

    private void btStopEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isRunning) {
                    suspend();
                } else {
                    resume();
                }
            }
        });
    }

    private synchronized void suspend() {
        isRunning = !isRunning;
        btStop.setIcon(ImageUtils.load(resumeIcon, 50, 50));

    }

    private synchronized void resume() {
        isRunning = !isRunning;
        btStop.setIcon(ImageUtils.load(pauseIcon, 50, 50));
        notify();
    }

    private void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ex08 ex08 = new Ex08();
        ex08.setVisible(true);

        imageThread = new Thread(ex08);
        imageThread.start();
    }

    @Override
    public void run() {
        Random rd = new Random();
        while (true) {
            String path = imageDir + images[rd.nextInt(images.length)];
            System.out.println("path: " + path);
            Image image = ImageUtils.load(path).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
            lbImage.setIcon(new ImageIcon(image));
            sleep(1);
            synchronized (this) {
                while (!isRunning) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        ex.getStackTrace();
                    }
                }
            }
        }
    }
}
