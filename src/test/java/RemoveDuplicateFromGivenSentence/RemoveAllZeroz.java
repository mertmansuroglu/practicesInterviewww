package RemoveDuplicateFromGivenSentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAllZeroz {

    public static void main(String[] args) {
        Integer[] arr={1,0,5,0,4,0,7,0};
        int[] arr2={1,0,5,0,4,0,7,0};
        List<Integer> list=  new ArrayList<>(Arrays.asList(arr));
        list.removeIf(x->x==0);
        System.out.println(list);

        /////

        int[] newArray = Arrays.stream(arr2)
                .filter(num -> num != 0)
                .toArray();
    }

    public static int[] longWay(int[] array)
    {
        int countNonZeros = 0;

        // Count the number of non-zero elements
        for (int num : array) {
            if (num != 0) {
                countNonZeros++;
            }
        }

        // Create a new array without zeros
        int[] newArray = new int[countNonZeros];
        int index = 0;

        // Copy non-zero elements to the new array
        for (int num : array) {
            if (num != 0) {
                newArray[index++] = num;
            }
        }

        return newArray;
    }
}
