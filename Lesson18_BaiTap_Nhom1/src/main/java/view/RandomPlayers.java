/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author phanv
 */
public class RandomPlayers extends JFrame implements Runnable {

    private final String TITLE_OF_APP = "MATCH FOUND...";
    private final int WIDTH_OF_APP = 600;
    private final int HEIGHT_OF_APP = 400;
    private final Container container = getContentPane();
    private final String DIRECTORY_FILE = "D:\\Java_Swing\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\fileTxt\\game.txt";
    private final String IMAGE_BACKGROUND = "D:\\Java_Swing\\java06-swing-app\\"
            + "Lesson18_BaiTap_Nhom1\\src\\main\\java\\image\\background\\";
    private final String IMAGE_DIRECTORY_FIRST_GROUP = "D:\\Java_Swing\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image\\imageFirstGroup\\";
    private final String IMAGE_DIRECTORY_SECOND_GROUP = "D:\\Java_Swing\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image\\imageSecondGroup\\";
    private final String IMAGE_DIRECTORY_THIRD_GROUP = "D:\\Java_Swing\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image\\imageThirdGroup\\";
    private JLabel lbBackground;
    private boolean isRunning = true;
    private final String[] FIRST_GROUP = {"DT1", "DT2", "DT3", "DT4", "DT5"};
    private final String[] SECOND_GROUP = {"VL1", "VL2", "VL3", "VL4", "VL5"};
    private final String[] THIRD_GROUP = {"G1", "G2", "G3", "G4", "G5"};
    private final List<String> playersList = new LinkedList<>();
    private JLabel lbFirstPlayer;
    private JLabel lbSecondPlayer;
    private JLabel lbThirdPlayer;
    private JButton btStart;
    private final Random rd = new Random();
    private static Thread threadRandom;

    public static void main(String[] args) {
        RandomPlayers rdPlayers = new RandomPlayers();
        rdPlayers.setVisible(true);

        threadRandom = new Thread(rdPlayers);
    }

    public RandomPlayers() {
        initComponent();
        initEvents();
    }

    private void initComponent() {
        setTitle(TITLE_OF_APP);
        setSize(WIDTH_OF_APP, HEIGHT_OF_APP);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        container.setLayout(null);

        lbBackground = new JLabel();
        lbBackground.setBounds(0, 0, 600, 400);
        lbBackground.setIcon(ImageUtils.load(IMAGE_BACKGROUND + "background.jpg", 600, 400));
        container.add(lbBackground);

        btStart = new JButton();
        btStart.setBounds(250, 150, 80, 80);
        btStart.setIcon(ImageUtils.load(IMAGE_BACKGROUND + "start.png", 80, 80));
        btStart.setFocusPainted(false);
        lbBackground.add(btStart);

        lbFirstPlayer = new JLabel();
        lbFirstPlayer.setBounds(50, 170, 80, 110);
        lbFirstPlayer.setIcon(ImageUtils.load(IMAGE_BACKGROUND
                + "question.png", SizeUtils.getWidth(lbFirstPlayer), SizeUtils.getHeight(lbFirstPlayer)));
        lbBackground.add(lbFirstPlayer);

        lbSecondPlayer = new JLabel();
        lbSecondPlayer.setBounds(450, 170, SizeUtils.getWidth(lbFirstPlayer), SizeUtils.getHeight(lbFirstPlayer));
        lbSecondPlayer.setIcon(ImageUtils.load(IMAGE_BACKGROUND
                + "question.png", SizeUtils.getWidth(lbFirstPlayer), SizeUtils.getHeight(lbFirstPlayer)));
        lbBackground.add(lbSecondPlayer);

        lbThirdPlayer = new JLabel();
        lbThirdPlayer.setBounds(250, 20, SizeUtils.getWidth(lbFirstPlayer), SizeUtils.getHeight(lbFirstPlayer));
        lbThirdPlayer.setIcon(ImageUtils.load(IMAGE_BACKGROUND
                + "question.png", SizeUtils.getWidth(lbFirstPlayer), SizeUtils.getHeight(lbFirstPlayer)));
        lbBackground.add(lbThirdPlayer);

    }

    private void initEvents() {
        btStartEvents();
    }

    private void btStartEvents() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isRunning) {
                    resume();
                } else if (playersList.size() == FIRST_GROUP.length + SECOND_GROUP.length + THIRD_GROUP.length) {
                    threadRandom.stop();
                } else {
                    threadRandom.start();
                }
            }

        });
    }

    private boolean isContained(List<String> list, String path) {
        for (String str : list) {
            if (path.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            String firstPlayer = FIRST_GROUP[rd.nextInt(FIRST_GROUP.length)];
            String pathOfFirstGroup = IMAGE_DIRECTORY_FIRST_GROUP + firstPlayer + ".png";
            String secondPlayer = SECOND_GROUP[rd.nextInt(SECOND_GROUP.length)];
            String pathOfSecondGroup = IMAGE_DIRECTORY_SECOND_GROUP + secondPlayer + ".png";
            String thirdPlayer =THIRD_GROUP[rd.nextInt(THIRD_GROUP.length)];
            String pathOfThirdGroup = IMAGE_DIRECTORY_THIRD_GROUP + thirdPlayer + ".png";
            if (!isContained(playersList, firstPlayer)
                    && !isContained(playersList, secondPlayer) && !isContained(playersList, thirdPlayer)) {
                isRunning = !isRunning;
            }
            synchronized (this) {
                while (!isRunning) {
                    add(firstPlayer,secondPlayer,thirdPlayer);
                    IOFile.updateFile(DIRECTORY_FILE, firstPlayer,secondPlayer,thirdPlayer);
                    lbFirstPlayer.setIcon(ImageUtils.load(pathOfFirstGroup, SizeUtils.getWidth(lbFirstPlayer), SizeUtils.getHeight(lbFirstPlayer)));
                    lbSecondPlayer.setIcon(ImageUtils.load(pathOfSecondGroup, SizeUtils.getWidth(lbSecondPlayer), SizeUtils.getHeight(lbFirstPlayer)));
                    lbThirdPlayer.setIcon(ImageUtils.load(pathOfThirdGroup, SizeUtils.getWidth(lbThirdPlayer), SizeUtils.getHeight(lbFirstPlayer)));
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        ex.getStackTrace();
                    }
                }

            }
        }
    }

    private synchronized void resume() {
        isRunning = !isRunning;
        notify();
    }
    private void add(String... path){
        for(String str:path){
            playersList.add(str);
        }
    }
}
