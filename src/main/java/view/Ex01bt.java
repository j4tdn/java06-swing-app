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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author Xuan Loc
 */
public class Ex05bt extends JFrame {

    private static final String TRUNCATE_APP_ICON = "C:\\Users\\Xuan Loc\\Downloads\\64px_flower.png";
    private static final String TRUNCATE_APP_TITLE = "TRUNCATE-NUMBER";
    private static final int TRUNCATE_APP_WIDTH = 540;
    private static final int TRUNCATE_APP_HEIGHT = 320;

    private final Container conn = getContentPane();

    private JLabel lbTitle;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JLabel lbInputDigital;
    private JLabel lbResult;
    private JButton btPerform;

    public Ex05bt() {
        initComponents();
    }

    public static void main(String[] args) {
        Ex05bt todoApp = new Ex05bt();
        todoApp.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TRUNCATE_APP_TITLE);
        setIconImage(ImageUtils.load(TRUNCATE_APP_ICON));
        setSize(TRUNCATE_APP_WIDTH, TRUNCATE_APP_HEIGHT);
        setLocationRelativeTo(null);
        //setTitle(TRUNCATE_APP_TITLE);
        setResizable(false);

        conn.setBackground(Color.GREEN);
        conn.setLayout(null);

        final int VERITICAL_PADDING = 10;
        final int INITTIAL_HEADER_X_PADDING = 110;
        final int INITTIAL_HEADER_Y_PADDING = 40;

        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE - NUMBER");
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING,
                getPreWidth(lbTitle),
                getPreHeight(lbTitle));
        conn.add(lbTitle);

        lbInputDigital = new JLabel();

        lbInputDigital.setText("Nhap day so");
        lbInputDigital.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbInputDigital.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING - 30 + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getPreWidth(lbTitle) / 2 - 10,
                36);
        conn.add(lbInputDigital);
        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfInput.setBounds(INITTIAL_HEADER_X_PADDING + getWidth(lbInputDigital) + 20,
                INITTIAL_HEADER_Y_PADDING - 30 + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getWidth(lbInputDigital) + 130,
                36);
        conn.add(tfInput);

        lbResult = new JLabel();
        lbResult.setText("ket qua");
        lbResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbResult.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING + 20 + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getPreWidth(lbTitle) / 2 - 10,
                36);
        conn.add(lbResult);

        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        // Khoảng cách từ btSubmit đến tfOutput theo chiều ngang
        tfOutput.setBounds(INITTIAL_HEADER_X_PADDING + getWidth(lbResult) + 20,
                INITTIAL_HEADER_Y_PADDING + 20 + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getWidth(lbResult),
                36);
        conn.add(tfOutput);

        btPerform = new JButton();
        btPerform.setFocusPainted(false);
        btPerform.setText("Thuc Hien");
        btPerform.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btPerform.setBounds(INITTIAL_HEADER_X_PADDING + 270,
                INITTIAL_HEADER_Y_PADDING + 20 + VERITICAL_PADDING * 2 + getPreHeight(lbTitle) * 2,
                getPreWidth(lbTitle) / 2 - 10,
                36);
        conn.add(btPerform);

    }

    private void initEvents() {
        tfOutputEvents();
        btTruncateEvents();
    }

    private void btTruncateEvents() {
        Font btTruncateFont = btPerform.getFont();
        btPerform.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfOutput.setText(convertDigital(tfInput.getText()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlightFont = new Font(btTruncateFont.getName(), Font.BOLD, btTruncateFont.getSize());
                btPerform.setFont(highlightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btPerform.setFont(btTruncateFont);
            }
        });
    }

    private void tfOutputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfOutput.setText(convertDigital(tfInput.getText()));
                }
            }
        });
    }

    private void tfInputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = tfInput.getText();
                }
            }
        });
    }

    private String convertDigital(String ip) {
        String[] arr = ip.split(",");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (unique(arr, arr[i])) {
                result = result + arr[i] + "";
            }
        }
        return result;
    }

    private static boolean unique(String[] arr, String st) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (st.equals(arr[i])) {
                count++;
                if (count == 1) {
                    return false;
                }
            }
        }
        return true;
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

    private int getHeight(Component comp) {
        return (int) comp.getSize().getHeight();
    }

}
