package reverseOnlyStringsInSentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Functional {
    public static void main(String[] args) {
        String s = "test12pop90java";
        System.out.println(testReverseString2(s)); ;
    }

    public static StringBuilder testReverseStringStream(String s)
    {
        String regexDigit = "\\d+";
        //above \d represents any digit and + means one or more occurences
        String texts = s.replaceAll(regexDigit, " ");
        // Pattern'ı derle
        Pattern pattern = Pattern.compile(regexDigit);
        // Matcher'ı oluştur ve giriş string'i ile eşleştir
        Matcher matcher = pattern.matcher(s);
        List<String> list = new ArrayList<>();
        // Sayıları biriktir
        while (matcher.find()) {
            String number = matcher.group();
            list.add(number);
        }
        // Ayırılan kelimeleri ters çevir
        String[] words = s.split("\\d+");
        StringBuilder reversedWords = new StringBuilder();
        for (String word : words) {
            reversedWords.append(reverseString(word));
        }

        // Sayıları ekleyerek sonucu oluştur
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.max(words.length, list.size()); i++) {
            //Inside the loop, it checks if i is less than the length of the words array.
            // If true, it means there are still words to append. It appends the i-th word from the words array to the result StringBuilder.
            if (i < words.length) {
                result.append(words[i]);
            }
            //Similarly, it checks if i is less than the size of the list. If true, it means there are still numbers to append.
            // It appends the i-th element from the list to the result StringBuilder.
            if (i < list.size()) {
                result.append(list.get(i));
            }
        }
       return result;
    }

    public static StringBuilder testReverseString2(String s)
    {
        String regexDigit = "\\d+";
        //above \d represents any digit and + means one or more occurences
        String texts = s.replaceAll(regexDigit, " ");
        // Pattern'ı derle
        Pattern pattern = Pattern.compile(regexDigit);
        // Matcher'ı oluştur ve giriş string'i ile eşleştir
        Matcher matcher = pattern.matcher(s);
        List<String> list = new ArrayList<>();
        // Sayıları biriktir
        while (matcher.find()) {
            String number = matcher.group();
            list.add(number);
        }
        // Ayırılan kelimeleri ters çevir ve sayılarla birleştir
       //s.split("\\d+") The result is an array of non-numeric parts.
        //The map function is used to apply the reverseString method to each element of the stream. The reverseString method takes a string and returns its reversed version.
//        The map function is again used to concatenate each reversed word with the corresponding numeric part.
//        The (list.isEmpty() ? "" : list.remove(0)) part ensures that a numeric part is added only if the list is not empty.
//        It uses the ternary operator to check if the list is empty and, if not, removes the first element from the list.
        String result = Arrays.stream(s.split("\\d+"))
                .map(Functional::reverseString)
                .map(word -> word + (list.isEmpty() ? "" : list.remove(0)))
                .collect(Collectors.joining());

        System.out.println(result);
        return null;
    }
    // Helper method to reverse a string
    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
