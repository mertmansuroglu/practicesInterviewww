package checkPrimeNumber;

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


}
