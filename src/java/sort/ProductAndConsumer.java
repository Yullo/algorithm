package sort;

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
            System.out.println("生产。。。。");
            object.notify();
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
            System.out.println("消费。。。");
            object.notify();
        }
    }

}
