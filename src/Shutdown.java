import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Shutdown {
    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread1 = new Thread(one, "CountThread1");
        countThread1.start();
        // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread1.interrupt();
        Runner two = new Runner();
        Thread countThread = new Thread(two, "CountThread2");
        countThread.start();
        // 睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }
    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "   Count i = " + i);
        }
        public void cancel() {
            on = false;
        }
    }
}
