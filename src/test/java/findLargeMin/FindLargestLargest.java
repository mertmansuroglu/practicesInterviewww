package findLargeMin;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLargestLargest {


    @Test
    public void testLarge() {

        int[] ar = {1, 5, 7};
        int large = 0;
        for (int i = 0; i < ar.length; i++) {
            if (large < ar[i]) {
                large = ar[i];
            }
        }
        System.out.println(large);
    }

    @Test
    public void testLargeAlternative() {

        List<Integer> list = Arrays.asList(1, 5, 7);
        System.out.println(Collections.max(list));

    }

    @Test
    public void testLargeAlternative2() {

        List<Integer> list = Arrays.asList(1, 5, 7);
        System.out.println(list.stream().max(Comparator.naturalOrder()).get());

    }
}
