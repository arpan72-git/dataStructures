import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadExample {

    private volatile ThreadPoolExecutor threadPoolExecutor;

    public static void main(String[] args) throws InterruptedException {
        ThreadExample threadExample = new ThreadExample();
        threadExample.doTheWork();
    }

    private void doTheWork() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        ThreadFactory myThreadFactory = new MyThreadFactory("task");
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2, myThreadFactory);

        System.out.println("before task is sent to be executed:  thread pool size: " + threadPoolExecutor.getPoolSize() + ", core pool size: " + threadPoolExecutor.getCorePoolSize() + " - threads active count: " + threadPoolExecutor.getActiveCount());
        scanner.next();
        threadPoolExecutor.execute(new MyTask());
Thread.sleep(1000);
        System.out.println("immediately after task is sent to be executed: thread pool size: " + threadPoolExecutor.getPoolSize() + ", core pool size: " + threadPoolExecutor.getCorePoolSize() + " - threads active count: " + threadPoolExecutor.getActiveCount());
        threadPoolExecutor.execute(new MyTask());threadPoolExecutor.submit(new MyTask());
        System.out.println("immediately after task is sent to be executed: thread pool size: " + threadPoolExecutor.getPoolSize() + ", core pool size: " + threadPoolExecutor.getCorePoolSize() + " - threads active count: " + threadPoolExecutor.getActiveCount());
        threadPoolExecutor.execute(new MyTask());
        System.out.println("immediately after task is sent to be executed: thread pool size: " + threadPoolExecutor.getPoolSize() + ", core pool size: " + threadPoolExecutor.getCorePoolSize() + " - threads active count: " + threadPoolExecutor.getActiveCount());

//        scanner.next();
//
//        System.out.println("going to sleep");
//        Thread.sleep(2000);
//        System.out.println("going to sleep");
//        System.out.println("after waking up");
//        System.out.println("after waking up: thread pool size: " + threadPoolExecutor.getPoolSize() + ", core pool size: " + threadPoolExecutor.getCorePoolSize() + " - threads active count: " + threadPoolExecutor.getActiveCount());
//        scanner.next();
//
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);

    }

    class MyThreadFactory implements ThreadFactory {

        Logger logger = Logger.getLogger("MyThreadFactory");

        private int counter = 0;
        private String prefix = "";

        public MyThreadFactory(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            counter++;
            String name = prefix + "-" + counter;
            logger.log(Level.WARNING, "thread: " + name + " - is going to be created");
            System.out.println("before a new thread is created. pool size: " + threadPoolExecutor.getPoolSize() + ", core pool size: " + threadPoolExecutor.getCorePoolSize() + " - threads active count: " + threadPoolExecutor.getActiveCount());
            return new Thread(r, name);
        }
    }


}


class MyTask implements Runnable {

    Logger logger = Logger.getLogger("MyTask");

    @Override
    public void run() {

//        while (true) {

            System.out.println("thread: " + Thread.currentThread().getName() + " - current state: " + Thread.currentThread().getState());
//            throw new RuntimeException("something bad happened");
//        }

    }
}