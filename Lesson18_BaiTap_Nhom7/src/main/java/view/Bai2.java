/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import Bai2.Convert;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class Bai2 extends JFrame {

    private static final int TEXT_CONVERTION_APP_WIDTH = 500;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 700;
    private final Container container = getContentPane();

    private JLabel lbInput, lbDo, lbView;
    private JTextField tfInput;
    private JTextArea taView;
    private JComboBox cbDo;
    private JButton btView, btReset, btExit;

    private String[] combo = {"Đếm từ", "Đếm từ trùng lặp", "Chuyển sang tiếng Việt không dấu"};

    public Bai2() {
        initComponent();
        initEvent();
    }

    public static void main(String[] args) {
        Bai2 bai2 = new Bai2();
        bai2.setVisible(true);
    }

    private void initComponent() {
        setDefaultCloseOperation(3);
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        container.setBackground(Color.PINK);
        container.setLayout(null);

        lbInput = new JLabel();
        lbInput.setText("Nhập chuối: ");
        lbInput.setBounds(50, 50, (int) lbInput.getPreferredSize().getWidth(), 50);
        container.add(lbInput);

        tfInput = new JTextField();
        tfInput.setColumns(50);
        tfInput.setBounds(150, 50, 300, 40);
        container.add(tfInput);

        lbDo = new JLabel();
        lbDo.setText("Thực hiện : ");
        lbDo.setBounds(50, 150, (int) lbDo.getPreferredSize().getWidth(), 50);
        container.add(lbDo);

        cbDo = new JComboBox(combo);
        cbDo.setSelectedIndex(0);
        cbDo.setBounds(150, 150, (int) cbDo.getPreferredSize().getWidth(), 40);
        container.add(cbDo);

        lbView = new JLabel();
        lbView.setText("Kết quả  : ");
        lbView.setBounds(50, 250, (int) lbView.getPreferredSize().getWidth(), 50);
        container.add(lbView);

        taView = new JTextArea();
        taView.setBounds(150, 250, 300, 300);
        container.add(taView);

        btView = new JButton();
        btView.setText("View");
        btView.setBorderPainted(false);
        btView.setBounds(30, 600, 100, 50);
        container.add(btView);

        btReset = new JButton();
        btReset.setText("Reset");
        btReset.setBorderPainted(false);
        btReset.setBounds(160, 600, 100, 50);
        container.add(btReset);

        btExit = new JButton();
        btExit.setText("Exit");
        btExit.setBorderPainted(false);
        btExit.setBounds(290, 600, 100, 50);
        container.add(btExit);
    }

    private void initEvent() {
        btSubmitEvent();
        btResetEvent();
        btExitEvent();
    }

    private void btSubmitEvent() {
        btView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String input = tfInput.getText();
                switch (cbDo.getSelectedIndex()) {
                    case 0: {
                        String output = Convert.countWord(input);
                        taView.setText(output);
                        break;
                    }
                    case 1: {
                        String output = Convert.countDuplicateWord(input);
                        taView.setText(output);
                        break;
                    }
                    case 2: {
                        String output = Convert.convertString(input);
                        taView.setText(output);
                        break;
                    }
                }
            }
        });
    }
    
    private void btResetEvent(){
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               tfInput.setText("");
               taView.setText("");
               cbDo.setSelectedIndex(0);
            }
        });
    }
    
    private void btExitEvent(){
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               System.exit(0);
            }
        });
    }
}
