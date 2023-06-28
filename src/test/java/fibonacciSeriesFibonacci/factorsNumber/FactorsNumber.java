package fibonacciSeriesFibonacci.factorsNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FactorsNumber {
    public static Integer[] checkArmstrong(int number) {

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (number % i == 0) {
                arr.add(i);
                arr.add(number / i);
            }
        }
        HashSet<Integer> set = new HashSet<>(arr);
        return set.toArray(new Integer[set.size()]);
    }

}
