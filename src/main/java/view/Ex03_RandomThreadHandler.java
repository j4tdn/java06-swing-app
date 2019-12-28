/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Ex03_RandomThreadHandler extends Thread{
    private JFrame frame = null;
    private List<Color> colors = Arrays.asList(Color.BLACK,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.WHITE);

    public Ex03_RandomThreadHandler(JFrame frame) {
        this.frame = frame;
        
    }

    @Override
    public void run() {
        while(true){
            try {
                Container con = frame.getContentPane();
                Random rd = new Random();
                Color color = colors.get(rd.nextInt(colors.size()));
                con.setBackground(color);
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex03_RandomThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
