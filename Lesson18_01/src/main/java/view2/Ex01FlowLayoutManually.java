/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Admin
 */
public class Ex01FlowLayoutManually extends JFrame{
        private final int Number_In_Button = 5;
        private Container con = getContentPane();
        private FlowLayout flow = new FlowLayout();
        private JRadioButton rdLTR ;
        private JRadioButton rdRTL ;
        private JButton btSubmit ;
        private ButtonGroup btGroup ;
        private JPanel pnButton;
    public Ex01FlowLayoutManually() throws HeadlessException {
        initComponent();
        initEvent();
    }
    private void drawButton(){
        pnButton = new JPanel();
        pnButton.setLayout(flow);
        pnButton.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.GREEN));
        con.add(pnButton);
        for(int i =0;i<Number_In_Button;i++){
            JButton button = new JButton();
            button.setText(i == 3 ? ("Long-Named Button") : ("Button") +i);
            button.setFocusPainted(false);
            button.setFont(new Font("Tahoma", Font.BOLD,18));
            pnButton.add(button);
        }
    }

    private void initComponent() {
        
        //flow.setAlignment(flow.right);
        btSubmit = new JButton("Submimt");
        btSubmit.setFocusPainted(false);
        btSubmit.setFont(new Font("Tahoma", Font.BOLD,18));
        
        
        btGroup = new ButtonGroup();
        rdLTR = new JRadioButton("Left To Right");
        rdLTR.setSelected(true);
        rdLTR.setFont(new Font("Tahoma", Font.BOLD,18));
        rdLTR.setFocusPainted(false);
        rdRTL = new JRadioButton("Right To Left");
        rdRTL.setFont(new Font("Tahoma", Font.BOLD,18));
        rdRTL.setFocusPainted(false);
        flow.setHgap(10);
        flow.setVgap(10);
        con.setLayout(flow);
        //con.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        drawButton();
        btGroup.add(rdLTR);
        btGroup.add(rdRTL);
        con.add(rdLTR);
        con.add(rdRTL);
        con.add(btSubmit);
        setSize(750,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ex01");
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Ex01FlowLayoutManually().setVisible(true);
    }

    private void initEvent() {
        btSubmitEvent();
    }

    private void btSubmitEvent() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnButton.applyComponentOrientation(rdLTR.isSelected() ? ComponentOrientation.LEFT_TO_RIGHT : ComponentOrientation.RIGHT_TO_LEFT);
                validate();
            }
            
        });
        
    }
}
