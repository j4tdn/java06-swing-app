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
public class Ex04Thread01 extends Thread{

    @Override
    public void run() {
        Ex04SharedObject.show(1);
    }
    
}
