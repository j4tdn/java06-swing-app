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
public class Ex04SharedObject {
    public synchronized static void show(int n) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " i " + (n * i));
        }
    }
}
