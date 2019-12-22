/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class Ex01 extends JFrame {

    private static final String TEXT_CONVERTION_APP_TITILE = "Ex01_Truncate";
    private static final int TEXT_CONVERTION_APP_WIDTH = 560;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 320;
    private final Container conn = getContentPane();

    private JLabel lbTitle;
    private JLabel lbInput;
    private JLabel lbOutput;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JButton btPerform;

    public Ex01() {
        initComponents();
        initEvent();
    }

    public static void main(String[] args) {
        Ex01 convertionApp = new Ex01();
        convertionApp.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TEXT_CONVERTION_APP_TITILE);
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        conn.setLayout(null);
        final int VERTICAL_PADDING = 40;
        final int INITTIAL_HEADER_X_PADDING = 130;
        final int INITTIAL_HEADER_Y_PADDING = 40;

        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE - NUMBER");
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                getPreWidth(lbTitle),
                getPreHeight(lbTitle));
        conn.add(lbTitle);

        lbInput = new JLabel();
        lbInput.setText("Nhập dãy số : ");
        lbInput.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbInput.setBounds(INITTIAL_HEADER_X_PADDING / 2, INITTIAL_HEADER_Y_PADDING
                + VERTICAL_PADDING
                + getPreHeight(lbTitle),
                getPreWidth(lbTitle) / 2 - 10,
                36);
        conn.add(lbInput);

        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfInput.setBounds(INITTIAL_HEADER_X_PADDING * 3 / 2, INITTIAL_HEADER_Y_PADDING
                + VERTICAL_PADDING
                + getPreHeight(lbTitle),
                getPreWidth(lbTitle),
                36);
        conn.add(tfInput);

        lbOutput = new JLabel();
        lbOutput.setText("Kết quả : ");
        lbOutput.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbOutput.setBounds(INITTIAL_HEADER_X_PADDING / 2, INITTIAL_HEADER_Y_PADDING
                + VERTICAL_PADDING * 2
                + getPreHeight(lbTitle) * 2,
                getPreWidth(lbTitle) / 2,
                36);
        conn.add(lbOutput);

        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfOutput.setBounds(INITTIAL_HEADER_X_PADDING + 20,
                INITTIAL_HEADER_Y_PADDING + VERTICAL_PADDING * 2
                + (getPreHeight(lbTitle) * 2),
                getWidth(lbOutput) * 4 / 3,
                36);
        conn.add(tfOutput);

        btPerform = new JButton();
        btPerform.setFocusPainted(false);
        btPerform.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btPerform.setText("Thực hiện");
        btPerform.setBounds(INITTIAL_HEADER_X_PADDING
                + getWidth(tfOutput) + 30,
                INITTIAL_HEADER_Y_PADDING + VERTICAL_PADDING * 2
                + (getPreHeight(lbTitle) * 2),
                getWidth(tfOutput) * 2 / 3,
                36);
        conn.add(btPerform);

    }

    private void initEvent() {
        tfOutputEvent();
        btSubmitEvent();
    }

    private void btSubmitEvent() {
        String input = tfInput.getText();
        btPerform.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfOutput.setText(truncateNumber(tfInput.getText()));
            }
        });
    }

    private void tfOutputEvent() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfOutput.setText(truncateNumber(tfInput.getText()));
                }
            }

        });
    }

    private String truncateNumber(String input) {

        int[] out = convertsNumber(input);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < out.length; i++) {
            int number = out[i];
            if (isOnly(out, number)) {
                arr.add(number);
            }
        }
        String result = arr.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(","));
        return result;
    }

    private static int[] convertsNumber(String input) {

        String[] parts = input.split(",");
        int[] ints = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            ints[i] = Integer.parseInt(parts[i]);
        }
        return ints;
    }

    private static boolean isOnly(int[] input, int number) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (number == input[i]) {
                count++;
            }
        }
        return count == 1;
    }

    private int getPreWidth(Component comp) {
        return (int) comp.getPreferredSize().getWidth();
    }

    private int getPreHeight(Component comp) {
        return (int) comp.getPreferredSize().getHeight();
    }

    private int getWidth(Component comp) {
        return (int) comp.getSize().getWidth();
    }

}
