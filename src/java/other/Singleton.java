package other;

/**
 * Created by HAOYUXING on 2020/12/14.
 *
 * 单例模式
 */
public class Singleton {

    private Singleton() {}

    // 静态内部类
    private static class Holder {
        private static Singleton instance = new Singleton();

    }

    public static Singleton getSingleton() {
        return Holder.instance;
    }

}

// 双重锁
//public
class SinglentV2 {

    private SinglentV2() {}

    // static 是由于静态的 getSingleton()要访问
    // volatile 是保证创建对象时禁止重排序
    private static volatile SinglentV2 instance;

    public static SinglentV2 getSingleton() {
        if (instance == null) {
            // 必须对类对象加锁
            synchronized (SinglentV2.class) {
                if (instance == null) {
                    instance = new SinglentV2();
                }
            }
        }
        return instance;
    }
}

