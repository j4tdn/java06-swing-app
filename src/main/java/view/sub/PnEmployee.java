/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author qphan
 */
public class PnEmployee extends JPanel{
    
    private JLabel lbTitle;

    public PnEmployee() {
        initComponents();
    }
    
    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("<html><b style='color: red; font-size: 18px'>THIS IS EMPLOYEE PAGE</b></html>");
        add(lbTitle);
    }
}
