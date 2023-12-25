package sortingSearchingAlgorithms;

import org.testng.Assert;

import java.util.Arrays;

public class SortingAlgorithms {
    ////Burdaki olay adeta bir baloncuk gibi kayarak en bastan ve en sondan tum elema
    ////we are going loop through array for each round
    ////then we will write another loop for comparing!!
    public static void test() {
        // Set the path to your ChromeDriver executable
        String s="Priya";
        String[] arr= s.split("");
        Object[] newArr= Arrays.stream(arr).map(x->x=x.toLowerCase()).sorted().toArray();
        String nesw= Arrays.toString(newArr);
        System.out.println(nesw);
    }
//—eger sorted true koyarsak ve array sirali arrayse Best case imiz N olur wors case ise n^2 olur cunku N olmasi demek tum hepsine tek seferda bakip gecer o kadar!!!
//    Please note that Bubble Sort is a simple sorting algorithm with a time complexity of O(n^2). For larger datasets,
//    more efficient sorting algorithms like Quick Sort or Merge Sort are recommended.
//Now, let's go through the key components:
//
//Outer Loop (i): The outer loop iterates over each element in the array. In each iteration, it aims to place the largest unsorted element at its correct position.
//
//Inner Loop (j): The inner loop iterates over the unsorted part of the array. It compares adjacent elements and swaps them if they are in the wrong order (ascending order in this case).
//
//Swap Operation: The swap operation is performed using a temporary variable (temp) to exchange the values of arr[j] and arr[j+1].
//
//sorted Variable: The sorted variable is used to check whether any swapping occurred during a pass through the array. If no swapping occurred, it means the array is already sorted, and the algorithm can terminate early.
//
//Termination Condition: The algorithm terminates when the outer loop completes without any swaps, indicating that the array is fully sorted.
//
//Return Statement: The sorted array is returned.
//
//Bubble Sort works by repeatedly swapping adjacent elements if they are in the wrong order until the entire array is sorted. The algorithm has a time complexity of O(n^2) in the worst case. While not the most efficient sorting algorithm, it is simple to understand and implement.
public int[] bubbleSort(int[] arr) {
    int n = arr.length;

    // Outer loop iterates over each element in the array
    for (int i = 0; i < n - 1; i++) {
        boolean sorted = true;

        // Inner loop iterates over the unsorted part of the array
        for (int j = 0; j < n - i - 1; j++) {
            // Compare adjacent elements and swap them if they are in the wrong order
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                // Set sorted to false if any swapping occurs
                sorted = false;
            }
        }

        // If no swapping occurred, the array is already sorted, and the algorithm can terminate
        if (sorted) {
            break;
        }
    }

    // Return the sorted array
    return arr;
}

//    Selection Sort also has a time complexity of O(n^2), and like Bubble Sort, it's suitable for small datasets. For larger datasets, more efficient algorithms should be considered.
//    Now, let's go through the key components:
//
//Outer Loop (i): The outer loop iterates over each element in the array. In each iteration, it considers the i-th element as the minimum element in the unsorted part of the array.
//
//Inner Loop (j): The inner loop starts from i + 1 and finds the index (minIndex) of the minimum element in the unsorted part of the array.
//
//Finding Minimum Element (if condition): Inside the inner loop, the algorithm checks if the element at index j is smaller than the element at minIndex. If true, it updates minIndex to j, indicating that a smaller element has been found.
//
//Swap Operation: After finding the minimum element in the unsorted part, the algorithm swaps it with the element at index i, effectively placing the minimum element in its correct position.
//
//Termination Condition: The outer loop continues until the second-to-last element, as the last element is already in its correct position after the previous iterations.
//
//Return Statement: The sorted array is returned.
//
//Selection Sort works by dividing the array into two parts: a sorted part and an unsorted part. In each iteration, it selects the smallest element from the unsorted part and swaps it with the first element of the unsorted part, extending the sorted part. The algorithm has a time complexity of O(n^2) in the worst case. Although not the most efficient, it's simple and easy to understand.
public int[] selectionSort(int[] arr) {
    int n = arr.length;

    // Outer loop iterates over each element in the array
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;

        // Inner loop finds the index of the minimum element in the unsorted part of the array
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Swap the found minimum element with the first element in the unsorted part
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }

    // Return the sorted array
    return arr;
}

}