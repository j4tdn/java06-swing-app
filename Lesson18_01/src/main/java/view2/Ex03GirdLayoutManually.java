/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Ex03GirdLayoutManually extends JFrame{
    private final GridLayout gridLayout = new GridLayout();
    private final Container conn  = getContentPane();

    public Ex03GirdLayoutManually(String title) throws HeadlessException {
        super(title);
        initComponent();
    }

    private void initComponent() {
        conn.setLayout(gridLayout);
        
        //gridLayout.setRows(4);
        gridLayout.setColumns(10);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        
        drawRoom(20);
        
        
        
        
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    

    private void drawRoom(int roomCount) {
        for (int i = 1; i <= roomCount; i++) {
            JButton btRoom = new JButton();
            btRoom.setText("Room "+ i);
            conn.add(btRoom);
        }
    }
    
    
    public static void main(String[] args) {
        new Ex03GirdLayoutManually("Ex03").setVisible(true);
    }
}
