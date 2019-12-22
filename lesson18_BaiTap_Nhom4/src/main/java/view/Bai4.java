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
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author PC
 */
public class Bai4 extends JFrame {

    private final Container conn = getContentPane();
    private final String[] pathImages = {"C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\1.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\2.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\3.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\4.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\5.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\6.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\7.png",
        "C:\\Users\\PC\\Desktop\\java06-swing-app\\src\\main\\java\\images\\ghost\\8.png"};
    private Image image;
    private Thread thread;
    private ImageIcon imageIcon;
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
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        conn.setLayout(null);
        conn.setBackground(Color.GREEN);

        lbImage = new JLabel();
        lbImage.setBounds(200, 150, SizeUtils.getPreWidth(lbImage), SizeUtils.getPreHeight(lbImage));
        conn.add(lbImage);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFont(new Font("arial", Font.PLAIN, 40));
        btStop.setFocusPainted(false);
        btStop.setBounds((500 - SizeUtils.getPreWidth(btStop)) / 2, 150, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));
        conn.add(btStop);
        randomImage();
    }

    private void randomImage() {
        thread = new Thread(() -> {
            while (true) {
                Random rd = new Random();
                String pathImage = pathImages[rd.nextInt(pathImages.length)];
                imageIcon = new ImageIcon();
                image = ImageUtils.load(pathImage);
                image = image.getScaledInstance(100, 200, Image.SCALE_DEFAULT);
                imageIcon.setImage(image);
                lbImage.setIcon(imageIcon);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bai4.class.getName()).log(Level.SEVERE, null, ex);
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
