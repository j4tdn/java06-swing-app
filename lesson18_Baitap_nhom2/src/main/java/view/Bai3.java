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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Bai3 extends JFrame {

    private static final String THREAD_APP_TITLE = "Thread Demo";
    private static final int THREAD_APP_WIDTH = 540;
    private static final int THREAD_APP_HEIGHT = 415;
    private final int INITTAL_HEADER_X_PADDING = 190;
    private final int INITTAL_HEADER_Y_PADDING = 50;

    private final Container conn = getContentPane();
    private Random rd = new Random();

    private JButton btStop;
    private JLabel lbShow;

    public Bai3() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Bai3 bai3 = new Bai3();
        bai3.setVisible(true);

    }

    private void initEvents() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomBackground();
            }
        };
        Timer t = new Timer(500, action);
        t.setRepeats(true);
        t.start();

        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }

        });

    }

    private void randomBackground() {
        List<String> background = new ArrayList<>();
        background.add("Random: RED");
        background.add("Random: GREEN");
        background.add("Random: BLUE");
        background.add("Random: YELLOW");
        background.add("Random: PINK");
        background.add("Random: BLACK");
        background.add("Random: WHITE");

        

        int index = rd.nextInt(background.size());

        if ("Random: RED".equals(background.get(index))) {
            lbShow.setText("Random: RED");
            conn.setBackground(Color.RED);
        }
        if ("Random: GREEN".equals(background.get(index))) {
            lbShow.setText("Random: GREEN");;
            conn.setBackground(Color.GREEN);
        }
        if ("Random: BLUE".equals(background.get(index))) {
            lbShow.setText("Random: BLUE");
            conn.setBackground(Color.BLUE);
        }
        if ("Random: YELLOW".equals(background.get(index))) {
            lbShow.setText("Random: YELLOW");
            conn.setBackground(Color.YELLOW);
        }
        if ("Random: PINK".equals(background.get(index))) {
            lbShow.setText("Random: PINK");
            conn.setBackground(Color.PINK);
        }
        if ("Random: BLACK".equals(background.get(index))) {
            lbShow.setText("Random: BLACK");
            conn.setBackground(Color.BLACK);
        }
        if ("Random: WHITE".equals(background.get(index))) {
            lbShow.setText("Random: WHITE");
            conn.setBackground(Color.WHITE);
        }
        

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(THREAD_APP_TITLE);
        setSize(THREAD_APP_WIDTH, THREAD_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        //---------------------------------------------------------

        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setText("Stop");
        btStop.setFont(new Font("Tahoma", Font.BOLD, 20));
        btStop.setBounds(INITTAL_HEADER_X_PADDING + 30, INITTAL_HEADER_Y_PADDING * 4, 100, 40);
        conn.add(btStop);
        
        lbShow = new JLabel();
        lbShow.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbShow.setBounds(INITTAL_HEADER_X_PADDING, INITTAL_HEADER_Y_PADDING,
                220, 20);
        conn.add(lbShow);

    }

}
