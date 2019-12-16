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
public class Ex01 {

    private static final int HELLO_APP_WIDTH = 800;
    private static final int HELLO_APP_HEIGHT = 400;
    private static final String HELLO_APP_TITLE = "Ex01 - Hello app";
    

    public Ex01() {
        initComponents();
    }

    public static void main(String[] args) {
        new Ex01();
    }

    private void initComponents() {
        JFrame helloApp = new JFrame();
        helloApp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        helloApp.setSize(HELLO_APP_WIDTH, HELLO_APP_HEIGHT);

        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // helloApp.setLocation((int) screenSize.getWidth() / 2 - HELLO_APP_WIDTH / 2, (int) screenSize.getHeight() / 2 - HELLO_APP_HEIGHT / 2);

        // center screen
        helloApp.setLocationRelativeTo(null);
        
        helloApp.setTitle(HELLO_APP_TITLE);
        
        
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\qphan\\Pictures\\lesson18_images\\64px_flower.png");
        helloApp.setIconImage(imageIcon.getImage());
        
        helloApp.setVisible(true);
    }
}
