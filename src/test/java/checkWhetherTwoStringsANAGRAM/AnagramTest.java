package checkWhetherTwoStringsANAGRAM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static checkWhetherTwoStringsANAGRAM.Anagram.checkAnagramAlter;

public class AnagramTest {

    @Test
    public void testAnagram() {
        String a = "CAt  ";
        String b = "aCT  ";
//        Assertions.assertTrue(checkAnagram(a, b));
        Assertions.assertTrue(checkAnagramAlter(a, b));
    }
}
