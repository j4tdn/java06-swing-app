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
public class Ex02Demo {
    public static void main(String[] args) {
        Ex02MyThread mt = new Ex02MyThread();
        mt.start();
        
        Ex02Runnable rn = new Ex02Runnable();
        Thread thread = new Thread(rn);
        thread.start();
        
    }
}
