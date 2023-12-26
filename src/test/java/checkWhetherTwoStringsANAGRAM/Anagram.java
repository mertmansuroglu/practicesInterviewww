package checkWhetherTwoStringsANAGRAM;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Anagram {


    // TODO: 12/25/2023 FINISHED!!!!
    public static boolean checkAnagramAlter(String a, String b) {
        String st1 = a.replaceAll("\\s", "").trim();
        String st2 = b.replaceAll("\\s", "").trim();
        if (st1.length() != st2.length()) {
            return false;
        }
        char[] charA = a.toLowerCase().toCharArray();
        char[] charB = b.toLowerCase().toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        return Arrays.equals(charA, charB);
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
