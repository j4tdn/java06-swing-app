/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author USER
 */
public class LoginSuccess extends JFrame {

    private final Container container = getContentPane();
    private final GridLayout gridLayout = new GridLayout();
    
    public LoginSuccess() {
        initComponents();
    }
    
    public static void main(String[] args) {
        LoginSuccess ex03 = new LoginSuccess();
        ex03.setVisible(true);
    }

    private void initComponents() {
        setSize(900, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        container.setLayout(gridLayout);
        
        gridLayout.setRows(4);
        //gridLayout.setColumns(0);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        
        drawRooms(19);
    }
    
    private void drawRooms(int numberOfRoom) {
        for(int i = 1; i <= numberOfRoom;i++) {
            JButton btRoom = new JButton();
            btRoom.setText("Phòng " + (100 + i));
            container.add(btRoom);
        }
    }
}
