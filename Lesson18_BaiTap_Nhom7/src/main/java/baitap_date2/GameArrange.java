/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap_date2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class GameArrange extends JFrame {

    private String[] OG = {"OG-Notail", "OG-Ana", "OG-Jerax", "OG-Ceb", "OG-Topson"};
    private String[] PSGLGD = {"PSGLGD-Fy", "PSGLGD-Xnova", "PSGLGD-Ame", "PSGLGD-Sommus", "PSGLGD-Chalice"};
    private String[] EG = {"EG-Fly", "EG-Sumail", "EG-Arteezy", "EG-S4", "EG-Abed"};
    private String imageDir = "E:\\StudyIT\\JAVA_BKIT_NB\\Lesson18Exercise\\src\\main\\java\\image\\dota2\\";
    private String namePSGLGDHeroes, nameOGHeroes, nameEGHeroes, pathOG, pathEG, pathPSGLGD;
    private static final int TEXT_CONVERTION_APP_WIDTH = 900;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 550;
    private List<String> checkAvailableOG = new ArrayList<>();
    private List<String> checkAvailableEG = new ArrayList<>();
    private List<String> checkAvailablePSGLGD = new ArrayList<>();
    private int countRound = 0;

    private Thread threadOG, threadEG, threadPSGLGD;
    private JButton button;
    private JLabel lbOG, lbPSGLGD, lbEG, lbBackground, lbRound, lbOGname, lbEGname, lbPSGLGDname;

    private Random rd = new Random();

    public GameArrange() {
        initComponent();
        initEvent();
    }

    public static void main(String[] args) {
        GameArrange gameArrange = new GameArrange();
        gameArrange.setVisible(true);
    }

    void initComponent() {
        this.setDefaultCloseOperation(3);
        this.setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Image background = new ImageIcon(imageDir + "dota2field2.jpg").getImage().getScaledInstance(900, 550, DEFAULT_CURSOR);
        lbBackground = new JLabel(new ImageIcon(background));
        lbBackground.setLayout(new BorderLayout());
        this.setContentPane(lbBackground);
        lbBackground.setLayout(null);

        Image ogtest = new ImageIcon(imageDir + "OG.png").getImage();
        lbOG = new JLabel();
        lbOG.setIcon(new ImageIcon(ogtest));
        lbOG.setBounds(50, 50, (int) lbOG.getPreferredSize().getWidth(), (int) lbOG.getPreferredSize().getHeight());
        lbBackground.add(lbOG);

        Image egtest = new ImageIcon(imageDir + "EG.png").getImage();
        lbEG = new JLabel();
        lbEG.setIcon(new ImageIcon(egtest));
        lbEG.setBounds(600, 50, (int) lbEG.getPreferredSize().getWidth(), (int) lbEG.getPreferredSize().getHeight());
        lbBackground.add(lbEG);

        Image psglgdtest = new ImageIcon(imageDir + "PSGLGD.png").getImage();
        lbPSGLGD = new JLabel();
        lbPSGLGD.setIcon(new ImageIcon(psglgdtest));
        lbPSGLGD.setBounds(600, 300, (int) lbPSGLGD.getPreferredSize().getWidth(), (int) lbPSGLGD.getPreferredSize().getHeight());
        lbBackground.add(lbPSGLGD);

        lbRound = new JLabel("READY");
        lbRound.setForeground(Color.LIGHT_GRAY);
        lbRound.setFont(new Font("Tahoma", 1, 40));
        lbRound.setBounds(120, 320, (int) lbRound.getPreferredSize().getWidth(), (int) lbRound.getPreferredSize().getHeight());
        lbBackground.add(lbRound);

        lbOGname = new JLabel("OG");
        lbOGname.setForeground(Color.LIGHT_GRAY);
        lbOGname.setFont(new Font("Tahoma", 1, 30));
        lbOGname.setBounds(130, 190, (int) lbOGname.getPreferredSize().getWidth(), (int) lbOGname.getPreferredSize().getHeight());
        lbBackground.add(lbOGname);

        lbEGname = new JLabel("EG");
        lbEGname.setForeground(Color.LIGHT_GRAY);
        lbEGname.setFont(new Font("Tahoma", 1, 30));
        lbEGname.setBounds(690, 190, (int) lbEGname.getPreferredSize().getWidth(), (int) lbEGname.getPreferredSize().getHeight());
        lbBackground.add(lbEGname);

        lbPSGLGDname = new JLabel("PSG.LGD");
        lbPSGLGDname.setForeground(Color.LIGHT_GRAY);
        lbPSGLGDname.setFont(new Font("Tahoma", 1, 30));
        lbPSGLGDname.setBounds(650, 450, (int) lbPSGLGDname.getPreferredSize().getWidth(), (int) lbPSGLGDname.getPreferredSize().getHeight());
        lbBackground.add(lbPSGLGDname);

        button = new JButton("START");
        button.setBounds(150, 400, (int) button.getPreferredSize().getWidth(), (int) button.getPreferredSize().getHeight());
        button.setBackground(Color.LIGHT_GRAY);
        lbBackground.add(button);

    }

    void initEvent() {
        buttonEvent();
    }

    synchronized void startOG() {

        threadOG = new Thread(new Runnable() {
            @Override
            public void run() {
                //nameOGHeroes = OG[rd.nextInt(5)];
                do {
                    nameOGHeroes = OG[rd.nextInt(5)];
                } while (checkAvailableOG.contains(nameOGHeroes));
                pathOG = imageDir + nameOGHeroes + ".png";
                lbOGname.setText(nameOGHeroes);
                lbOGname.setBounds(110, 190, (int) lbOGname.getPreferredSize().getWidth(), (int) lbOGname.getPreferredSize().getHeight());
                lbOG.setIcon(new ImageIcon(pathOG));
                checkAvailableOG.add(nameOGHeroes);
            }
        });
        threadOG.start();

    }

    synchronized void startEG() {

        threadEG = new Thread(new Runnable() {
            @Override
            public void run() {
                //nameEGHeroes = EG[rd.nextInt(5)];
                do {
                    nameEGHeroes = EG[rd.nextInt(5)];
                } while (checkAvailableEG.contains(nameEGHeroes));
                pathEG = imageDir + nameEGHeroes + ".png";
                lbEGname.setText(nameEGHeroes);
                lbEGname.setBounds(660, 190, (int) lbEGname.getPreferredSize().getWidth(), (int) lbEGname.getPreferredSize().getHeight());
                lbEG.setIcon(new ImageIcon(pathEG));
                checkAvailableEG.add(nameEGHeroes);
            }
        });
        threadEG.start();
    }

    synchronized void startPSGLGD() {

        threadPSGLGD = new Thread(new Runnable() {
            @Override
            public void run() {
                //namePSGLGDHeroes = PSGLGD[rd.nextInt(5)];
                do {
                    namePSGLGDHeroes = PSGLGD[rd.nextInt(5)];
                } while (checkAvailablePSGLGD.contains(namePSGLGDHeroes));
                pathPSGLGD = imageDir + namePSGLGDHeroes + ".png";
                lbPSGLGDname.setText(namePSGLGDHeroes);
                lbPSGLGDname.setBounds(620, 450, (int) lbPSGLGDname.getPreferredSize().getWidth(), (int) lbPSGLGDname.getPreferredSize().getHeight());
                lbPSGLGD.setIcon(new ImageIcon(pathPSGLGD));
                checkAvailablePSGLGD.add(namePSGLGDHeroes);
            }
        });
        threadPSGLGD.start();
    }

    void buttonEvent() {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (checkAvailableOG.size() < 5) {
                    if (checkAvailableEG.size() == 4) {
                        button.setText("EXIT");
                    }
                    startOG();
                    startEG();
                    startPSGLGD();
                    lbRound.setText("Game " + (++countRound));
                    lbRound.setBounds(110, 320, (int) lbRound.getPreferredSize().getWidth(), (int) lbRound.getPreferredSize().getHeight());
                } else {
                    try {
                        createNewFile("game.txt");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });
    }

    void createNewFile(String path) throws IOException {
        File file = new File(path);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < 5; i++) {
                bw.write("Game " + (i + 1) + " : " + checkAvailableOG.get(i) + " vs " + checkAvailableEG.get(i) + " vs " + checkAvailablePSGLGD.get(i));
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.close(); // save and close
            fw.close();
        }
    }
}
