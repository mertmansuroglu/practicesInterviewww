package checkPrimeNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeNumberTest {

    @Test
    void primeNumberTest() {
        int a = 37;
        Assertions.assertTrue(PrimeNumber.primeNumber(a));
    }
}