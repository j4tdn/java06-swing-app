/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseDate2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.ImageUtils;
import utils.PlayerUtils;
import utils.SizeUtils;

/**
 *
 * @author Admin
 */
public class Ex01 extends JFrame {

    private final Container container = getContentPane();
    private static JLabel lbImage;
    private static JLabel lbImage2;
    private static JLabel lbImage3;
    private JButton btStop;
    private Thread imageThread;
    private static String imageDir = "D:\\JAVA\\Netbeans\\Lesson18_BaiTap_Nhom3\\src\\main\\java\\images";
    private static String imageGhostDir = imageDir + File.separator + "ghost";

    private final String[] images1 = {"DT1.jpg", "DT2.jpg", "DT3.jpg", "DT4.jpg", "DT5.jpg"};
    private final String[] images2 = {"G1.jpg", "G2.jpg", "G3.jpg", "G4.jpg", "G5.jpg"};
    private final String[] images3 = {"VL1.jpg", "VL2.jpg", "VL3.jpg", "VL4.jpg", "VL5.jpg"};
    private final String initImage = images1[0];
    private final String initImage2 = images2[0];
    private final String initImage3 = images3[0];
    private final String pauseIcon = imageDir + File.separator + "48px_pause.png";
    private final String playIcon = imageDir + File.separator + "48px_play.png";
    private final List<PlayerUtils> team1 = createTeam(images1, 1);
    private final List<PlayerUtils> team2 = createTeam(images2, 2);
    private final List<PlayerUtils> team3 = createTeam(images3, 3);

    private boolean isRunning = false;

    public Ex01() {
        initComponents();
        initEvents();

    }

    private void initComponents() {
        setDefaultCloseOperation(3);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Võ Lâm Truyền kì");
        container.setLayout(null);
        container.setBackground(Color.GREEN);

        lbImage = new JLabel();
        Image image = ImageUtils.load(imageGhostDir + File.separator + "ImagePlayer.png").getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        lbImage.setIcon(new ImageIcon(image));
        lbImage.setBounds(50, 20, SizeUtils.getPreWidth(lbImage), SizeUtils.getPreHeight(lbImage));

        lbImage2 = new JLabel();
        Image image2 = ImageUtils.load(imageGhostDir + File.separator + "ImagePlayer.png").getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        lbImage2.setIcon(new ImageIcon(image2));
        lbImage2.setBounds(350, 20, SizeUtils.getPreWidth(lbImage2), SizeUtils.getPreHeight(lbImage2));

        lbImage3 = new JLabel();
        Image image3 = ImageUtils.load(imageGhostDir + File.separator + "ImagePlayer.png").getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        lbImage3.setIcon(new ImageIcon(image3));
        lbImage3.setBounds(650, 20, SizeUtils.getPreWidth(lbImage3), SizeUtils.getPreHeight(lbImage3));

        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setIcon(ImageUtils.loadimageIcon(playIcon, 100, 100));
        btStop.setBounds(400, 300, SizeUtils.getPreWidth(btStop), SizeUtils.getPreHeight(btStop));

        container.add(lbImage);
        container.add(lbImage2);
        container.add(lbImage3);
        container.add(btStop);

        randomPlayer(team1, team2, team3);
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
                    btStop.setIcon(ImageUtils.loadimageIcon(playIcon, 100, 100));
                    System.exit(0);
                } else {
                    isRunning = !isRunning;
                    imageThread.start();
                    btStop.setIcon(ImageUtils.loadimageIcon(pauseIcon, 100, 100));
                }
            }
            
        }); 
        
    }

    private static List<PlayerUtils> createTeam(String[] image, int teamNumber) {
        List<PlayerUtils> team = new ArrayList<>();
        PlayerUtils player;
        for (int i = 0; i < image.length; i++) {
            String[] namePlayer = image[i].trim().split("\\.");
            player = new PlayerUtils(namePlayer[0], image[i], teamNumber);
            team.add(player);
        }
        return team;
    }

    private void randomPlayer(List<PlayerUtils> team1, List<PlayerUtils> team2,
            List<PlayerUtils> team3) {
        Random rd = new Random();
        imageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String save = "";
                int count = 0;
                while (count < 5) {
                    PlayerUtils player1;
                    PlayerUtils player2;
                    PlayerUtils player3;
                    player1 = randomTeamPlayer(team1);
                    player2 = randomTeamPlayer(team2);
                    player3 = randomTeamPlayer(team3);
                    save += "Game: " + ++count + " : "
                            + player1.toString() + " vs " + player2.toString()
                            + " vs " + player3.toString() + "\n";

                    setImage(player1);
                    setImage(player2);
                    setImage(player3);
                    sleep(1);
                }
                writeFile(save);
            }
        });

    }

    private static void setImage(PlayerUtils player) {
        String path = imageGhostDir + File.separator + player.getImagePlayer();
        Image image = ImageUtils.load(path).getScaledInstance(300, 250,
                Image.SCALE_SMOOTH);
        if (player.getTeam() == 1) {
            lbImage.setIcon(new ImageIcon(image));
        } else if (player.getTeam() == 2) {
            lbImage2.setIcon(new ImageIcon(image));
        } else {
            lbImage3.setIcon(new ImageIcon(image));
        }
    }

    //Random one player from team
    private static PlayerUtils randomTeamPlayer(List<PlayerUtils> team) {
        int i;
        while (true) {
            Random rd = new Random();
            i = rd.nextInt(5);
            if (!team.get(i).getIsPlayed()) {
                team.get(i).setIsPlayed(true);
                break;
            }
        }
        return team.get(i);
    }

    private void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static void writeFile(String save) {
        String pathFile = "D:\\JAVA\\Netbeans\\Lesson18_BaiTap_Nhom3\\Game.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(pathFile);
            bw = new BufferedWriter(fw);
            bw.write(save);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        ex01.setVisible(true);
    }
}
