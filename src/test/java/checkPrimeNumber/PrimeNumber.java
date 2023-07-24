package checkPrimeNumber;

import java.util.stream.IntStream;

public class PrimeNumber {

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
            if (number <= 1) {
                return false;
            }

            return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                    .noneMatch(i -> number % i == 0);
        }
    }


