package warmUpQuestions.problemWithNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareTwoInteger_DivideBy {


    /**
     * we can compare primitive references with  == for primitives and it does not have problem with caching
     * but, when we compare two integers with Object reference, from -128 to 128 these values are valid! it happens Integer caching!!!!
     */

    @Test
    public void testTwoInteger() {
        Integer num1 = 100;
        Integer num2 = 100;
        Integer num3 = 130;
        Integer num4 = 130;
        Assertions.assertTrue(num1 == num2);
        Assertions.assertTrue(num3 == num4);
    }

    /**
     * What will be the output when you divid a number by zero?
     * Number= Integer,Double,Floar
     * java.lang.ArithmeticException: / by zero   for integers!!!! but infinity for double.float!
     */
    @Test()
    public void testDividebyZero() {
        int num1 = 100;
        double num2 = 9.0;
        float num3 = 12.33f;
        //below will throw java.lang.ArithmeticException: / by zero
        System.out.println(num1 / 0);
        System.out.println(0 / 0);
        //below will give infinity !!!! if we divide double/float with zero
        System.out.println(num3 / 0);
        System.out.println(num2 / 0);
    }

}
