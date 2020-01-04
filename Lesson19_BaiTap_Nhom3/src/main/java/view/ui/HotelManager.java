/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ui;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Admin
 */
public class HotelManager extends JFrame {
    
    private Container container = getContentPane();
    private GridLayout gridLayout = new GridLayout();
    
    public HotelManager() {
        initComponents();
    }
    
    private void initComponents() {
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Manager");
        gridLayout.setColumns(4);
        gridLayout.setRows(5);
        gridLayout.setHgap(5);
        gridLayout.setVgap(10);
        
        container.setLayout(gridLayout);
        drawRoom(16);
        
    }
    
    private void drawRoom(int numberOfRooms) {
        for (int i = 0; i <= numberOfRooms; i++) {
            JButton btRoom = new JButton();
            btRoom.setText("Phòng " + (100 + i));
            container.add(btRoom);
        }
    }
}
