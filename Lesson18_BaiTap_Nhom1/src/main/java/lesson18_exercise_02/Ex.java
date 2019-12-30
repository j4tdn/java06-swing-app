/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson18_exercise_02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import utils.ImageUtils;


public class Ex extends JFrame {

    private static final String APP_TITLE = "GAME APP";
    private static final String APP_ICON = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images\\icon_app.png";
    private static final String IMAGE_BG = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images\\image_bg.jpg";
    private static final String BT_START_IMAGE = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images\\bt_start.png";
    private static final int APP_WIDTH = 900;
    private static final int APP_HEIGHT = 800;

    private static final String DIR_IMAGES = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images";
    private static final String DIR_IMAGES_TEAM1 = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image_team1";
    private static final String DIR_IMAGES_TEAM2 = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image_team2";
    private static final String DIR_IMAGES_TEAM3 = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image_team3";

    private final String INITIAL_IMAGE_MEMBER1 = DIR_IMAGES + File.separator + "team1.PNG";
    private final String INITIAL_IMAGE_MEMBER2 = DIR_IMAGES + File.separator + "team2.PNG";
    private final String INITIAL_IMAGE_MEMBER3 = DIR_IMAGES + File.separator + "team3.PNG";

    private final String[] PATHS_TEAM1 = {"crab1.jpg", "crab2.jpg", "crab3.png", "crab4.jpg", "crab5.jpg"};
    private final String[] PATHS_TEAM2 = {"crazy1.jpg", "crazy2.png", "crazy3.png", "crazy4.png", "crazy5.png"};
    private final String[] PATHS_TEAM3 = {"ghost1.jpg", "ghost2.jpg", "ghost3.jpg", "ghost4.jpg", "ghost5.jpg"};

    private static final String PATH_RESULT_FILE = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\game.txt";
    private Thread thread;

    private final List<String> results = new ArrayList<>();
    private final int NUMBER_OF_MEMBERS = 5;
    private final Container conn = getContentPane();
    private ImageIcon imageBg;

    private JLabel lbMember1;
    private JLabel lbMember2;
    private JLabel lbMember3;

    private JButton btStart;

    private JLabel lbImageBg;

    private Team team1;
    private Team team2;
    private Team team3;

    private final Set<Integer> checkMember1 = new HashSet<>();
    private final Set<Integer> checkMember2 = new HashSet<>();
    private final Set<Integer> checkMember3 = new HashSet<>();

    public Ex() {
        initTeams();
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex ex = new Ex();
        ex.setVisible(true);
    }

    private void initComponents() {

        conn.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(APP_TITLE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        setIconImage(ImageUtils.load(APP_ICON));

        btStart = new JButton(ImageUtils.loadImageIcon(BT_START_IMAGE, 200, 40));
        btStart.setBounds(60, 460, 200, 40);
        conn.add(btStart);

        imageBg = ImageUtils.loadImageIcon(IMAGE_BG, 900, 800);
        lbImageBg = new JLabel(imageBg);
        lbImageBg.setBounds(0, 0, 900, 800);
        conn.add(lbImageBg);

        lbMember1 = new JLabel(ImageUtils.loadImageIcon(INITIAL_IMAGE_MEMBER1, 200, 200));
        lbMember1.setBounds(150, 50, 200, 200);
        lbImageBg.add(lbMember1);

        lbMember2 = new JLabel(ImageUtils.loadImageIcon(INITIAL_IMAGE_MEMBER2, 200, 200));
        lbMember2.setBounds(600, 50, 200, 200);
        lbImageBg.add(lbMember2);

        lbMember3 = new JLabel(ImageUtils.loadImageIcon(INITIAL_IMAGE_MEMBER3, 200, 200));
        lbMember3.setBounds(360, 500, 200, 200);
        lbImageBg.add(lbMember3);

    }

    private void initEvents() {
        btStartEvents();
    }

    private void initTeams() {
        team1 = Team.Team("Team 1", DIR_IMAGES_TEAM1, PATHS_TEAM1);
        team2 = Team.Team("Team 2", DIR_IMAGES_TEAM2, PATHS_TEAM2);
        team3 = Team.Team("Team 3", DIR_IMAGES_TEAM3, PATHS_TEAM3);
    }

    private void btStartEvents() {

        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                randomMember();
            }
        });
    }

    private void writeFile(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.write(Paths.get(path), results);
        } catch (IOException ex) {
            Logger.getLogger(Ex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void randomMember() {
        Random rd = new Random();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Member> members1 = team1.getTeam();
                List<Member> members2 = team2.getTeam();
                List<Member> members3 = team3.getTeam();
                int index1, index2, index3;
                int count = 1;
                while (count <= 5) {
                    printMessage("Trận đấu " + count);
                    while (true) {
                        index1 = rd.nextInt(NUMBER_OF_MEMBERS);
                        if (checkMember1.add(index1)) {
                            break;
                        }
                    }
                    while (true) {
                        index2 = rd.nextInt(NUMBER_OF_MEMBERS);
                        if (checkMember2.add(index2)) {
                            break;
                        }
                    }
                    while (true) {
                        index3 = rd.nextInt(NUMBER_OF_MEMBERS);
                        if (checkMember3.add(index3)) {
                            break;
                        }
                    }
                    getResult(count, index1, index2, index3);
                    lbMember1.setIcon(ImageUtils.loadImageIcon(members1.get(index1).getPath(), 200, 200));
                    lbMember2.setIcon(ImageUtils.loadImageIcon(members2.get(index2).getPath(), 200, 200));
                    lbMember3.setIcon(ImageUtils.loadImageIcon(members3.get(index3).getPath(), 200, 200));
                    count++;
                    
                    if (count > 5) {
                        JOptionPane.showMessageDialog(conn, "Vào trận!");
                        writeFile(PATH_RESULT_FILE);
                    }
                }
                sleep(2);
            }
        });
        thread.start();
    }

    private void getResult(int count, int index1, int index2, int index3) {
        StringBuilder bufStrResult = new StringBuilder();
        String nameMember1 = team1.getTeam().get(index1).getName();
        String nameMember2 = team2.getTeam().get(index2).getName();
        String nameMember3 = team3.getTeam().get(index3).getName();
        bufStrResult.append("Trận đấu ").append(count).append(": ").append(nameMember1).append(" vs ").append(nameMember2).append(" vs ").append(nameMember3);
        results.add( bufStrResult.toString());
    }

    private void printMessage(String message) {
        final JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("Message");
        dialog.setModal(true);
        dialog.setLocation(550, 350);

        dialog.setContentPane(optionPane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        Timer timer = new Timer(1500, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }

    private void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
