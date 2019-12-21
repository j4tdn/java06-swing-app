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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author Admin
 */
public class Ex03 extends JFrame {

    private static final Random rd = new Random();
    private static final String TEXT_CONVERTION_APP_TETILE = "Thread Demo";
    private static final int TEXT_CONVERTION_APP_WIDTH = 580;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 320;
    private final Container conn = getContentPane();

    private JLabel lbTitle;
    private JButton btStop;

    public Ex03() {
        initComponents();
        initEvent();
    }

    public static void main(String[] args) {
        Ex03 convertionApp = new Ex03();
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
        final int INITTIAL_HEADER_X_PADDING = 180;
        final int INITTIAL_HEADER_Y_PADDING = 40;

//============================================================================//
        lbTitle = new JLabel();
        lbTitle.setText("Random");
        lbTitle.setPreferredSize(new Dimension(500, 20));
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                getPreWidth(lbTitle),
                getPreHeight(lbTitle));
        conn.add(lbTitle);

        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setSize(100, 20);
        btStop.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btStop.setText("STOP");
        btStop.setBounds(INITTIAL_HEADER_X_PADDING + 50,
                INITTIAL_HEADER_Y_PADDING + VERTICAL_PADDING
                + (getPreHeight(btStop)),
                getWidth(btStop),
                30);
        conn.add(btStop);
    }
//============================================================================//

    private void initEvent() {
        events();
        btSubmitEvents();

    }

    private void events() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundJLabel();
            }
        });
        timer.start();
    }

    private void btSubmitEvents() {
        Font btSubmitFont = btStop.getFont();
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btStop.setEnabled(false);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex03.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font highlight = new Font(btSubmitFont.getFontName(),
                        Font.BOLD, btSubmitFont.getSize());
                btStop.setFont(highlight);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btStop.setFont(btSubmitFont);
            }

        });
    }

    private void changeBackgroundJLabel() {
        List<String> list = new ArrayList<>(Arrays.asList("Random : RED",
                "Random : GREEN", "Random : BLUE", "Random : YELLOW",
                "Random : PINK", "Random : BLACK", "Random : WHITE"));

        int reuslt = rd.nextInt(list.size());

        if (reuslt == 0) {
            lbTitle.setText(list.get(0));
            conn.setBackground(Color.RED);
        }
        if (reuslt == 1) {
            lbTitle.setText(list.get(1));
            conn.setBackground(Color.GREEN);
        }
        if (reuslt == 2) {
            lbTitle.setText(list.get(2));
            conn.setBackground(Color.BLUE);
        }
        if (reuslt == 3) {
            lbTitle.setText(list.get(3));
            conn.setBackground(Color.YELLOW);
        }
        if (reuslt == 4) {
            lbTitle.setText(list.get(4));
            conn.setBackground(Color.PINK);
        }
        if (reuslt == 5) {
            lbTitle.setText(list.get(5));
            conn.setBackground(Color.BLACK);
        }
        if (reuslt == 6) {
            lbTitle.setText(list.get(6));
            conn.setBackground(Color.WHITE);
        }
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
