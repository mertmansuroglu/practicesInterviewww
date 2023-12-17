package ConvertStringToCapitalizeString;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Function {
    public static void main(String[] args) {
        String s="mert mansur ovski";
       String[] newS= s.split("\\s");
        String empty = "";
        for(int i=0;i<newS.length;i++)
        {
           String first= newS[i].substring(0,1).toUpperCase();
           String rest= newS[i].substring(1);
           empty=empty+first+rest;
        }
        System.out.println(empty.trim());
    }

    public static String convertToCapitalizeString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }

        // Split the input string into individual words
        String[] words = inputString.split("\\s+");

        // Capitalize the first letter of each word using streams
        String capitalizedString = Arrays.stream(words)
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));

        return capitalizedString;
    }
}

