package fibonacciSeriesFibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void fibonacciTest() {
        int[] a = {0, 1, 1, 2, 3};
        Assertions.assertEquals(7, new Fibonacci().fibonacciSum(5));
//        0,1,2,3,5
    }

    @Test
    void fibonacciTestAltern() {

        int b = new Fibonacci().fibonacciRecursive(4);
        System.out.println(b);
//        Assertions.assertArrayEquals(a,new Fibonacci().fibonacci(5));
//        0,1,2,3,5
    }
}