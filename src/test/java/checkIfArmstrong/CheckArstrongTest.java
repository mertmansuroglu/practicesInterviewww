package checkIfArmstrong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckArstrongTest {

    @Test
    void checkArmstrongTest() {
        int number = 371;

        Assertions.assertTrue(CheckArstrong.checkArmstrong(number));
        Assertions.assertTrue(CheckArstrong.checkArmstrongAlternative(number));
        Assertions.assertTrue(CheckArstrong.checkArmstrongAlternative2(number));
    }
}