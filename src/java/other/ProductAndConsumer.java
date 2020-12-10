package other;

import java.util.LinkedList;

/**
 * Created by HAOYUXING on 2020/8/20.
 */
public class ProductAndConsumer {
    private final Object object = new Object();

    private LinkedList<Object> list = new LinkedList();

    private int size = 10;


    public void put() {
        synchronized (object) {
            while (list.size() >= size) {
                System.out.println("仓库满了，等待消费");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产 -- " + list.size());
            object.notifyAll();
        }

    }

    public void get() {
        synchronized (object) {
            while (list.size() == 0) {
                System.out.println("仓库空了，等待生产");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.removeLast();
            System.out.println("消费 -- " + list.size());
            object.notifyAll();
        }
    }


    class Producer extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    put();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProductAndConsumer consumer = new ProductAndConsumer();
        consumer.new Producer().start();
        consumer.new Producer().start();

        consumer.new Consumer().start();
        consumer.new Consumer().start();
    }

}
