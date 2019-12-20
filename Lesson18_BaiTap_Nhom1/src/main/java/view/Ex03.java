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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author PC
 */
public class Ex03 extends JFrame {

    private static final String TEXT_CONVERTION_APP_TETILE = "Ex01_Truncate";
    private static final int TEXT_CONVERTION_APP_WIDTH = 560;
    private static final int TEXT_CONVERTION_APP_HEIGHT = 320;
    private final Container conn = getContentPane();

    private JLabel lbTitle;
    private JButton btStop;

    private final Color[] colors = {Color.BLACK, Color.BLUE, Color.PINK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.RED};

    public Ex03() {
        initComponents();
        randomColor();
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
        setResizable(false);

        conn.setLayout(null);
        final int VERTICAL_PADDING = 40;
        final int INITTIAL_HEADER_X_PADDING = 220;
        final int INITTIAL_HEADER_Y_PADDING = 40;

        lbTitle = new JLabel();
        lbTitle.setText("Random");
        lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbTitle.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING,
                getPreWidth(lbTitle) + 100,
                getPreHeight(lbTitle));

        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setFont(new Font("Tahoma", Font.BOLD, 18));
        btStop.setText("STOP");
        btStop.setBounds(INITTIAL_HEADER_X_PADDING, INITTIAL_HEADER_Y_PADDING
                + VERTICAL_PADDING
                + getPreHeight(lbTitle),
                getPreWidth(lbTitle) + 100,
                36);
        conn.add(btStop);

        conn.add(lbTitle);
    }

    private void randomColor() {
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = (int) Math.floor(Math.random() * 7);
                Color colorRandom = colors[n];
                conn.setBackground(colorRandom);
                if (colorRandom == Color.RED) {
                    lbTitle.setText("Random: RED");
                } else if (colorRandom == Color.BLACK) {
                    lbTitle.setText("Random: BLACK");
                } else if (colorRandom == Color.GREEN) {
                    lbTitle.setText("Random: GREEN");
                } else if (colorRandom == Color.WHITE) {
                    lbTitle.setText("Random: WHITE");
                } else if (colorRandom == Color.YELLOW) {
                    lbTitle.setText("Random: YELLOW");
                } else if (colorRandom == Color.BLUE) {
                    lbTitle.setText("Random: BLUE");
                } else if (colorRandom == Color.PINK) {
                    lbTitle.setText("Random: PINK");
                }
            }
        });
        timer.start();
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    timer.stop();
                    Thread.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex03.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

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
