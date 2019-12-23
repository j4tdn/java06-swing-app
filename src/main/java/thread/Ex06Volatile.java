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
public class Ex06Volatile {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ChangeListener());
        thread1.setName("ChangeListener");

        Thread thread2 = new Thread(new ChangeMaker());
        thread2.setName("ChangeListener");

        thread1.start();
        thread2.start();
    }

    // CPU 01
    static class ChangeListener implements Runnable {

        @Override
        public void run() {
            // CPU 01: cache
            int localValue = counter;
            while (localValue < 5) {
                if (localValue != counter) {
                    System.out.println("Change for COUNTER: " + counter);
                    localValue = counter;
                }
            }
        }
    }

    // CPU 02
    static class ChangeMaker implements Runnable {

        @Override
        public void run() {
            // CPU 02: cache
            int localValue = counter;
            while (counter < 5) {
                System.out.println("Incrementing COUNTER to " + (localValue + 1));
                counter = ++localValue;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // https://www.geeksforgeeks.org/volatile-keyword-in-java/ : Thread safe
    // http://tutorials.jenkov.com/java-concurrency/volatile.html : Scenario
    // https://en.wikipedia.org/wiki/CPU_cache#Write_policies : CPU cache
    // https://congdongjava.com/forum/threads/h%E1%BB%8Fi-%C4%90%C3%A1p-t%E1%BB%AB-kh%C3%B3a-volatile-trong-java.21197/
}
