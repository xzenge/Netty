import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/10/25.
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> result = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(int i = 0 ;i< 10000;i++){

                }
                return "11111";
            }
        });

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "aaaaaa";
            }
        };

        Runnable sfsfsfsf = new Runnable() {
            @Override
            public void run() {
                System.out.println("sfsfsfsf");
            }
        };

        executorService.submit(sfsfsfsf).get();


//        Future<String> submit = executorService.submit(callable);

//        try {
////            String s = submit.get(5, TimeUnit.SECONDS);
////            System.out.println(s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();


    }

}
