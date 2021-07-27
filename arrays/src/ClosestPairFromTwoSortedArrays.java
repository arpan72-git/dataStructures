import java.util.Scanner;

//Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
//We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.
//Example:
//
//Input:  ar1[] = {1, 4, 5, 7};
//        ar2[] = {10, 20, 30, 40};
//        x = 32
//Output:  1 and 30
//
//Input:  ar1[] = {1, 4, 5, 7};
//        ar2[] = {10, 20, 30, 40};
//        x = 50
//Output:  7 and 40
public class ClosestPairFromTwoSortedArrays {
    public static void main(String[] args) {
        Scanner dc = new Scanner(System.in);
        System.out.print("Enter length of first array: ");
        int length1 = dc.nextInt();
        int[] sortedArray1 = new int[length1];
        System.out.print("Enter elements of first array in sorted manner: ");
        for (int i=0; i< length1; i++)
            sortedArray1[i] = dc.nextInt();

        System.out.print("Enter length of second array: ");
        int length2 = dc.nextInt();
        int[] sortedArray2 = new int[length2];
        System.out.print("Enter elements of second array in sorted manner: ");
        for (int i=0; i< length2; i++)
            sortedArray2[i] = dc.nextInt();

        System.out.print("Enter element for which to find closest pair: ");
        int sum = dc.nextInt();

        int diff = Integer.MAX_VALUE;
        int r1 = 0, r2 = 0;
        int l = 0, r = sortedArray2.length - 1;
        while (l < sortedArray1.length && r >= 0){
            final int abs = Math.abs(sortedArray1[l] + sortedArray2[r] - sum);
            if (abs < diff){
                r1 = l;
                r2 = r;
                diff = abs;
            }

            if (sortedArray1[l] + sortedArray2[r] < sum)
                l++;
            else
                r--;
        }

        System.out.println("Pair is: (" + sortedArray1[r1] + "," + sortedArray2[r2] +")");

    }
}
