/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import util.ImageUtils;
import util.SizeUtils;

/**
 *
 * @author Mr.Chien
 */
public class Ex01 extends JFrame {

    private static final String Ex01_Truncate_ICON = "E:\\64px_flower.png";
    private static final String Ex01_Truncate_TITLE = "Ex01_Truncate";
    private static final int Ex01_Truncate_APP_WIDTH = 480;
    private static final int Ex01_Truncate_APP_HEIGHT = 380;
    private static final int INITIAL_PADDING_X = 140;
    private static final int INITIAL_PADDING_Y = 50;
    private final Container conn = getContentPane();
    private JLabel labelHeader;
    private JLabel labelInput;
    private JLabel labelResult;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JButton btSubmit;

    public Ex01() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        ex01.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(Ex01_Truncate_TITLE);
        setIconImage(ImageUtils.load(Ex01_Truncate_ICON));
        setSize(Ex01_Truncate_APP_WIDTH, Ex01_Truncate_APP_HEIGHT);
        setLocationRelativeTo(null);
        conn.setBackground(Color.GRAY);
        conn.setLayout(null);

        labelHeader = new JLabel();
        labelHeader.setText("Ex01_Truncate");
        labelHeader.setFont(new Font("Tahoma", Font.PLAIN, 25));
        labelHeader.setBounds(INITIAL_PADDING_X, INITIAL_PADDING_Y, 
                SizeUtils.getPreWidth(labelHeader), SizeUtils.getPreHeight(labelHeader));
        labelHeader.setForeground(Color.GREEN);
        conn.add(labelHeader);

        labelInput = new JLabel();
        labelInput.setText("Nhập dãy số:");
        labelInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelInput.setBounds(INITIAL_PADDING_X, INITIAL_PADDING_Y, 
                SizeUtils.getPreWidth(labelInput), SizeUtils.getPreHeight(labelInput));
        conn.add(labelInput);

        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfInput.setColumns(1);
        tfInput.setBounds(INITIAL_PADDING_X,
                SizeUtils.getHeight(labelHeader) + 10,
                SizeUtils.getWidth(labelHeader),
                SizeUtils.getHeight(labelInput));
        conn.add(tfInput);

        labelResult = new JLabel();
        labelResult.setText("Kết quả:");
        labelResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelResult.setBounds(INITIAL_PADDING_X, INITIAL_PADDING_Y, SizeUtils.getPreWidth(labelResult),
                SizeUtils.getPreHeight(labelResult));
        conn.add(labelResult);

        tfOutput = new JTextField();
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfOutput.setColumns(1);
        tfOutput.setEditable(false);
        tfOutput.setBounds(INITIAL_PADDING_X,
                SizeUtils.getHeight(btSubmit) + 10,
                SizeUtils.getWidth(labelHeader),
                SizeUtils.getHeight(labelResult));
        conn.add(tfOutput);

        final int VERTICAL_PADDING = 80;
        btSubmit = new JButton();
        btSubmit.setText("Thực hiện:");
        btSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btSubmit.setBounds(INITIAL_PADDING_X + 80,
                INITIAL_PADDING_Y+ VERTICAL_PADDING * 6,
                SizeUtils.getPreWidth(labelHeader) / 2,
                36);
        btSubmit.setFocusPainted(false);
        conn.add(btSubmit);

    }

    private void initEvents() {
        setBtExecuteEvents();
        setTfInputEvents();
    }

    private void setBtExecuteEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String input = tfInput.getText();
                String output = distinctNumbers(input);
                tfOutput.setText(output);
            }
        });
    }

    private String distinctNumbers(String input) {
        StringBuilder output = new StringBuilder();
        try {
            Pattern.compile(",")
                    .splitAsStream(input)
                    .mapToInt(s -> Integer.parseInt(s.trim()))
                    .distinct()
                    .forEach(number -> output.append(number).append(","));
        } catch (NumberFormatException e) {
            return "Nhập lại";
        }

        String outputString = output.toString();
        return (outputString.substring(0, outputString.length() - 1));
    }

    private void setTfInputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = tfInput.getText();
                    String output = distinctNumbers(input);
                    tfOutput.setText(output);
                }
            }
        });
    }
}
