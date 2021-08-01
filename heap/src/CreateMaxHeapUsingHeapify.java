import java.util.Arrays;

public class CreateMaxHeapUsingHeapify {
    public static void main(String[] args) {
        int[] h = new int[]{10,12,16,25,33,34,35,45,50};
        MaxHeap maxHeap = new CreateMaxHeapUsingHeapify.MaxHeap( h);
        for (int i=(maxHeap.heap.length/2)-1; i>=0; i--) {
            insert(maxHeap, i);
        }

        System.out.println("Heap built: " + Arrays.toString(maxHeap.heap));
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
        delete(maxHeap);
    }

    public static void insert(MaxHeap maxHeap, int curr_pos){
        int p = curr_pos;
        int l = (p *2) +1;
        while (l < maxHeap.maxSize){
            if (l+1 < maxHeap.maxSize && maxHeap.heap[l+1] > maxHeap.heap[l])
                l = l+1;
            if (maxHeap.heap[p] < maxHeap.heap[l]){
                int temp = maxHeap.heap[p];
                maxHeap.heap[p] = maxHeap.heap[l];
                maxHeap.heap[l] = temp;
                p = l;
                l = (2*p) +1;
            }
        }
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
        System.out.println("Heap after deleting " + deletedElement + " : " + Arrays.toString(maxHeap.heap));
        return deletedElement;
    }

    static class MaxHeap{
        int current_pos;
        int maxSize;
        int[] heap;
        public MaxHeap(int[] heap){
            this.heap = heap;
            this.maxSize = heap.length;
            this.current_pos = maxSize-1;
        }
    }
}
