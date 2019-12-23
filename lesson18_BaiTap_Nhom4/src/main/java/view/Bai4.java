package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author PC
 */
public class Bai4 extends JFrame {

    private final Container conn = getContentPane();
    private final String[] pathImages = {"E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\1.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\2.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\3.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\4.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\5.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\6.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\7.jpg",
        "E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\8.jpg"};
    private Thread thread;
    private ImageIcon imageIcon;
    private Image image;
    private JLabel lbImage;
    private JButton btStop;

    public Bai4() {
        initComponents();
        initEvents();

    }

    public static void main(String[] args) {
        Bai4 bai4 = new Bai4();
        bai4.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Random");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        conn.setLayout(null);
        conn.setBackground(Color.GREEN);

        lbImage = new JLabel();
        imageIcon = new ImageIcon();
        imageIcon.setImage(ImageUtils.load("E:\\GiaoTrinhHocTap\\Java\\java06-swing\\lesson18_BaiTap_Nhom4\\src\\main\\java\\images\\1.jpg").getScaledInstance(200, 150, Image.SCALE_SMOOTH));
        lbImage.setIcon(imageIcon);
        lbImage.setBounds(150, 40, 200, 150);
        conn.add(lbImage);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFont(new Font("arial", Font.PLAIN, 40));
        btStop.setFocusPainted(false);
        btStop.setBounds((500 - SizeUtils.getPreWidth(btStop)) / 2, 250, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));
        conn.add(btStop);
        randomImage();

    }

    private void randomImage() {
        thread = new Thread(() -> {
            while (true) {
                Random rd = new Random();
                String pathImage = pathImages[rd.nextInt(pathImages.length)];
                imageIcon = new ImageIcon();
                imageIcon.setImage(ImageUtils.load(pathImage).getScaledInstance(200, 150, Image.SCALE_SMOOTH));
                lbImage.setIcon(imageIcon);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void initEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            Font btStopFont = btStop.getFont();

            @Override
            public void mousePressed(MouseEvent e) {
                thread.stop();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = new Font(btStopFont.getFontName(),
                        Font.BOLD, this.btStopFont.getSize());
                btStop.setFont(font);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btStop.setFont(btStopFont);
            }
        });

    }

}
