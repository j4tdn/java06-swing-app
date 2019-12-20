/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
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
import utils.ImageUtils;

/**
 *
 * @author VO DINH DUNG
 */
public class Bai1 extends JFrame {

    private static final String TRUNCATE_NUMBER_APP_ICON = "E:\\Java\\lesson18\\64px_flower.png";
    private static final String TRUNCATE_NUMBER_APP_TITLE = "Truncate number app";
    private static final int TRUNCATE_NUMBER_APP_WIDTH = 540;
    private static final int TRUNCATE_NUMBER_APP_HEIGHT = 480;

    private final Container conn = getContentPane();
    private JLabel lbTitle;
    private JLabel request;
    private JLabel result;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JButton btImplement;

    public Bai1() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Bai1 truncateNumberApp = new Bai1();
        truncateNumberApp.setVisible(true);
    }

    private void initComponents() {
        // DEFAULT
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TRUNCATE_NUMBER_APP_TITLE);
        setIconImage(ImageUtils.load(TRUNCATE_NUMBER_APP_ICON));
        setSize(TRUNCATE_NUMBER_APP_WIDTH, TRUNCATE_NUMBER_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        conn.setBackground(Color.GREEN);
        conn.setLayout(null);

        // TITLE
        final int VERTICAL_PADDING = 40;
        final int INITIAL_HEADER_X_PADDING = 110;
        final int INITIAL_HEADER_Y_PADDING = 40;

        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE_NUMBER");
        // chỉnh màu cho chữ ===> (green) 
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(INITIAL_HEADER_X_PADDING, INITIAL_HEADER_Y_PADDING, getPreWidth(lbTitle), getPreHeight(lbTitle));
        conn.add(lbTitle);

        // REQUEST
        final int INITIAL_REQUEST_X_PADDING = 20;
        final int INITIAL_REQUEST_Y_PADDING = 100;
        request = new JLabel();
        request.setText("Nhập dãy chữ số : ");
        request.setFont(new Font("Tahoma", Font.PLAIN, 15));
        request.setBounds(INITIAL_REQUEST_X_PADDING, INITIAL_REQUEST_Y_PADDING, getPreWidth(request), getPreHeight(request));
        conn.add(request);

        // RESULT
        final int INITIAL_RESULT_X_PADDING = 30;
        final int INITIAL_RESULT_Y_PADDING = 200;
        result = new JLabel();
        result.setText("Kết quả : ");
        result.setFont(new Font("Tahoma", Font.PLAIN, 15));
        result.setBounds(INITIAL_RESULT_X_PADDING, INITIAL_RESULT_Y_PADDING, getPreWidth(result), getPreHeight(result));
        conn.add(result);

        // tfInput : Chưa ổn
        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfInput.setBounds(INITIAL_HEADER_X_PADDING + 50,
                INITIAL_HEADER_Y_PADDING + VERTICAL_PADDING + 10,
                getWidth(lbTitle),
                36);
        conn.add(tfInput);

        // buttion implement
        btImplement = new JButton();
        btImplement.setFocusPainted(false);
        btImplement.setText("Thực hiện");
        btImplement.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btImplement.setBounds(INITIAL_HEADER_X_PADDING + 80,
                INITIAL_HEADER_Y_PADDING + VERTICAL_PADDING * 6,
                getPreWidth(lbTitle) / 2,
                36);
        conn.add(btImplement);

        // tfOutput
        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfOutput.setBounds(INITIAL_RESULT_X_PADDING + getWidth(result),
                INITIAL_HEADER_Y_PADDING + VERTICAL_PADDING + getWidth(request) - 20, getWidth(lbTitle), 36);
        conn.add(tfOutput);

    }

    private void initEvents() {
        btImplementEvents();
        tfOutputEvents();
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

    private void tfOutputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfInput.setText(convertNumber(tfInput.getText()));
                }
            }
        });
    }

    private String convertNumber(String input) {
        String[] arr = input.split("\\,");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (isUnique(arr, arr[i])) {
                result += arr[i]+" ";
            }
        }
        return result;
    }

    private static boolean isUnique(String[] arr, String s) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.equals(arr[i])) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void btImplementEvents() {
        Font btImplementFont = btImplement.getFont();
        btImplement.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfOutput.setText(convertNumber(tfInput.getText()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font hightlightFont = new Font(btImplementFont.getName(), Font.BOLD, btImplementFont.getSize());
                btImplement.setFont(hightlightFont);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btImplement.setFont(btImplementFont);
            }
        });
    }

}
