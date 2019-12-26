package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;
import utils.SizeUtils;

/**
 *
 * @author huyvi
 */
public class MainView extends JFrame{
    private static final int APP_WIDTH = 1000;
    private static final int APP_HEIGHT = 700;
    private static final String APP_ICON = "play3.png";
    private static final String APP_TITLE = "Võ lâm truyền kỳ";
    private static final int INITIAL_PADDING_X = 200;
    private static final int INITIAL_PADDING_Y = 50;
    private static final String iconDir = "E:\\workspace\\swing\\volamtruyenky\\src\\main\\java\\images\\icon";
    private static final String characterImageDir = "E:\\workspace\\swing\\volamtruyenky\\src\\main\\java\\images\\character";
    private static final String buttonStartImage = "start_button.png";
    private static final String logoImage = "logo.png";
    
    private static JLabel lbGroupA;
    private static JLabel lbGroupB;
    private static JLabel lbGroupC;
    private static JLabel lbLogo;
    private static JLabel lbStart;
    
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
        conn.add(lbStart);
    }

    private void setLbStartEvents() {
    }

    private void setLbGroupAView() {
        lbGroupA = new JLabel();
        
        lbGroupA.setIcon(ImageUtils.loadImageIcon(characterImageDir + File.separator + groupA.get(0), 150, 150));
        lbGroupA.setBounds(INITIAL_PADDING_X, 
                INITIAL_PADDING_Y, 
                SizeUtils.getPreWidth(lbGroupA), 
                SizeUtils.getPreHeight(lbGroupA));
    }

    private void setLbGroupBView() {
        lbGroupB = new JLabel();
        
        lbGroupB.setIcon(ImageUtils.loadImageIcon(characterImageDir + File.separator + groupB.get(0), 150, 150));
        lbGroupB.setBounds(APP_WIDTH - INITIAL_PADDING_X - SizeUtils.getPreWidth(lbGroupB), 
                INITIAL_PADDING_Y, 
                SizeUtils.getPreWidth(lbGroupB), 
                SizeUtils.getPreHeight(lbGroupB));
    }

    private void setLbGroupCView() {
        lbGroupC = new JLabel();
        
        lbGroupC.setIcon(ImageUtils.loadImageIcon(characterImageDir + File.separator + groupC.get(0), 150, 150));
        lbGroupC.setBounds((APP_WIDTH - SizeUtils.getPreWidth(lbGroupC)) / 2, 
                INITIAL_PADDING_Y + 400, 
                SizeUtils.getPreWidth(lbGroupC), 
                SizeUtils.getPreHeight(lbGroupC));
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
        lbStart = new JLabel();
        
        lbStart.setIcon(ImageUtils.loadImageIcon(iconDir + File.separator + buttonStartImage, 100, 100));
        lbStart.setBounds(100, 
                lbGroupC.getX() - 50, 
                SizeUtils.getPreWidth(lbStart), 
                SizeUtils.getPreHeight(lbStart));
    }
    
    private void initEvents() {
        setLbStartEvents();
    }

    private void initialDataOfGroups() {
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();
        groupC = new ArrayList<>();
        
        Collections.shuffle(characterImages);
        
        for(int i = 0; i < characterImages.size() / 3; i++){
            groupA.add(characterImages.get(i));
            groupB.add(characterImages.get(i + characterImages.size() / 3));
            groupC.add(characterImages.get(i + characterImages.size() / 3 * 2));
        }
    }

}
