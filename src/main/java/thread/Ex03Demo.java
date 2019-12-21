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
public class Ex03Demo {
    public static void main(String[] args) throws InterruptedException {
        Ex03MyThread t1 = new Ex03MyThread();
        t1.setName("Thread-01");
        t1.start();
        t1.join();
        
        Ex03MyThread t2 = new Ex03MyThread();
        t2.setName("Thread-02");
        t2.start();
        t2.join();
    }
}
