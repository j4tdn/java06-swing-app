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
public class Ex04Thread05 extends Thread{

    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex04Thread05.class.getName()).log(Level.SEVERE, null, ex);
        }
        Ex04SharedObject.show(5);
    }
    
}
