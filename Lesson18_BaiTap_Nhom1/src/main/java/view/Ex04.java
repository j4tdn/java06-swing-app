/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final EnumImagePath[] ENUM_IMAGE_PATHS = EnumImagePath.values();
    private final Container conn = getContentPane();
    private static  Thread threadRandom;
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

        conn.setBackground(Color.PINK);
        conn.setLayout(null);

        lbImage = new JLabel();
        lbImage.setBounds(150, 50, 200, 300);
        ImageIcon imgIcon = new ImageIcon(ENUM_IMAGE_PATHS[0].getPath());
        Image img = imgIcon.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
        imgIcon.setImage(img);
        lbImage.setIcon(imgIcon);
        conn.add(lbImage);

        btStop = new JButton("Stop");
        btStop.setFont(new Font("Tahoma", Font.BOLD, 18));
        btStop.setBounds(215, 400, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));
        btStop.setFocusPainted(false);
        conn.add(btStop);

    }

    private void initEvents() {
        randomImage();
        btStopEvents();

    }
private void btStopEvents(){
    btStop.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
           threadRandom.stop();
        }
        
    });
    
}
    private void randomImage() {
         threadRandom = new Thread(() -> {
             Random rd = new Random();
             while (true) {
                 try {
                     Thread.sleep(500);
                     ImageIcon imgIcon = new ImageIcon(ENUM_IMAGE_PATHS[rd.nextInt(ENUM_IMAGE_PATHS.length)].getPath());
                     Image img = imgIcon.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
                     imgIcon.setImage(img);
                     lbImage.setIcon(imgIcon);
                 } catch (InterruptedException ex) {
                     ex.getStackTrace();
                 }
                 
             }
         });
         threadRandom.start();
    }
}
