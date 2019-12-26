package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame{
    private static int APP_WIDTH = 500;
    private static int APP_HEIGHT = 500;
    private static String APP_ICON = "";
    private static String APP_TITLE = "Võ lâm truyền kỳ";
    private static int PADDING_X = 50;
    private static int PADDING_Y = 50;
    private static String iconDir = "";
    private static String characterImageDir = "";
    private static String buttonStart = "start_button.png";
    
    private static JLabel lbGroupA;
    private static JLabel lbGroupB;
    private static JLabel lbGroupC;
    private static JButton btStart;
    
    private final Container conn = getContentPane();
    private List<String> characterImages = Arrays.asList("poke1.png", "poke2.png", "poke3.png", 
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
        
    }

    private void initComponents() {
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(APP_WIDTH, APP_HEIGHT);
        setIconImage(ImageUtils.load(APP_ICON));
        setTitle(APP_TITLE);
        
        conn.setBackground(Color.GRAY);
        conn.setLayout(null);
        
        initialDataOfGroups();
        
        setLbGroupAView();
        setLbGroupBView();
        setLbGroupCView();
        
        conn.add(lbGroupA);
        conn.add(lbGroupB);
        conn.add(lbGroupC);
    }

    private void setBtStartEvents() {
    }

    private void setLbGroupAView() {
    }

    private void setLbGroupBView() {
    }

    private void setLbGroupCView() {
    }
    
    private void initEvents() {
        setBtStartEvents();
    }

    private void initialDataOfGroups() {
        Collections.shuffle(characterImages);
        
        for(int i = 0; i < characterImages.size() / 3; i++){
            groupA.add(characterImages.get(i));
            groupB.add(characterImages.get(i + characterImages.size() / 3));
            groupC.add(characterImages.get(i + characterImages.size() / 3 * 2));
        }
    }
}
