/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.date01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import utils.ImageUtils;

/**
 *
 * @author VO DINH DUNG
 */
public class Bai3 extends JFrame {

    private static final String BACKGROUND_RANDOM_APP_TITLE = "Background Random";
    private static final int BACKGROUND_RANDOM_APP_WIDTH = 540;
    private static final int BACKGROUND_RANDOM_APP_HEIGHT = 480;
    private static final String BACKGOUND_RANDOM_APP_ICON = "E:\\Java\\lesson18\\64px_flower.png";
    private final Container conn = getContentPane();
    private JLabel lbTitle;
    private JLabel lbShow;
    private JButton btStop;
    private Random rd = new Random();

    public Bai3() {
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        Bai3 BackgroundRandomApp = new Bai3();
        BackgroundRandomApp.setVisible(true);
    }

    private void initComponents() {
        //DEFAULT
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(BACKGROUND_RANDOM_APP_TITLE);
        setIconImage(ImageUtils.load(BACKGOUND_RANDOM_APP_ICON));
        setSize(BACKGROUND_RANDOM_APP_WIDTH, BACKGROUND_RANDOM_APP_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        final int INITIAL_BUTTON_X_PADDING = 160;
        final int INITIAL_BUTTON_Y_PADDING = 300;

        // BUTTON
        btStop = new JButton();
        btStop.setFocusPainted(false);
        btStop.setText("STOP");
        btStop.setFont(new Font("Tahoma",Font.BOLD,20));
        btStop.setBounds(INITIAL_BUTTON_X_PADDING, INITIAL_BUTTON_Y_PADDING,200 , 40);
        conn.add(btStop);
        
        //lbShow
        final int INITIAL_LBSHOW_X_PADDING = 160;
        final int INITIAL_LBSHOW_Y_PADDING = 40;
        lbShow = new JLabel();
        lbShow.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lbShow.setBounds(INITIAL_LBSHOW_X_PADDING, INITIAL_LBSHOW_Y_PADDING, 200, 40);
        conn.add(lbShow);
        
    }
    private void initEvents() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomBackgroundColor();
            }
        };
        Timer t = new Timer(500, action);
        t.setRepeats(true);
        t.start();
        
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                     Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });
    }
    private void RandomBackgroundColor() {
            List<String> backgroundColor = new ArrayList<>();
            backgroundColor.add("Random : RED");
            backgroundColor.add("Random : BLUE");
            backgroundColor.add("Random : CYAN");
            backgroundColor.add("Random : GRAY");
            backgroundColor.add("Random : GREEN");
            backgroundColor.add("Random : WHITE");
            backgroundColor.add("Random : YELLOW");
            backgroundColor.add("Random : DRAK_GRAY");
           backgroundColor.get(1);
        int index = rd.nextInt(backgroundColor.size());
        
        switch(index){
            case 0 : 
               lbShow.setText(backgroundColor.get(0));
                conn.setBackground(Color.RED);
                break;
            case 1 :
               lbShow.setText(backgroundColor.get(1));
                conn.setBackground(Color.BLUE);
                break;
            case 2 : 
               lbShow.setText(backgroundColor.get(2));
                conn.setBackground(Color.CYAN);
                break;
            case 3 :
               lbShow.setText(backgroundColor.get(3));
                conn.setBackground(Color.GRAY);
                break;
            case 4 : 
               lbShow.setText(backgroundColor.get(4));
                conn.setBackground(Color.GREEN);
                break;
            case 5 : 
               lbShow.setText(backgroundColor.get(5));
                conn.setBackground(Color.WHITE);
                break;
            case 6 :
               lbShow.setText(backgroundColor.get(6));
                conn.setBackground(Color.YELLOW);
                break;
            case 7 : 
               lbShow.setText(backgroundColor.get(0));
                conn.setBackground(Color.DARK_GRAY);
                break;
        }

    }

    

}
