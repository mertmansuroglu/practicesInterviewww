package checkPrimeNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static checkPrimeNumber.PrimeNumber.isPrimeNumber;

class PrimeNumberTest {

    @Test
    void primeNumberTest() {
        int a = 37;
        Assertions.assertTrue(PrimeNumber.primeNumber(a));
    }

    @Test
    void primeNumberTest2() {
        int number = 37;
        boolean isPrime = isPrimeNumber(number);

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}