import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread = new Thread(new Consumer(blockingQueue));
        Thread consumerThread1 = new Thread(new Consumer(blockingQueue));
        producerThread.start();
        consumerThread.start();
        consumerThread1.start();
    }
}

class Producer implements Runnable {
    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            long timeInMillis = System.currentTimeMillis();
            try {
                blockingQueue.put("" + timeInMillis);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Thread Interrupted during wait: " + Thread.currentThread().getName());
            }
        }

    }
}

class Consumer implements Runnable{
    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run(){
        while (true) {
            try {
                String item = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "Consumed value: " + item);
            } catch (InterruptedException e){
                System.err.println("Thread Interrupted during wait: " + Thread.currentThread().getName());
            }
        }
    }
}
