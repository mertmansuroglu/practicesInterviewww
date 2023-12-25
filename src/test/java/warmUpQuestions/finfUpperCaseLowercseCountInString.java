package warmUpQuestions;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class finfUpperCaseLowercseCountInString {
    @Test
    public void testFindUpperLower() {
        String input = "Hello World";
        HashMap<String, Integer> result = finfUpperCaseLowercseCountInString.findUpperLower(input);

        assertEquals(Optional.of(2), result.get("UPPER c"));
        assertEquals(Optional.of(8), result.get("lower c"));
    }

    @Test
    public void testFindUpperLowerWithEmptyString() {
        String input = "";
        HashMap<String, Integer> result = finfUpperCaseLowercseCountInString.findUpperLower(input);

        assertEquals(Optional.of(0), result.get("UPPER c"));
        assertEquals(Optional.of(0), result.get("lower c"));
    }

    @Test
    public void testFindUpperLowerWithNumbers() {
        String input = "AbCdEf123";
        HashMap<String, Integer> result = finfUpperCaseLowercseCountInString.findUpperLower(input);

        assertEquals(Optional.of(3), result.get("UPPER c"));
        assertEquals(Optional.of(3), result.get("lower c"));
    }
    public static HashMap<String,Integer> findUpperLower(String s) {
        int upperCount = 0;
        int lowerCount = 0;
        HashMap<String, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])&&!Character.isSpaceChar(arr[i])) {
                lowerCount++;
            }
            if (Character.isUpperCase(arr[i])&&!Character.isSpaceChar(arr[i])) {
                upperCount++;
            }

            map.put("lower c", lowerCount);
            map.put("UPPER c", upperCount);

        }
        return map;
    }
}
