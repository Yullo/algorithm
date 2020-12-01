package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两个线程交替打印 A B
 *
 * Created by HAOYUXING on 2020/12/1.
 */
public class TwoPrint {

    Object object = new Object();

    AtomicInteger integer = new AtomicInteger();

    public static void main(String[] args) {
        TwoPrint print = new TwoPrint();
        print.new PrintA().start();
        print.new PrintB().start();
    }

    /**
     * wait() 执行的时候会释放锁，并且立刻阻塞，等待唤醒后才能继续执行
     * notify() 执行时，不会释放锁， 只是唤醒阻塞的线程来竞争锁， 所以会继续往后执行， 直到退出代码块才释放锁
     */

    class PrintA extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    try {
                        System.out.println("A" + ":" + integer.addAndGet(1));
                        object.notify();
                        sleep(100);
                        object.wait();
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
                synchronized (object) {
                    try {
                        System.out.println("B" + ":" + integer.addAndGet(1));
                        object.notify();
                        sleep(100);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
