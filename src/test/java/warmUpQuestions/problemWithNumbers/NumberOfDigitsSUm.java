package warmUpQuestions.problemWithNumbers;

import org.junit.jupiter.api.Test;

public class NumberOfDigitsSUm {
    public static void main(String[] args) {
        int a = 134123;
        char[] digits = Integer.toString(a).toCharArray().clone();
        System.out.println(digits.length);
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Integer.parseInt(Character.valueOf(digits[i]).toString());
        }
        System.out.println(sum);
    }

    @Test
    public void testAlternative() {
        int num = 124535634;
        int count = 0;

        while (num != 0) {
            num = num / 10;
            ++count;
        }
        System.out.println(count);
    }

    @Test
    public void testAlternative2() {
        int num = 124535634;
        int count = 0;
        System.out.println(String.valueOf(num).length());
    }
}
