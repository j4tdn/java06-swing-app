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
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author qphan
 */
public class Ex07 extends JFrame {

    private final Container conn = getContentPane();
    private JLabel lbImage;
    private JButton btStop;
    private Thread imageThread;
    private final String imageDir = "D:\\home\\workspace\\class\\j4t-java06-swing\\Lesson18\\src\\main\\java\\images";
    private final String imageGhostDir = imageDir + File.separator + "ghost";
    private final String[] images = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg"};
    private final String initialImage = images[0];
    private final String pauseIcon = imageDir + File.separator + "48px_pause.png";
    private final String resumeIcon = imageDir + File.separator + "48px_resume.png";
    private boolean isRunning = true;

    public Ex07() {
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

        Image image = ImageUtils.load(imageGhostDir + File.separator + initialImage).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbImage.setIcon(new ImageIcon(image));

        lbImage.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbImage.setBounds(160, 20, SizeUtils.getPreWidth(lbImage), SizeUtils.getPreHeight(lbImage));

        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setIcon(ImageUtils.loadImageIcon(pauseIcon));
        btStop.setBounds(200, 250, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));

        conn.add(lbImage);
        conn.add(btStop);

        randomImage();
    }

    private void initEvents() {
        btStopEvents();
    }

    private void btStopEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isRunning) {
                    isRunning = !isRunning;
                    imageThread.suspend();
                    btStop.setIcon(ImageUtils.loadImageIcon(resumeIcon));
                } else {
                    isRunning = !isRunning;
                    imageThread.resume();
                    btStop.setIcon(ImageUtils.loadImageIcon(pauseIcon));
                }
            }
        });
    }

    private void randomImage() {
        Random rd = new Random();

        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String path = imageGhostDir + File.separator + images[rd.nextInt(images.length)];
                    System.out.println("path: " + path);
                    Image image = ImageUtils.load(path).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
                    lbImage.setIcon(new ImageIcon(image));
                    sleep(1);
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
        Ex07 ex06 = new Ex07();
        ex06.setVisible(true);
    }
}
