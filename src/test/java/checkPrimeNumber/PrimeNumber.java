package checkPrimeNumber;

import java.util.stream.IntStream;

public class PrimeNumber {
// TODO: 12/25/2023 partially FINISHED!!!!

    //Although 2 is a prime number , this method returns false
    public static boolean primeNumber(int number) {
        for (int i = 1; i <= number; i++) {
            if (i != 1 && i != number) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return number > 0;

    }
     // Replace this with the number you want to check
     public static boolean isPrimeNumber(int number) {
         return IntStream.range(2, number)
                 .noneMatch(i -> number % i == 0);
     }
    }


