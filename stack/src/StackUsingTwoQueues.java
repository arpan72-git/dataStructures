import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {

        StackUsingTwoQueues s = new StackUsingTwoQueues();
        s.stackUsingTwoQueues();
    }

    public void stackUsingTwoQueues(){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("Press 1 to push element to stack");
            System.out.println("Press 2 to pop element from stack");
            System.out.println("Press 3 to exit");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = sc.nextInt();
                    pushElementInStack(element);
                    System.out.println("Element pushed");
                    break;
                case 2:
                    System.out.println("Element popped: " + popElementFromStack());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    public void pushElementInStack(int element){
        q1.add(element);
    }

    public int popElementFromStack(){
        if (q1.isEmpty()) return -1;

        for (int i=1; i<q1.size(); i++){
            q2.add(q1.remove());
        }
        int poppedElement = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }
}
