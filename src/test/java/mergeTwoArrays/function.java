package mergeTwoArrays;

import java.util.Arrays;

public class function {

        public static int[] mergeArrays(int[] arr1, int[] arr2) {
            int n1 = arr1.length;
            int n2 = arr2.length;

            // Create a new array to store the merged elements
            int[] mergedArray = new int[n1 + n2];

            // Copy elements from the first array to the merged array
            for (int i = 0; i < n1; i++) {
                mergedArray[i] = arr1[i];
            }

            // Copy elements from the second array to the merged array
            for (int i = 0; i < n2; i++) {
                mergedArray[n1 + i] = arr2[i];
            }
            
            return mergedArray;
        }

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {4, 5, 6};

            // Merge the two arrays
            int[] mergedArray = mergeArrays(arr1, arr2);

            // Print the merged array
            for (int num : mergedArray) {
                System.out.print(num + " ");
            }
        }
    }

