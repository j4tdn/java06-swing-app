/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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

/**
 *
 * @author Admin
 */
public class Ex01 extends JFrame {

    private static final String TEXT_CONVERTION_APP_TETILE = "Ex01_Truncate";
    private static final int TEXT_CONVERTION_APP_WIDTH = 580;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 320;
    private final Container conn = getContentPane();

    private JLabel lbTitle;
    private JLabel lbNumberSequence;
    private JLabel lbResult;
    private JTextField tfInput;
    private JTextField tfOutput;
    private JButton btSubmit;

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
        setTitle(TEXT_CONVERTION_APP_TETILE);
        setSize(TEXT_CONVERTION_APP_WIDTH, TEXT_CONVERTION_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(Boolean.FALSE);

        conn.setLayout(null);

        final int VERTICAL_PADDING = 40;
        final int INITTIAL_HEADER_X_PADDING = 150;
        final int INITTIAL_HEADER_Y_PADDING = 40;

//============================================================================//
        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE - NUMBER");
        lbTitle.setForeground(Color.GREEN);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                getPreWidth(lbTitle),
                getPreHeight(lbTitle));
        conn.add(lbTitle);

//============================================================================//
        lbNumberSequence = new JLabel();
        lbNumberSequence.setText("Nhập dãy số:");
        lbNumberSequence.setPreferredSize(new Dimension(80, 20));
        lbNumberSequence.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbNumberSequence.setBounds(INITTIAL_HEADER_X_PADDING,
                INITTIAL_HEADER_Y_PADDING
                + VERTICAL_PADDING
                + getPreHeight(lbNumberSequence),
                getPreWidth(lbNumberSequence),
                36);
        conn.add(lbNumberSequence);

        tfInput = new JTextField();
        tfInput.setColumns(20);
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfInput.setBounds(INITTIAL_HEADER_X_PADDING
                + getWidth(lbNumberSequence) + 20,
                INITTIAL_HEADER_Y_PADDING + VERTICAL_PADDING
                + (getPreHeight(lbNumberSequence)),
                getWidth(lbNumberSequence) + 130,
                30);
        conn.add(tfInput);

//============================================================================//  
        lbResult = new JLabel();
        lbResult.setText("Kết quả:");
        lbResult.setPreferredSize(new Dimension(200, 20));
        lbResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbResult.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING
                + VERTICAL_PADDING * 2
                + getPreHeight(lbResult) * 2,
                getPreWidth(lbResult) / 2 - 10,
                36);
        conn.add(lbResult);

//============================================================================//
        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        tfOutput.setPreferredSize(new Dimension(500, 20));
        tfOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfOutput.setBounds(INITTIAL_HEADER_X_PADDING + 10
                + getWidth(lbResult),
                INITTIAL_HEADER_Y_PADDING + VERTICAL_PADDING * 2
                + (getPreHeight(tfOutput) * 2),
                getWidth(lbResult),
                30);
        conn.add(tfOutput);

        btSubmit = new JButton();
        btSubmit.setFocusPainted(false);
        btSubmit.setSize(100, 20);
        btSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btSubmit.setText("Thực hiện");
        btSubmit.setBounds(INITTIAL_HEADER_X_PADDING + 10
                + getWidth(btSubmit) + 100,
                INITTIAL_HEADER_Y_PADDING + VERTICAL_PADDING * 2
                + (getPreHeight(tfOutput) * 2),
                getWidth(btSubmit),
                30);
        conn.add(btSubmit);
    }
//============================================================================//

    private void initEvent() {
        btSubmitEvents();
        tfOutputEvents();
    }

    private void btSubmitEvents() {
        Font btSubmitFont = btSubmit.getFont();
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfOutput.setText(nonDuplicateValues(tfInput.getText()));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlight = new Font(btSubmitFont.getFontName(), Font.BOLD, btSubmitFont.getSize());
                btSubmit.setFont(highlight);
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
                if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    tfOutput.setText(nonDuplicateValues(tfInput.getText()));
                }
            }

        });
    }

    private String nonDuplicateValues(String input) {
        String result = "";
        String[] strArray = input.split(",");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        int count = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (!checksForAnExistingElementInTheArray(i, intArray)) {
                count += 2;
                result += intArray[i] + ",";
            }
        }

        return result.substring(0, count - 1);
    }

    private static boolean checksForAnExistingElementInTheArray(int index, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != index && array[i] == array[index]) {
                return true;
            }
        }
        return false;
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
