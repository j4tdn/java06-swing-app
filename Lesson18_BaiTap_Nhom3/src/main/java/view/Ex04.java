/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author MyPC
 */
public class Ex04 extends JFrame {

    private final Container conn = getContentPane();
    private ImageIcon iconImage;
    JLabel lbImage;
    private JButton btStop;
    private Thread imageThread;

    private Image image;
    Random rd = new Random();
    private final String path = "F:\\NetbeanProject\\java06-swing-app\\Lesson18_BaiTap_Nhom3\\src\\main\\java\\image";

    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        ex04.setVisible(true);
        ex04.setResizable(false);

    }

    public Ex04() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lbImage = new JLabel();
        setSize(500, 500);
        setLocationRelativeTo(null);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFocusPainted(false);
        btStop.setFont(new Font("Tahoma", Font.BOLD, 28));
        btStop.setBounds(170, 350, 150, 50);

        conn.add(lbImage);
        conn.add(btStop);
        conn.setLayout(null);
        randomImage();
    }

    private void randomImage() {
        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int index = rd.nextInt(8) + 1;
                    String fullPath = path + "\\" + index + ".jpg";
                    iconImage = new ImageIcon();
                    image = ImageUtils.load(fullPath);
                    image = image.getScaledInstance(150, 250, Image.SCALE_SMOOTH);
                    iconImage.setImage(image);

                    lbImage.setBounds(170, 50, 150, 250);
                    lbImage.setIcon(iconImage);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        imageThread.start();

    }

    private void initEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imageThread.stop();
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
