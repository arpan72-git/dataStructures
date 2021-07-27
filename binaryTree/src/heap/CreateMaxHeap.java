package heap;

import java.util.Arrays;

public class CreateMaxHeap {
    public static void main(String[] args) {
        MaxHeap maxHeap = new CreateMaxHeap.MaxHeap(-1, new int[9], 9);
        System.out.println("Initial Heap : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 10);
        System.out.println("Heap after inserting 10 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 12);
        System.out.println("Heap after inserting 12 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 16);
        System.out.println("Heap after inserting 16 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 25);
        System.out.println("Heap after inserting 25 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 33);
        System.out.println("Heap after inserting 33 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 34);
        System.out.println("Heap after inserting 34 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 35);
        System.out.println("Heap after inserting 35 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 45);
        System.out.println("Heap after inserting 45 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 50);
        System.out.println("Heap after inserting 50 : " + Arrays.toString(maxHeap.heap));
        insert(maxHeap, 55);
        int deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        deletedElement = delete(maxHeap);
    }

    public static void insert(MaxHeap maxHeap, int element){
        if (maxHeap.current_pos == maxHeap.maxSize - 1){ System.out.println("Heap full"); return;}
        maxHeap.current_pos++;
        maxHeap.heap[maxHeap.current_pos] = element;
        int i = maxHeap.current_pos;

        int temp = maxHeap.heap[i];
        while (i>0 && temp > maxHeap.heap[(i-1)/2]){
            maxHeap.heap[i] = maxHeap.heap[(i-1)/2];
            i = (i-1)/2;
        }
        maxHeap.heap[i] = temp;
    }

    public static int delete(MaxHeap maxHeap){
        if (maxHeap.current_pos == -1) {
            System.out.println("Heap Empty");
            return -1;
        }

        int deletedElement = maxHeap.heap[0];
        maxHeap.heap[0] = maxHeap.heap[maxHeap.current_pos];
        maxHeap.heap[maxHeap.current_pos] = 0;
        maxHeap.current_pos--;
        int p = 0, l = 1;
        while (l<= maxHeap.current_pos){
            if (l+1 <= maxHeap.current_pos && maxHeap.heap[l+1] > maxHeap.heap[l])
                l = l+1;
            if (maxHeap.heap[p] < maxHeap.heap[l]){
                int temp = maxHeap.heap[p];
                maxHeap.heap[p] = maxHeap.heap[l];
                maxHeap.heap[l] = temp;
                p = l;
                l = (2*p) + 1;
            }
            else break;
        }
//        maxHeap.heap[maxHeap.current_pos + 1] = deletedElement;     // uncomment this line to make the heap as sorted heap
        return deletedElement;
    }

    static class MaxHeap{
        int current_pos;
        int maxSize;
        int[] heap;
        public MaxHeap(int current_pos, int[] heap, int maxSize){
            this.current_pos = current_pos;
            this.heap = heap;
            this.maxSize = maxSize;
        }
    }
}
