/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson18_exercise;

import common.ColorEnum;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUntils;

/**
 *
 * @author SMILE ^^
 */
public class Ex03 extends JFrame {

    private static final int APP_WIDTH = 500;
    private static final int APP_HEIGHT = 400;
    private static final int LABEL_WIDTH = 400;
    private static final String APP_TITLE = "Random Window Background";
    private static final String APP_ICON = "D:\\Java\\images\\48px_love.png";

    private static final int INITTIAL_HEADER_X_PADDING = 120;
    private static final int INITTIAL_HEADER_Y_PADDING = 100;

    private final Container con = getContentPane();
    private final ColorEnum[] colors = ColorEnum.values();

    private JLabel lbColor;
    private JButton btnStop;

    private Thread imageThread;

    public Ex03() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex03 e = new Ex03();
        e.setVisible(true);
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(APP_TITLE);
        setResizable(false);

        setIconImage(ImageUtils.load(APP_ICON));

        lbColor = new JLabel("Random: RED");
        lbColor.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbColor.setForeground(Color.BLACK);
        lbColor.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                LABEL_WIDTH, SizeUntils.getPreHeight(lbColor));

        con.add(lbColor);

        btnStop = new JButton("Stop");
        btnStop.setFont(new Font("Tahoma", Font.PLAIN, 24));

        btnStop.setFocusPainted(false);
        btnStop.setBounds(INITTIAL_HEADER_X_PADDING * 3 / 2, INITTIAL_HEADER_Y_PADDING * 3,
                INITTIAL_HEADER_X_PADDING, SizeUntils.getPreHeight(btnStop));

        con.add(btnStop);

        con.setLayout(null);
        con.setBackground(Color.RED);
        randomColor();

    }

    private void initEvents() {
        btnStopEvents();
    }

    private void randomColor() {
        Random rd = new Random();

        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ColorEnum colorEnum = colors[rd.nextInt(colors.length)];
                    lbColor.setText("Random: " + colorEnum.name());
                    con.setBackground(colorEnum.getColor());
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
            System.out.println(ex.getMessage());
        }
    }

    private void btnStopEvents() {
        Font btnStopFont = btnStop.getFont();
        Font highlightFont = new Font(btnStopFont.getFontName(), Font.BOLD, btnStopFont.getSize());

        btnStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imageThread.stop();
                sleep(3);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnStop.setFont(highlightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnStop.setFont(btnStopFont);
            }

        });

        btnStop.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnStop.setFont(highlightFont);
                    imageThread.stop();
                    sleep(3);
                    System.exit(0);
                }
            }

        });
    }

}
