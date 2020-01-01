/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import view2.sub.pnEmoloyee;
import view2.sub.pnHomePage;

/**
 *
 * @author Admin
 */
public class Ex04CardLayoutManually extends JFrame{
        
        private Container con = getContentPane();
        private BorderLayout border = new BorderLayout();
        private JPanel pnTop,pnCenter,pnLeft_Center,pnLeft_Botton;
        private JSplitPane splitPane = new JSplitPane();
        private GridLayout gridLayout = new GridLayout(5, 0, 5, 5);
        private JSplitPane jSplitPane_Left = new JSplitPane();
        private JButton btHomePage;
        private JButton btEmployee;
        private pnHomePage homePage ;
        private pnEmoloyee emoloyee;
        private CardLayout cardLayout = new CardLayout();
        

    public Ex04CardLayoutManually() throws HeadlessException {
        initComponent();
        initEvent();
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
        pnLeft_Center.setLayout(gridLayout);
        pnLeft_Center.setPreferredSize(new Dimension(0, 50));
        pnLeft_Center.setBackground(Color.PINK);
        jSplitPane_Left.add(pnLeft_Center,JSplitPane.TOP);
        btHomePage = new JButton("Home Page");
        
        btEmployee = new JButton("Employee");
        pnLeft_Center.add(btHomePage);
        pnLeft_Center.add(btEmployee);
        
        
        pnCenter = new JPanel();
        pnCenter.setLayout(cardLayout);
        pnCenter.setBackground(Color.YELLOW);
        splitPane.add(pnCenter,JSplitPane.RIGHT);
        con.add(splitPane,BorderLayout.CENTER);
        
        homePage = new pnHomePage();
        emoloyee = new pnEmoloyee();
        
        
        pnCenter.add(homePage,btHomePage.getText());
        pnCenter.add(emoloyee,btEmployee.getText());
        
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ex01");
        setLocationRelativeTo(null);
    }
    
     private void initEvent() {
        pnLeftTopButtonEvent();
    }
     
     private void pnLeftTopButtonEvent() {
         Component[] components = pnLeft_Center.getComponents();
         for(Component component : components){
             if(component instanceof JButton){
                 final JButton bt = (JButton) component;
                 bt.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mousePressed(MouseEvent e) {
                         String key = bt.getText();
                         System.out.println(key);
                         cardLayout.show(pnCenter, key);
                     }
                     
                     
                 });
             }
             
         }
    }
     
    public static void main(String[] args) {
        new Ex04CardLayoutManually().setVisible(true);
    }

    


}
