public class MedainOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    private static double findMedianSortedArrays(int[] A, int[] B) {

        if(A.length > B.length){
            return findMedianSortedArrays(B, A);
        }

        int x = A.length;
        int y = B.length;

        int l = 0, r = x;

        while(l <= r){
            int midA = (l + r) / 2;
            int midB = (x + y + 1)/2 - midA;

            int maxLeftA = midA == 0 ? Integer.MIN_VALUE : A[midA - 1];
            int minRightA = midA == x ? Integer.MAX_VALUE : A[midA];
            int maxLeftB = midB ==0 ? Integer.MIN_VALUE : B[midB - 1];
            int minRightB = midB == y ? Integer.MAX_VALUE : B[midB];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                if((x + y) % 2 != 0){
                    return Math.max(maxLeftA, maxLeftB);
                }
                else{
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                }
            }
            else if(maxLeftA > minRightB){
                r = midA - 1;
            }
            else{
                l = midA + 1;
            }
        }
    throw new IllegalArgumentException();
    }
}
