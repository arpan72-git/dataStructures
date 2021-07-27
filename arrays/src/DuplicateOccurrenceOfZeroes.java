/**
 * Input : [1,0,2,3,0,4,5,0]
 * Output :[1,0,0,2,3,0,0,4]
 */
public class DuplicateOccurrenceOfZeroes {
    public static void main(String[] args) {
        duplicateZeros(new int[]{1,0,2,3,6,4,0,9});
    }

    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int i = 0; i <= length - possibleDups; i++) {

            // Count the zeros
            if (arr[i] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (i == length - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
