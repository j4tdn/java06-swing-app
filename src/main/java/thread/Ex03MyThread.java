/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qphan
 */
public class Ex03MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 1;i <= 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                
            }
            System.out.println(Thread.currentThread().getName() + " => i: " + i); 
        }
    }
    
}
