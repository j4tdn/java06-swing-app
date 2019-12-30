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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author PC
 */
public class Ex02 extends JFrame {

    private final Container container = getContentPane();
    private final String imageDir = "D:\\java06-swing\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image";
    private Thread imageThread;

    private final String imageDtDir = imageDir + File.separator + "imageDT";
    private final String[] imagesDt = {"DT1.jpg", "DT2.jpg", "DT3.jpg", "DT4.jpg", "DT5.jpg"};
    private final String initialImageDt = imagesDt[0];
    private List<String> listDt = new ArrayList<>();

    private final String imageGDir = imageDir + File.separator + "imageG";
    private final String[] imagesGs = {"G1.jpg", "G2.jpg", "G3.jpg", "G4.jpg", "G5.jpg"};
    private final String initialImageG = imagesGs[0];
    private List<String> listG = new ArrayList<>();

    private final String imageVlDir = imageDir + File.separator + "imageVL";
    private final String[] imagesVl = {"VL1.jpg", "VL2.jpg", "VL3.jpg", "VL4.jpg", "VL5.jpg"};
    private final String initialImageVl = imagesVl[0];
    private List<String> listVl = new ArrayList<>();

    private JButton btStart;
    private JLabel lbDt;
    private JLabel lbG;
    private JLabel lbVl;

    public Ex02() {
        initComponents();
        btStartEvent();

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAME ĐÁNH NHAU ");
        setSize(670, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        container.setLayout(null);
        container.setBackground(Color.PINK);

        lbDt = new JLabel();
        Image imageDT = ImageUtils.load(imageDtDir + File.separator + initialImageDt).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbDt.setIcon(new ImageIcon(imageDT));
        lbDt.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbDt.setBounds(30, 20, SizeUtils.getPreWidth(lbDt), SizeUtils.getPreHeight(lbDt));
        container.add(lbDt);

        lbG = new JLabel();
        Image imageG = ImageUtils.load(imageGDir + File.separator + initialImageG).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbG.setIcon(new ImageIcon(imageG));
        lbG.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbG.setBounds(240, 20, SizeUtils.getPreWidth(lbG), SizeUtils.getPreHeight(lbG));
        container.add(lbG);

        lbVl = new JLabel();
        Image imageVL = ImageUtils.load(imageVlDir + File.separator + initialImageVl).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
        lbVl.setIcon(new ImageIcon(imageVL));
        lbVl.setFont(new Font("Tahoma", Font.BOLD, 28));
        lbVl.setBounds(450, 20, SizeUtils.getPreWidth(lbVl), SizeUtils.getPreHeight(lbVl));
        container.add(lbVl);

        btStart = new JButton();
        btStart.setText("START");
        btStart.setFocusPainted(false);
        btStart.setFont(new Font("Tahoma", Font.BOLD, 22));
        btStart.setBounds(300, 300, SizeUtils.getPreWidth(btStart), SizeUtils.getPreHeight(btStart));
        container.add(btStart);

    }

    private void randomMember() {
        random(imageDtDir, imagesDt, lbDt);
        random(imageGDir, imagesGs, lbG);
        random(imageVlDir, imagesVl, lbVl);

    }

    private void random(String dir, String[] image, JLabel label) {
        Random rd = new Random();

        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name;
                String nameMembers = image[rd.nextInt(image.length)];
                String pathDt = dir + File.separator + nameMembers;
                System.out.println(changeName(nameMembers));
                Image image = ImageUtils.load(pathDt).getScaledInstance(180, 190, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
                sleep(0.1);

            }
        });
        imageThread.start();
    }

    private void btStartEvent() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                randomMember();
            }

        });
    }

    private String changeName(String string) {
        if (string.contains(".jpg")) {
            string = string.replace(".jpg", "");
        }
        return string;
    }

    private boolean checkName(List<String> list, String string) {
        for (String name : list) {
            if (string.equals(name)) {
                return true;
            }
        }
        return false;
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
