/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author qphan
 */
public class Ex02 extends JFrame {

    private static final int HELLO_APP_WIDTH = 800;
    private static final int HELLO_APP_HEIGHT = 400;
    private static final String HELLO_APP_TITLE = "Ex02 - Todo app";

    public Ex02() {
        initComponents();
    }

    public static void main(String[] args) {
        Ex02 todoApp = new Ex02();
        todoApp.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(HELLO_APP_WIDTH, HELLO_APP_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(HELLO_APP_TITLE);
        
        System.out.println(getClass().getClassLoader().getResourceAsStream(""));
        
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\qphan\\Pictures\\lesson18_images\\64px_flower.png");
        setIconImage(imageIcon.getImage());
    }

}
