package warmUpQuestions.problemWithNumbers;

import org.junit.jupiter.api.Test;

public class PowerOfNumber {
    public static void main(String[] args) {
        int base = 3;
        int us = 2;
        int result = 1;
        for (int i = 0; i < us; i++) {
            result *= base;
        }
        System.out.println(result);
        System.out.println((int) Math.pow(base, us));
    }

    @Test
    public void testAlternative() {
        int base = 3;
        int us = 2;
        long result = 1;
        while (us != 0) {
            result *= base;
            --us;
        }
        System.out.println(result);
    }

}
