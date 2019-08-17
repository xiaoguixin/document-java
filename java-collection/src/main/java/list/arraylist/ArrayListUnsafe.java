package list.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList多线程下不安全演示
 * 该程序会输出以下情况
 * 1.抛出ArrayIndexOutOfBoundsException异常；
 * 2.正常执行，但list的size会少于容量大小；
 * 3.正常执行，但list的size炒超出来容量大小；
 * 解决方案使用CopyOnWriteArrayList或者Vector
 */
public class ArrayListUnsafe {

    private final static int TYPE = 0;
    private static List<Integer> list = new ArrayList();
    private static List<Integer> list1 = new CopyOnWriteArrayList();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                switch (TYPE) {
                    case 0:
                        list1.add(i);
                        break;
                    case 1:
                        break;
                    default:
                        list.add(i);
                        break;
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
        System.out.println(list1.size());
    }
}
