/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 *
 * @author qphan
 */
public class Ex01FlowLayoutManually extends JFrame {

    private final Container container = getContentPane();
    private final FlowLayout flowLayout = new FlowLayout();
    private JRadioButton rdLTR;
    private JRadioButton rdRTL;
    private ButtonGroup orientationGroup;
    private JButton btSubmit;
    private JPanel pnButtons;

    private final int NUMBER_OF_BUTTONS = 5;

    public Ex01FlowLayoutManually(String title) {
        super(title);

        initComponents();
        initEvents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);

        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(10);
        flowLayout.setVgap(20);
        container.setLayout(flowLayout);

        pnButtons = new JPanel();
        pnButtons.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.GREEN));
        pnButtons.setLayout(flowLayout);

        drawButtons();

        container.add(pnButtons);

        rdLTR = new JRadioButton();
        rdLTR.setFocusPainted(false);
        rdLTR.setSelected(true);
        rdLTR.setText("Left To Right");
        rdLTR.setFont(new Font("Tahoma", Font.PLAIN, 18));
        container.add(rdLTR);

        rdRTL = new JRadioButton();
        rdRTL.setFocusPainted(false);
        rdRTL.setText("Right To Left");
        rdRTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
        container.add(rdRTL);

        btSubmit = new JButton();
        btSubmit.setFocusPainted(false);
        btSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btSubmit.setText("Submit");
        container.add(btSubmit);

        orientationGroup = new ButtonGroup();
        orientationGroup.add(rdLTR);
        orientationGroup.add(rdRTL);
    }

    private void initEvents() {
        btSubmitEvents();
    }

    private void btSubmitEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnButtons.applyComponentOrientation(
                        rdLTR.isSelected() ? ComponentOrientation.LEFT_TO_RIGHT
                        : ComponentOrientation.RIGHT_TO_LEFT
                );
                revalidate();
                // validate();
            }
        });
    }

    private void drawButtons() {
        for (int i = 1; i <= NUMBER_OF_BUTTONS; i++) {
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setText((i == 4 ? "Long-Named Button" : "Button") + i);
            button.setFont(new Font("Tahoma", Font.PLAIN, 18));
            pnButtons.add(button);
        }
    }

    public static void main(String[] args) {
        Ex01FlowLayoutManually eflm = new Ex01FlowLayoutManually("FlowLayout !!!");
        eflm.setVisible(true);
    }

}
