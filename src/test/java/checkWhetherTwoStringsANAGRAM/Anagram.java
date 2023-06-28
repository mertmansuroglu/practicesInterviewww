package checkWhetherTwoStringsANAGRAM;

import java.util.Arrays;

public class Anagram {


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
}
