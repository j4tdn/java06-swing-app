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
public class Ex01 {
    public static void main(String[] args) {
        System.out.println("Main Thread: 01 !!!" );
               
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    sleep(2);
                    System.out.println("i: " + i);
                }
            };
        });
        t1.start();
        
        System.out.println("Main Thread: 02 !!!" );
        
    }
    
    private static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
