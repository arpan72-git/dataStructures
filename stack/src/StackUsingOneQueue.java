import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
    Queue<Integer> queue = new LinkedList<>();
    int size;

    public static void main(String[] args) {
        StackUsingOneQueue s = new StackUsingOneQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.queue);
        System.out.println("Size of queue: " + s.size);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.queue);
        System.out.println(s.size);
    }

    public void push(int element){
        int size = queue.size();
        queue.add(element);
        for (int i=0; i<size; i++){
            queue.add(queue.remove());
        }
        this.size = queue.size();
    }

    public int pop(){
        if (!queue.isEmpty())
            return queue.poll();
        return -1;
    }
}
