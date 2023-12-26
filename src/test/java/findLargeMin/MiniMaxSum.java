package findLargeMin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMaxSum {
    // TODO: 12/25/2023 FINISHED!!!!
    public static void miniMaxSum(List<Integer> arr) {
        long min = 0;
        long max = 0;
        long TotalSum = 0;

        //below converting list of integer to list of long
        List<Long> longs = arr.stream()
                .mapToLong(Integer::longValue)
                .boxed().sorted().collect(Collectors.toList());
        for (int i = 0; i < longs.size(); i++) {
            if (i == 0) {
                min = longs.get(i);
            } else if (i == arr.size() - 1) {
                max = longs.get(i);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            TotalSum += arr.get(i);
        }
        System.out.print(TotalSum - max + " ");
        System.out.println(TotalSum - min);

    }

    public static void miniMaxSumAlternativeWay(List<Integer> arr) {
        long minSum = 0;
        long maxSum = 0;
        Long maxNumber = Long.valueOf(arr.stream().max(Comparator.naturalOrder()).get());
        Long minNumber = Long.valueOf(arr.stream().min(Comparator.naturalOrder()).get());
        minSum = arr.stream().mapToLong(f -> f.longValue()).sum() - maxNumber;
        maxSum = arr.stream().mapToLong(f -> f.longValue()).sum() - minNumber;
        System.out.println(minSum + " " + maxSum);
    }

    public static void miniMaxSumAlternativeWay2(List<Integer> arr) {
        long sum = 0;
        long min = Collections.min(arr);
        long max = Collections.max(arr);
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        System.out.print(sum - max + " ");
        System.out.println(sum - min);
    }
}
