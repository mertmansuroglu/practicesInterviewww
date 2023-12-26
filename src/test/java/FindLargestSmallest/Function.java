package FindLargestSmallest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Function {
    // TODO: 12/25/2023 FINISHED!!!!
    public static void main(String[] args) {
    int[] arr={7,4,6,9,10};
        findSmallestLargest(arr);
        findSmallestLargest2(arr);
        findSmallestLargestStreams(arr);
    }

    public static void findSmallestLargest(int[] arr)
    {
        Arrays.sort(arr);
        System.out.println("smallest is "+arr[0]);;
        System.out.println("largest is "+arr[arr.length-1]);;
    }
    public static void findSmallestLargest2(int[] arr)
    {
        int largest=arr[0];
        int small=arr[0];
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i])
            {
                largest=arr[i];
            }else if(arr[i]<small){
                small=arr[i];
            }
        }
        System.out.println("smallest is "+small);;
        System.out.println("largest is "+largest);;
    }
    public static void findSmallestLargestStreams(int[] arr)
    {
        // Find the largest element using streams
        int largest = Arrays.stream(arr)
                .max()
                .orElse(Integer.MIN_VALUE);

        // Find the smallest element using streams
        int smallest = Arrays.stream(arr)
                .min()
                .orElse(Integer.MAX_VALUE);

        System.out.println("Largest element: " + largest);
        System.out.println("Smallest element: " + smallest);
    }
}
