/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.StaffService;
import service.StaffServiceImpl;
import utils.ImageUtils;

/**
 *
 * @author SMILE ^^
 */
public class Ex02 extends JFrame {

    private static final String APP_TITLE = "LOGIN FORM";
    private static final int APP_WIDTH = 850;
    private static final int APP_HEIGHT = 540;
    private static final String APP_ICON = "E:\\java06-swing-app\\Lesson19_BaiTap_Nhom1\\src\\main\\java\\images\\icon_app.png";
    private static final String PATH_IMAGE_BG = "E:\\java06-swing-app\\Lesson19_BaiTap_Nhom1\\src\\main\\java\\images\\login_form.jpg";

    private final Ex02Sub hotelManager = new Ex02Sub("HOTEL MANAGER");

    private final Container container = getContentPane();
    private JLabel lbBg;
    private JButton btExit;

    private JTextField tfUserName;

    private JPasswordField tfPassword;

    private JButton btLogin;

    public Ex02(String title) {
        super(title);
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02(APP_TITLE);
        ex02.setVisible(true);

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setIconImage(ImageUtils.load(APP_ICON));
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        lbBg = new JLabel(ImageUtils.loadImageIcon(PATH_IMAGE_BG, 850, 540));
        container.add(lbBg);

        btExit = new JButton("X");
        btExit.setFocusPainted(false);
        btExit.setBackground(Color.red);
        btExit.setBounds(550, 77, 47, 47);

        lbBg.add(btExit);

        tfUserName = new JTextField();
        tfUserName.setBounds(297, 207, 250, 35);
        focusOnTextField();
        tfUserName.grabFocus();
        tfUserName.requestFocusInWindow();
        lbBg.add(tfUserName);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(297, 277, 250, 35);
        lbBg.add(tfPassword);

        btLogin = new JButton("LOGIN");
        btLogin.setForeground(Color.WHITE);
        btLogin.setBackground(Color.red);
        btLogin.setBounds(297, 377, 250, 35);
        lbBg.add(btLogin);
    }

    private void initEvents() {
        btLoginEvents();
        btExitEvents();
    }

    private void btExitEvents() {
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
    }

    private void btLoginEvents() {
        btLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (checkInput()) {
                    if (checkStaff()) {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        setVisible(false);
                        hotelManager.setVisible(true);
                    } else {
                        System.out.println(tfPassword.getText());
                        JOptionPane.showMessageDialog(null, "Incorrect login username or password!\nPlease input again!");
                        tfUserName.requestFocusInWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please complete all information!");
                    tfUserName.requestFocusInWindow();
                }
            }
        });
    }

    private boolean checkInput() {
        return !(tfUserName.getText().isEmpty() || tfPassword.getText().isEmpty());
    }

    private boolean checkStaff() {
        StaffService staffService = new StaffServiceImpl();
        return staffService.getStaff(tfUserName.getText(), tfPassword.getText()) != null;
    }

    private void focusOnTextField() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                tfUserName.requestFocus();
            }
        });
    }
}
