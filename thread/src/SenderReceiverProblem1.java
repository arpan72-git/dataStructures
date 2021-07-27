import java.util.LinkedList;
import java.util.Queue;

public class SenderReceiverProblem1 {
    public static void main(String[] args) {
        Assignment1 assignment = new Assignment1(new LinkedList<>());
        Thread thread1 = new Thread(new Sender1(assignment), "Sender-Thread-1");
        Thread thread3 = new Thread(new Sender1(assignment), "Sender-Thread-2");
        Thread thread2 = new Thread(new Receiver1(assignment), "Receiver-Thread-1");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Assignment1{
    boolean transfer = true; // if transfer is true: receiver needs to wait, else sender needs to wait
    int x;
    Queue<Integer> queue;

    public Assignment1(Queue<Integer> queue){this.queue = queue;}

    public synchronized void send(){
        while (!transfer){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to send packet");
                wait();
                System.out.println(Thread.currentThread().getName());
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted while waiting to send the packet: " + e.getMessage());
            }
        }
        x++;
        queue.add(x);
        transfer = false;
        System.out.println("Packet sent by : " + Thread.currentThread().getName() + " with value: " + x);
        notifyAll();
    }

    public synchronized void receive(){
        while (transfer){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting to receive packet");
                wait();
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted while waiting to receive the packet: " + e.getMessage());
            }
        }
        queue.remove();
        transfer = true;
        System.out.println("Packet received and consumed by: " + Thread.currentThread().getName() + " with value: " + x);
        notifyAll();
    }
}

class Sender1 implements Runnable{
    Assignment1 assignment;

    public Sender1(Assignment1 assignment){
        this.assignment = assignment;
    }

    @Override
    public void run() {
        while (true){
            assignment.send();
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
    }
}

class Receiver1 implements Runnable{
    Assignment1 assignment;

    public Receiver1(Assignment1 assignment){
        this.assignment = assignment;
    }

    @Override
    public void run() {
        while (true){
            assignment.receive();
        }
    }
}
