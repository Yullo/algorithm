package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 三个线程交替打印
 *
 * Created by HAOYUXING on 2020/12/1.
 */
public class ThreePrint {

    Object object1 = new Object();
    Object object2 = new Object();
    Object object3 = new Object();

    AtomicInteger integer = new AtomicInteger();

    public static void main(String[] args) {
        ThreePrint print = new ThreePrint();
        print.new PrintA().start();
        print.new PrintB().start();
        print.new PrintC().start();
    }

    class PrintA extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (object1) {
                    try {
                        System.out.println("A" + ":" + integer.addAndGet(1));
                        synchronized (object2) {
                            object2.notify();
                        }
                        sleep(100);
                        object1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class PrintB extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (object2) {
                    try {
                        System.out.println("B" + ":" + integer.addAndGet(1));
                        synchronized (object3) {
                            object3.notify();
                        }
                        sleep(100);
                        object2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class PrintC extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (object3) {
                    try {
                        System.out.println("C" + ":" + integer.addAndGet(1));
                        synchronized (object1) {
                            object1.notify();
                        }
                        sleep(100);
                        object3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
