/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VO DINH DUNG
 */
public class Ex02 extends javax.swing.JFrame {

    private HotelManager hotelManager = new HotelManager();
    private BorderLayout borderLayout = new BorderLayout();

    /**
     * Creates new form Ex02
     */
    public Ex02() {

        initComponents();
        setLocationRelativeTo(null);
        initEvents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPassword = new javax.swing.JTextField();
        tfUserName = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        lbBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 268, 260, 40));

        tfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 260, 40));

        btLogin.setBackground(new java.awt.Color(255, 102, 0));
        btLogin.setForeground(new java.awt.Color(255, 255, 255));
        btLogin.setText("Login");
        btLogin.setOpaque(true);
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 260, 50));

        btExit.setForeground(new java.awt.Color(255, 0, 0));
        btExit.setText("X");
        getContentPane().add(btExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 70, 60, 50));

        lbBackground.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Desktop\\java06-swing-app\\lesson19_baitap_nhom4\\src\\main\\java\\images\\convenient-login-form.jpg")); // NOI18N
        getContentPane().add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initEvents() {
        btLoginEvent();
        btExitEvent();
    }

    private void btLoginEvent() {
        btLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isAccountValid(tfUserName.getText(), tfPassword.getText())) {
                    hotelManager.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tài khoản không hợp lệ, vui lòng nhập lại");
                }
            }

        });
    }

    private void btExitEvent() {
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
    }
    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLoginActionPerformed

    private void tfUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserNameActionPerformed

    private boolean isAccountValid(String userInput, String passInput) {
        try {
            String url = "jdbc:mysql://localhost/DULIEU?serverTimezone=UTC";
            String username = "root";
            String pass = "";
            Connection connect = DriverManager.getConnection(url, username, pass);
            String sql = "SELECT * FROM admin";
            Statement st = connect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String user = res.getString("Username");
                String password = res.getString("Password");
                if (userInput.equals(user)) {
                    if (passInput.equals(password)) {
                        System.out.println("Login thành công");
                        hotelManager.setVisible(true);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ex02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables

}
