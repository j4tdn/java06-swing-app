/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class ThreadHandler_Ex01 extends Thread{
    private Ex01 ex01 = null ;
    
    public ThreadHandler_Ex01(Ex01 ex01) {
        
        this.ex01 = ex01;
        
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
                if(i == 500){
                synchronized(this){
                    wait();
                }
                
                }
                System.out.println("--"+getState().toString());
            }
            
            //JTextArea textArea = ex01.getTextArea();
            //while (true) {
//            textArea.setFont(textArea.getFont().deriveFont(ex01.getCurrentSize()));
//            textArea.setForeground(ex01.getCurrentColor());
//System.out.println(new Random().nextInt(200));
//}
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadHandler_Ex01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void changeStyle(){
        
    }
    
}
