package findLargeMin;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//import static miniMaxSum.MiniMaxSum.*;

class MiniMaxSumTest {

    @Test
    void miniMaxSumTest() {
        Long[] arr = {Long.valueOf(396285104), Long.valueOf(573261094), Long.valueOf(759641832), Long.valueOf(819230764), Long.valueOf(364801279)};
        List<Long> arrList = Arrays.asList(arr);

        List<Integer> integerList = arrList.stream()
                .map(Long::intValue)
                .collect(Collectors.toList());
//        miniMaxSum(integerList);
//        miniMaxSumAlternativeWay(integerList);
//        miniMaxSumAlternativeWay2(integerList);
    }
}