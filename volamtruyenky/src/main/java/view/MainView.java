package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.FileUtils;
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame {

    private final int APP_WIDTH = 1000;
    private final int APP_HEIGHT = 700;
    private final String APP_ICON = "play3.png";
    private final String APP_TITLE = "Võ lâm truyền kỳ";
    private final int INITIAL_PADDING_X = 200;
    private final int INITIAL_PADDING_Y = 50;
    private final String iconDir = "F:\\java swing\\java06-swing-app\\volamtruyenky\\src\\main\\java\\images\\icon";
    private final String characterImageDir = "F:\\java swing\\java06-swing-app\\volamtruyenky\\src\\main\\java\\images\\character";
    private final String buttonStartImage = "start_button.png";
    private final String logoImage = "logo.png";

    private final String pathTxt = "F:\\java swing\\java06-swing-app\\volamtruyenky\\volam.txt";

    private final Random rd = new Random();

    private JLabel lbGroupA;
    private JLabel lbGroupB;
    private JLabel lbGroupC;
    private JLabel lbLogo;
    private JButton btStart;
    private Thread thread;

    private final boolean isRunning = true;

    private final Container conn = getContentPane();
    private final List<String> characterImages = Arrays.asList("poke1.png", "poke2.png", "poke3.png",
            "poke4.png", "poke5.png", "poke6.png",
            "poke7.png", "poke8.png", "poke9.png",
            "poke10.png", "poke11.png", "poke12.png",
            "poke13.png", "poke14.png", "poke15.png");
    private List<String> groupA;
    private List<String> groupB;
    private List<String> groupC;

    public MainView() throws HeadlessException {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        MainView main = new MainView();
        main.setVisible(true);
    }

    private void initComponents() {
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setSize(APP_WIDTH, APP_HEIGHT);
        setIconImage(ImageUtils.load(iconDir + File.separator + APP_ICON));
        setTitle(APP_TITLE);

        conn.setBackground(Color.GRAY);
        conn.setLayout(null);

        initialDataOfGroups();

        setLbGroupAView();
        setLbGroupBView();
        setLbGroupCView();
        setLbLogoView();
        setBtStartView();

        conn.add(lbGroupA);
        conn.add(lbGroupB);
        conn.add(lbGroupC);
        conn.add(lbLogo);
        conn.add(btStart);

    }

    private void setLbGroupAView() {
        lbGroupA = new JLabel();

        lbGroupA.setIcon(ImageUtils.loadImageIcon(iconDir + File.separator + "Team-1.jpg", 150, 150));
        lbGroupA.setBounds(INITIAL_PADDING_X,
                INITIAL_PADDING_Y,
                SizeUtils.getPreWidth(lbGroupA),
                SizeUtils.getPreHeight(lbGroupA));
    }

    private void setLbGroupBView() {
        lbGroupB = new JLabel();

        lbGroupB.setIcon(ImageUtils.loadImageIcon(iconDir + File.separator + "Team-2.jpg", 150, 150));
        lbGroupB.setBounds(APP_WIDTH - INITIAL_PADDING_X - SizeUtils.getPreWidth(lbGroupB),
                INITIAL_PADDING_Y,
                SizeUtils.getPreWidth(lbGroupB),
                SizeUtils.getPreHeight(lbGroupB));
    }

    private void setLbGroupCView() {
        lbGroupC = new JLabel();

        lbGroupC.setIcon(ImageUtils.loadImageIcon(iconDir + File.separator + "Team-3.jpg", 150, 150));
        lbGroupC.setBounds((APP_WIDTH - SizeUtils.getPreWidth(lbGroupC)) / 2,
                INITIAL_PADDING_Y + 400,
                SizeUtils.getPreWidth(lbGroupC),
                SizeUtils.getPreHeight(lbGroupC));
    }

    private void initialDataOfGroups() {
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();
        groupC = new ArrayList<>();

        Collections.shuffle(characterImages);

        for (int i = 0; i < characterImages.size() / 3; i++) {
            groupA.add(characterImages.get(i));
            groupB.add(characterImages.get(i + characterImages.size() / 3));
            groupC.add(characterImages.get(i + characterImages.size() / 3 * 2));
        }
        // Reset lại dữ liệu trong file txt
        FileUtils.writeFile(pathTxt, "");

        FileUtils.addDataToFile(pathTxt, "TEAM A =============");
        for (int i = 0; i < groupA.size(); i++) {
            FileUtils.addDataToFile(pathTxt, groupA.get(i));
        }
        FileUtils.addDataToFile(pathTxt, "TEAM B =============");
        for (int i = 0; i < groupB.size(); i++) {
            FileUtils.addDataToFile(pathTxt, groupB.get(i));
        }
        FileUtils.addDataToFile(pathTxt, "TEAM C =============");
        for (int i = 0; i < groupB.size(); i++) {
            FileUtils.addDataToFile(pathTxt, groupC.get(i));
        }
    }

    private void randomGroup() {

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                int[] resultSet = new int[characterImages.size() / 3];
                int count = 0;

                for (int i = 0; i < characterImages.size() / 3; i++) {

                    int random = rd.nextInt(characterImages.size() / 3);
                    System.out.println(random);
                    if (contains(resultSet, random)) {
                        i--;
                        continue;
                    }
                    resultSet[count] = random;
                    count++;

                    FileUtils.addDataToFile(pathTxt, "ROUND " + (i + 1) + "==============");
                    lbGroupA.setIcon(ImageUtils
                            .loadImageIcon(characterImageDir + File.separator + groupA.get(random), 150, 150));
                    System.out.println(groupA.get(random));
                    FileUtils.addDataToFile(pathTxt, groupA.get(random));

                    lbGroupB.setIcon(ImageUtils.
                            loadImageIcon(characterImageDir + File.separator + groupB.get(random), 150, 150));
                    System.out.println(groupB.get(random));
                    FileUtils.addDataToFile(pathTxt, groupB.get(random));

                    lbGroupC.setIcon(ImageUtils
                            .loadImageIcon(characterImageDir + File.separator + groupC.get(random), 150, 150));
                    System.out.println(groupC.get(random));
                    FileUtils.addDataToFile(pathTxt, groupC.get(random));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
    }

    private boolean contains(int[] resultSet, int rand) {
        for (int i = 0; i < resultSet.length; i++) {
            if (resultSet[i] == 0) {
                return false;
            }
            if (resultSet[i] == rand) {
                return true;
            }
        }
        return false;
    }

    private void setLbLogoView() {
        lbLogo = new JLabel();

        lbLogo.setIcon(ImageUtils.loadImageIcon(iconDir + File.separator + logoImage, 450, 200));
        lbLogo.setBounds((APP_WIDTH - SizeUtils.getPreWidth(lbLogo)) / 2,
                lbGroupA.getY() + SizeUtils.getPreHeight(lbGroupA),
                SizeUtils.getPreWidth(lbLogo),
                SizeUtils.getPreHeight(lbLogo));

    }

    private void setBtStartView() {
        btStart = new JButton();

        btStart.setIcon(ImageUtils.loadImageIcon(iconDir + File.separator + buttonStartImage, 100, 100));
        btStart.setBounds(100,
                lbGroupC.getX() - 50,
                SizeUtils.getPreWidth(btStart),
                SizeUtils.getPreHeight(btStart));
    }

    private void initEvents() {
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                randomGroup();
            }

        });
    }

}
