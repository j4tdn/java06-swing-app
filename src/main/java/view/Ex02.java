/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import util.SizeUtils;

/**
 *
 * @author PC
 */
public class Ex02 extends JFrame {

    private final String imageDir;
    private static final int TEXT_CONVERTION_APP_WIDTH = 900;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 550;
    private JButton buttonLogin;
    private JButton buttonReset;
    private JLabel lbBackground;
    private JTextField tName;
    private JPasswordField tPass;
    private JRadioButton rememberPass;
    private JButton JWarning;
    private Connection conn=null;
    private PreparedStatement ps= null;
    private ResultSet rs= null;

    public Ex02() {
        this.imageDir = "E:\\Java06\\Lesson19_BaiTap_Nhom5\\src\\main\\java\\image\\";
        initComponent();
        initEvent();
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();
        ex02.setVisible(true);
    }

    private void initComponent() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Image background = new ImageIcon(imageDir + "convenient-login-form.jpg").getImage().getScaledInstance(900, 550, DEFAULT_CURSOR);
        lbBackground = new JLabel(new ImageIcon(background));
        lbBackground.setLayout(new BorderLayout());
        this.setContentPane(lbBackground);
        lbBackground.setLayout(null);

        buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(380, 375, (int) buttonLogin.getPreferredSize().getWidth(), (int) buttonLogin.getPreferredSize().getHeight());
        buttonLogin.setBackground(Color.ORANGE);
        lbBackground.add(buttonLogin);

        buttonReset = new JButton("RESET");
        buttonReset.setBounds(450, 375, (int) buttonReset.getPreferredSize().getWidth(), (int) buttonReset.getPreferredSize().getHeight());
        buttonReset.setBackground(Color.ORANGE);
        lbBackground.add(buttonReset);

        tName = new JTextField();
        tName.setBounds(315, 200, SizeUtils.getWidth(tName), SizeUtils.getHeight(tName));
        tName.setSize(255, 30);
        lbBackground.add(tName);

        tPass = new JPasswordField();
        tPass.setBounds(315, 270, SizeUtils.getWidth(tPass), SizeUtils.getHeight(tPass));
        tPass.setSize(255, 30);
        lbBackground.add(tPass);

        rememberPass = new JRadioButton("Remember your password!");
        rememberPass.setBounds(315, 310, SizeUtils.getWidth(rememberPass), SizeUtils.getHeight(rememberPass));
        rememberPass.setSize(255, 30);
        lbBackground.add(rememberPass);

        JWarning = new JButton();
        JWarning.setText("Forgot your password ?");
        JWarning.setBounds(315, 410, SizeUtils.getWidth(JWarning), SizeUtils.getHeight(JWarning));
        JWarning.setSize(255, 30);
        lbBackground.add(JWarning);

    }

    private void initEvent() {
        btLogin();
        btReset();
    }

     private void btLogin() {
        buttonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                loginEvent();
            }
            
        });
    }
     private void btReset(){
         buttonReset.addMouseListener(new MouseAdapter() {
             @Override
             public void mousePressed(MouseEvent e) {
                 resetEvent();
             }
             
         });
     }
    private void loginEvent() {
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tName.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng điền Username");
                } else if (tPass.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng điền Password");
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn=DriverManager.getConnection("jdbc:mysql://localhost:3308/dulieu", "root", "");
                        String sqlQuery = "SELECT * FROM admin\n"
                                + "WHERE User=? AND Pass=?";
                        ps = conn.prepareStatement(sqlQuery);
                        ps.setString(1, tName.getText());
                        ps.setString(2, new String(tPass.getPassword()));
                        rs = ps.executeQuery(sqlQuery);
                        if (rs.next()){
                            JOptionPane.showMessageDialog(rootPane, "Bạn đăng nhập thành công");
                             HotelManagement hm = new HotelManagement();
                             hm.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Bạn đăng nhập thất bại");
                        }
                        
                    } catch (HeadlessException | SQLException b) {
                        System.out.println(b);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Ex02.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private void resetEvent() {
        buttonReset.addActionListener((ActionEvent e) -> {
            tName.setText("");
            tPass.setText("");
        });
    }
    private String getMD5(String md5){
        try {
            MessageDigest md= MessageDigest.getInstance("MD5");
            byte[] array= md.digest(md5.getBytes());
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<=array.length;i++){
                sb.append(Integer.toHexString((array[i]&0xFF)|0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }
        return null;
    }
}
