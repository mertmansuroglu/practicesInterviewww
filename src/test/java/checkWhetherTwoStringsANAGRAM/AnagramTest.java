package checkWhetherTwoStringsANAGRAM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static checkWhetherTwoStringsANAGRAM.Anagram.checkAnagramAlter;

public class AnagramTest {

    @Test
    public void testAnagram() {
        String a = "CAt  ";
        String b = "aCT  ";
//        Assertions.assertTrue(checkAnagram(a, b));
        Assertions.assertTrue(checkAnagramAlter(a, b));

        String[] arr= a.split("");
        List<String> list =Arrays.asList(arr);
        TreeSet<String> Set= new TreeSet<>(Arrays.asList(arr));
    }
    public static void main(String[] args)
    {
        String s= "listen";
        String s1= "silent";
        System.out.println(isAnagram(s,s1));

    }

    public  static boolean isAnagram(String s, String s1)
    {
        String[] arr= s.split("");
        List<String> list =Arrays.asList(arr);
        String[] arr2= s1.split("");
        TreeSet<String> Set= new TreeSet<>(Arrays.asList(arr));
        TreeSet<String> Set2= new TreeSet<>(Arrays.asList(arr2));
        return Objects.equals(Set, Set2);
    }
}
