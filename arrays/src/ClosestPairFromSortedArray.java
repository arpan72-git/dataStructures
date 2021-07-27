import java.util.Scanner;

//Given a sorted array and a number x, find the pair in array whose sum is closest to x
//Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
//Output: 22 and 30
//
//Input: arr[] = {1, 3, 4, 7, 10}, x = 15
//Output: 4 and 10
public class ClosestPairFromSortedArray {
    public static void main(String[] args) {
        Scanner dc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int length = dc.nextInt();
        int[] sortedArray = new int[length];
        System.out.print("Enter elements of array in sorted manner: ");
        for (int i=0; i< length; i++)
            sortedArray[i] = dc.nextInt();

        System.out.print("Enter element for which to find closest pair: ");
        int sum = dc.nextInt();

        int diff = Integer.MAX_VALUE;
        int r1 = 0, r2 = 0;
        int l = 0, r = sortedArray.length - 1;
        while (l < r){
            final int abs = Math.abs(sortedArray[l] + sortedArray[r] - sum);
            if (abs < diff){
                r1 = l;
                r2 = r;
                diff = abs;
            }

            if (sortedArray[l] + sortedArray[r] < sum)
                l++;
            else
                r--;
        }

        System.out.println("Pair is: (" + sortedArray[r1] + "," + sortedArray[r2] +")");


    }
}
