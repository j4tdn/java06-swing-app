/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson18_exercise_02;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author SMILE ^^
 */
public class Ex extends JFrame {

    private static final String APP_TITLE = "GAME APP";
    private static final String APP_ICON = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images\\icon_app.png";
    private static final String IMAGE_BG = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images\\image_bg.jpg";
    private static final String BT_START_IMAGE = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\images\\bt_start.png";
    private static final int APP_WIDTH = 900;
    private static final int APP_HEIGHT = 700;

    private static final String IMAGE_MEMBER1 = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image_team1\\orange_crab.png";
    private static final String IMAGE_MEMBER2 = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image_team1\\green_crab.png";
    private static final String IMAGE_MEMBER3 = "E:\\java06-swing-app\\Lesson18_BaiTap_Nhom1\\src\\main\\java\\image_team1\\blue_crab.png";

//    private static final int VERITICAL_PADDING = 40;
//    private static final int HORIZONTAL_PADDING = 80;
//    private static final int INITTIAL_HEADER_X_PADDING = 40;
//    private static final int INITTIAL_HEADER_Y_PADDING = 30;
    private final Container conn = getContentPane();
    private ImageIcon imageBg;

    private JLabel lbMember1;
    private JLabel lbMember2;
    private JLabel lbMember3;

    private JButton btStart;

    private JLabel lbImageBg;

    public Ex() {
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

        btStart = new JButton(ImageUtils.loadImageIcon(BT_START_IMAGE, 180, 40));
        btStart.setBounds(360, 440, 180, 40);
        conn.add(btStart);

//        imageBg = ImageUtils.loadImageIcon(IMAGE_BG, 1000, 700);
//        lbImageBg = new JLabel(imageBg);
//        lbImageBg.setBounds(0, 0, 1000, 700);
//        conn.add(lbImageBg);
        lbMember1 = new JLabel(ImageUtils.loadImageIcon(IMAGE_MEMBER1, 200, 200));

        lbMember1.setBounds(150, 50, 200, 200);
        conn.add(lbMember1);

        lbMember2 = new JLabel(ImageUtils.loadImageIcon(IMAGE_MEMBER2, 200, 200));
        lbMember2.setBounds(600, 50, 200, 200);
        conn.add(lbMember2);

        lbMember3 = new JLabel(ImageUtils.loadImageIcon(IMAGE_MEMBER3, 200, 200));
        lbMember3.setBounds(360, 500, 200, 200);
        conn.add(lbMember3);

    }

    private void initEvents() {
        btStartEvents();
    }

    private void btStartEvents() {

    }
}
