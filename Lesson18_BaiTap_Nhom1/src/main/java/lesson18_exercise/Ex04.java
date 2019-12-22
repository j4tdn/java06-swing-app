package lesson18_exercise;

import common.PathEnum;
import java.awt.Color;
import java.awt.Container;
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
import utils.SizeUntils;

public class Ex04 extends JFrame {

    private static final String RANDOM_IMAGE_APP_TITLE = "Random image";
    private static final int RANDOM_IMAGE_APP_WIDTH = 580;
    private static final int RANDOM_IMAGE_APP_HEIGHT = 320;
    private static final String RANDOM_IMAGE_APP_ICON = "F:\\java_netbean\\java06_swing\\src\\main\\java\\images\\like.png";
    private final Container conn = getContentPane();
    private final PathEnum[] paths = PathEnum.values();

    private JButton btStop;
    private ImageIcon imgIcon;
    private JLabel jb;
    private Thread imageThread;

    public Ex04() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        ex04.setVisible(true);
    }

    private void initComponents() {
        setTitle(RANDOM_IMAGE_APP_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(RANDOM_IMAGE_APP_WIDTH, RANDOM_IMAGE_APP_HEIGHT);
        conn.setLayout(null);
        conn.setBackground(Color.GRAY);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(ImageUtils.load(RANDOM_IMAGE_APP_ICON));

        jb = new JLabel();
        jb.setBounds(100, 100, 100, 100);

        Image image = new ImageIcon(RANDOM_IMAGE_APP_ICON)
                .getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(image);
        jb.setIcon(imgIcon);
        conn.add(jb);

        btStop = new JButton();
        btStop.setText("Stop");
        btStop.setFocusPainted(false);
        btStop.setBounds(200, 220, SizeUntils.getPreWidth(btStop), SizeUntils.getPreHeight(btStop));
        conn.add(btStop);

        randomImage();
    }

    private void randomImage() {
        Random rd = new Random();
        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("aaaaaaaa");
                    PathEnum pathEnum = paths[rd.nextInt(paths.length)];
                    System.out.println(pathEnum.name());
                    Image image = new ImageIcon(pathEnum.getPath())
                            .getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
                    imgIcon.setImage(image);
                    jb.setIcon(imgIcon);
                    System.out.println("bbbbbbbbbbbbb");
                    sleep(5d);
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

    private void initEvents() {
        btStopEvents();
    }

    private void btStopEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imageThread.stop();
            }
        });
    }

}
