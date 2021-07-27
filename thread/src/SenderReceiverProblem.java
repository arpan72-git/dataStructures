public class SenderReceiverProblem {
    public static void main(String[] args) {
        Assignment assignment = new Assignment();
        Thread thread1 = new Thread(new Sender(assignment), "Sender-Thread-1");
        Thread thread3 = new Thread(new Sender(assignment), "Sender-Thread-2");
        Thread thread2 = new Thread(new Receiver(assignment), "Receiver-Thread-1");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Assignment{
    boolean transfer = true; // if transfer is true: receiver needs to wait, else sender needs to wait
    int x = 0;
    public synchronized void send(){
        while (!transfer){
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + " is waiting to send packet");
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted while waiting to send the packet: " + e.getMessage());
            }
        }
        x++;
        transfer = false;
        System.out.println("Packet sent by : " + Thread.currentThread().getName() + " with value: " + x);
        notifyAll();
    }

    public synchronized void receive(){
        while (transfer){
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + " is waiting to receive packet");
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted while waiting to receive the packet: " + e.getMessage());
            }
        }
        x--;
        transfer = true;
        System.out.println("Packet received and consumed by: " + Thread.currentThread().getName() + " with value: " + x);
        notifyAll();
    }
}

class Sender implements Runnable{
    Assignment assignment;

    public Sender(Assignment assignment){
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

class Receiver implements Runnable{
    Assignment assignment;

    public Receiver(Assignment assignment){
        this.assignment = assignment;
    }

    @Override
    public void run() {
        while (true){
            assignment.receive();
        }
    }
}
