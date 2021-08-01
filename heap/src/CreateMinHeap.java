import java.util.Arrays;

public class CreateMinHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(-1, new int[9], 9);
        System.out.println("Initial Heap : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 10);
        System.out.println("Heap after inserting 10 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 12);
        System.out.println("Heap after inserting 12 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 16);
        System.out.println("Heap after inserting 16 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 25);
        System.out.println("Heap after inserting 25 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 33);
        System.out.println("Heap after inserting 33 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 34);
        System.out.println("Heap after inserting 34 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 35);
        System.out.println("Heap after inserting 35 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 45);
        System.out.println("Heap after inserting 45 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 50);
        System.out.println("Heap after inserting 50 : " + Arrays.toString(minHeap.heap));
        insert(minHeap, 55);
        int deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(minHeap.heap));
        deletedElement = delete(minHeap);
    }

    public static void insert(MinHeap minHeap, int element){
        if (minHeap.current_pos == minHeap.maxSize - 1){ System.out.println("Heap full"); return;}
        minHeap.current_pos++;
        minHeap.heap[minHeap.current_pos] = element;
        int i = minHeap.current_pos;

        int temp = minHeap.heap[i];
        while (i>0 && temp < minHeap.heap[(i-1)/2]){
            minHeap.heap[i] = minHeap.heap[(i-1)/2];
            i = (i-1)/2;
        }
        minHeap.heap[i] = temp;
    }

    public static int delete(MinHeap minHeap){
        if (minHeap.current_pos == -1) {
            System.out.println("Heap Empty");
            return -1;
        }

        int deletedElement = minHeap.heap[0];
        minHeap.heap[0] = minHeap.heap[minHeap.current_pos];
        minHeap.heap[minHeap.current_pos] = 0;
        minHeap.current_pos--;
        int p = 0, l = 1;
        while (l<= minHeap.current_pos){
            if (l+1 <= minHeap.current_pos && minHeap.heap[l+1] < minHeap.heap[l])
                l = l+1;
            if (minHeap.heap[p] > minHeap.heap[l]){
                int temp = minHeap.heap[p];
                minHeap.heap[p] = minHeap.heap[l];
                minHeap.heap[l] = temp;
                p = l;
                l = (2*p) + 1;
            }
            else break;
        }
//        minHeap.heap[minHeap.current_pos + 1] = deletedElement;     // uncomment this line to make the heap as sorted heap
        return deletedElement;
    }

    static class MinHeap {
        int current_pos;
        int maxSize;
        int[] heap;
        public MinHeap(int current_pos, int[] heap, int maxSize){
            this.current_pos = current_pos;
            this.heap = heap;
            this.maxSize = maxSize;
        }
    }
}
