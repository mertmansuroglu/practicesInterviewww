package findSecondHighest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Function {
    public static void main(String[] args) {
        int[] arr= {100,14,46,47,94,94,100,52,86,36,94,89};
       int high= Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();
        System.out.println(high);

    }
}
//Create a method to find the second-highest number in an array: {100,14,46,47,94,94,100,52,86,36,94,89}