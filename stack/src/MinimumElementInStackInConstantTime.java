import java.util.Arrays;

public class MinimumElementInStackInConstantTime {
    public static void main(String[] args) {
        Stack stack = new MinimumElementInStackInConstantTime().new Stack(8);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.printStack();
        stack.getMin();
        stack.push(1);
        stack.push(1);
        stack.push(-1);
        stack.push(-5);
        stack.printStack();
        stack.getMin();
        stack.push(-1);
        stack.push(6);
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.printStack();
        stack.getMin();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
    }


    private class Stack{
        private int top = -1;
        private int[] arr;
        private int stack_size;
        private int minEle;

        private Stack(int stack_size){
            this.stack_size = stack_size;
            arr = new int[stack_size];
        }

        private void push(int element){
            if (this.isFull()) {
                System.out.println("Stack Full");
                return;
            }
            if (this.isEmpty()){
                minEle = element;
                this.arr[++top] = element;
                return;
            }
            if (element >= minEle){
                this.arr[++top] = element;
            }
            else {
                int cur = 2 * element - this.minEle;
                this.minEle = element;
                this.arr[++this.top] = cur;
            }
        }

        private void pop(){
            if (isEmpty()){
                System.out.println("Stack Empty");
                return;
            }
            int poppedElement;
            if (arr[top] >= minEle){
                poppedElement = this.arr[top];
            }
            else {
                poppedElement = minEle;
                minEle = 2 * minEle - this.arr[top];
            }
            this.top--;
            System.out.println("Element popped: " + poppedElement);
        }

        private void getMin(){
            if (isEmpty()){
                System.out.println("No minimum element");
                return;
            }
            System.out.println("Minimum element: " + minEle);
        }

        private boolean isEmpty(){
            return this.top == -1;
        }

        private boolean isFull(){
            return this.top == stack_size-1;
        }

        private void printStack(){
            if (isEmpty()) {System.out.println("Stack is empty"); return;}
            System.out.print("Elements in stack : ");
            for (int i=top; i>=0; i--)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

}
