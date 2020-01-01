/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Admin
 */
public class Ex02 extends JFrame{
        
        private Container con = getContentPane();
        private BorderLayout border = new BorderLayout();
        private JPanel pnTop,pnLeft,pnCenter,pnLeft_Center,pnLeft_Botton;
        private JSplitPane splitPane = new JSplitPane();
        private JSplitPane jSplitPane_Left = new JSplitPane();

    public Ex02() throws HeadlessException {
        initComponent();
    
    }
  

    private void initComponent() {
        
        con.setLayout(border);
        
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.CYAN);
        con.add(pnTop,BorderLayout.NORTH);
        
        
        splitPane.add(jSplitPane_Left,JSplitPane.LEFT);
        splitPane.setOneTouchExpandable(true);
        
        
        pnLeft_Botton = new JPanel();
        pnLeft_Botton.setPreferredSize(new Dimension(60, 70));
        pnLeft_Botton.setBackground(Color.MAGENTA);
       
        jSplitPane_Left.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane_Left.add(pnLeft_Botton,JSplitPane.BOTTOM);
        
        pnLeft_Center = new JPanel();
        pnLeft_Center.setPreferredSize(new Dimension(0, 50));
        pnLeft_Center.setBackground(Color.PINK);
        jSplitPane_Left.add(pnLeft_Center,JSplitPane.TOP);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.YELLOW);
        splitPane.add(pnCenter,JSplitPane.RIGHT);
        con.add(splitPane,BorderLayout.CENTER);
        
        
        
        
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ex01");
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Ex02().setVisible(true);
    }
}
