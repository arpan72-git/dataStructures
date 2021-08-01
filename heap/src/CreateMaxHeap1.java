import java.util.Arrays;

public class CreateMaxHeap1 {
    public static void main(String[] args) {
        MaxHeap maxHeap = new CreateMaxHeap1.MaxHeap( 9);
        maxHeap.heap = new int[]{10,12,16,25,33,34,35,45,50};
        for (int i=0; i<maxHeap.heap.length; i++) {
            maxHeap.current_pos++;
            insert(maxHeap);
        }
        System.out.println("Heap : " + Arrays.toString(maxHeap.heap));
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

    public static void insert(MaxHeap maxHeap){
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
        public MaxHeap(int maxSize){
            this.current_pos = -1;
            this.heap = new int[maxSize];
            this.maxSize = maxSize;
        }
    }
}
