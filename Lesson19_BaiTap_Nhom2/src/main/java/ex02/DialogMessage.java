/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;

import javax.swing.JDialog;
/**
 *
 * @author USER
 */
public class DialogMessage extends JDialog {
    
    public DialogMessage() {
        initComponents();
    }
    public static void main(String[] args) {
        DialogMessage dialogMessage = new DialogMessage();
        dialogMessage.setVisible(true);
    }
    private void initComponents() {
        setLocationRelativeTo(null);
        setSize(200, 50);
    }
    
}
