/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author qphan
 */
public class PnHomepage extends JPanel{
    
    private JLabel lbTitle;

    public PnHomepage() {
        initComponents();
    }
    
    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("<html><b style='color:red; font-size: 18px'>THIS IS HOME PAGE</b></html>");
        add(lbTitle);
    }
}
