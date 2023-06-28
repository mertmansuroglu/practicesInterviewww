package fibonacciSeriesFibonacci.factorsNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorsNumberTest {
    @Test
    public void testFactorOFNumber() {
        int number = 10;
        FactorsNumber.checkArmstrong(number);
        Integer[] arr = {1, 2, 5, 10};
        Assertions.assertArrayEquals(arr, FactorsNumber.checkArmstrong(number));

    }
}
