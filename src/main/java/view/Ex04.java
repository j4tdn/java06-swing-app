/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author qphan
 */
public class Ex04 extends JFrame {

    private static final String TEXT_CONVERTION_APP_ICON = "C:\\Users\\qphan\\Pictures\\lesson18_images\\64px_flower.png";
    private static final String TEXT_CONVERTION_APP_TITLE = "Text convert - app";
    private static final int TEXT_CONVERTION_APP_WIDTH = 540;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 320;

    private final Container conn = getContentPane();

    private JLabel lbTitle;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JButton btSubmit;

    public Ex04() {
        initComponents();
        initEvents();

    }

    public static void main(String[] args) {
        Ex04 convertionApp = new Ex04();
        convertionApp.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TEXT_CONVERTION_APP_TITLE);
        setIconImage(ImageUtils.load(TEXT_CONVERTION_APP_ICON));
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        conn.setBackground(Color.GREEN);
        conn.setLayout(null);

        final int VERITICAL_PADDING = 40;
        final int INITTIAL_HEADER_X_PADDING = 110;
        final int INITTIAL_HEADER_Y_PADDING = 40;

        lbTitle = new JLabel();
        lbTitle.setText("How to convert text - App");
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING,
                getPreWidth(lbTitle),
                getPreHeight(lbTitle));
        conn.add(lbTitle);

        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfInput.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING + VERITICAL_PADDING + getPreHeight(lbTitle),
                getPreWidth(lbTitle),
                36);
        conn.add(tfInput);

        btSubmit = new JButton();
        btSubmit.setFocusPainted(false);
        btSubmit.setText("Submit");
        btSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btSubmit.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getPreWidth(lbTitle) / 2 - 10,
                36);
        conn.add(btSubmit);

        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        // Khoảng cách từ btSubmit đến tfOutput theo chiều ngang
        tfOutput.setBounds(INITTIAL_HEADER_X_PADDING + getWidth(btSubmit) + 20,
                INITTIAL_HEADER_Y_PADDING + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getWidth(btSubmit),
                36);
        conn.add(tfOutput);

    }

    private void initEvents() {
        btSubmitEvents();
        tfOutputEvents();
    }

    private void btSubmitEvents() {
        Font btSubmitFont = btSubmit.getFont();
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfOutput.setText(convertText(tfInput.getText()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlightFont = new Font(btSubmitFont.getFontName(), Font.BOLD, btSubmitFont.getSize());
                btSubmit.setFont(highlightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btSubmit.setFont(btSubmitFont);
            }
        });
    }

    private void tfOutputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfOutput.setText(convertText(tfInput.getText()));
                }
            }
        });
    }

    private String convertText(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern.compile("\\s").splitAsStream(input.trim())
                .forEach(s -> sb.append(s.charAt(0)));
        return sb.toString();
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
