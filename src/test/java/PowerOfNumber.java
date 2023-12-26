//import org.junit.jupiter.api.Test;
//


import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class PowerOfNumber {
    public static void main(String[] args)
    {

        int[] arr = {1,0,2,5,0,4,0,5,3,5,6};
        System.out.println(isPrime(arr));;

    }
    public static List<Integer> isPrime(int[] t) {
        Set<Integer> set= new HashSet<>();
        for (int a : t) {
            set.add(a);
        }
        List<Integer> arrayList = new ArrayList<>(set);
        arrayList.remove(0);
        return arrayList;


    }
}

//    @Test
//    public void testAlternative() {
//        int base = 3;
//        int us = 2;
//        long result = 1;
//        while (us != 0) {
//            result *= base;
//            --us;
//        }
//        System.out.println(result);
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
