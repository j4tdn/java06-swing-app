/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author qphan
 */
public class Ex04Demo {
    public static void main(String[] args) {
        Ex04Thread01 t1  = new Ex04Thread01();
        t1.setName("Thread-01");
        
        Ex04Thread05 t2  = new Ex04Thread05();
        t2.setName("Thread-02");
        
        Ex04Thread01 t3  = new Ex04Thread01();
        t3.setName("Thread-03");
        
        t1.start();
        t2.start();
        t3.start();
        
        
        // suspend, resume => deadlock
        // wait, notify, synchronized, volatile
    }
    
}
