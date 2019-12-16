/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author qphan
 */
public class Ex03 extends JFrame {

    private static final int HELLO_APP_WIDTH = 800;
    private static final int HELLO_APP_HEIGHT = 400;
    private static final String HELLO_APP_TITLE = "Ex03 - Todo app";

    public Ex03() {
        initComponents();
    }

    public static void main(String[] args) {
        Ex03 todoApp = new Ex03();
        todoApp.setVisible(true);
    }

    private void initComponents() {
        Container conn = getContentPane();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(HELLO_APP_WIDTH, HELLO_APP_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(HELLO_APP_TITLE);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\qphan\\Pictures\\lesson18_images\\64px_flower.png");
        setIconImage(imageIcon.getImage());
        
        conn.setLayout(null);
        conn.setBackground(Color.yellow);
        
        JLabel lbText = new JLabel();
        lbText.setPreferredSize(new Dimension(260, 60));
        lbText.setText("This is my first app !!!");
        lbText.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbText.setForeground(Color.RED);
        
        lbText.setBounds(200, 100, (int)lbText.getPreferredSize().getWidth(), (int)lbText.getPreferredSize().getHeight());
        conn.add(lbText, BorderLayout.SOUTH);
    }

}
