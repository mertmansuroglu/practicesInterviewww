package fibonacciSeriesFibonacci;

import java.util.Arrays;

public class Fibonacci {


    public int fibonacciSum(int n) {
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
        int firsTerm = 0;
        int secondTerm = 1;
        int[] arr = new int[n];
        System.out.println("fibonacci series until " + n + " terms");
        //
        for (int i = 0; i < n; i++) {
            arr[i] = firsTerm;
            int sum = firsTerm + secondTerm;
            firsTerm = secondTerm;
            secondTerm = sum;
        }
        return Arrays.stream(arr).sum();
    }

    public int fibonacciRecursive(int n) {
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 0) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2) + 1;
    }
    //
}
