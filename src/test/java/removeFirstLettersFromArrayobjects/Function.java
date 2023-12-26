package removeFirstLettersFromArrayobjects;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    // TODO: 12/25/2023  FINISHED!!!!
    public static void main(String[] args) {
        String[] stringArray = {"Apple", "Banana", "Orange", "Grape"};
//        removeFirst(stringArray);
        removeFirst2(stringArray);
    }

        public static void removeFirst(String[] stringArray) {
            // Example array of strings
            // Remove the first letter using a loop
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i].length() > 1) {
                    stringArray[i] = stringArray[i].substring(1);
                } else {
                    // Handle case where the string has only one character or is empty
                    stringArray[i] = "";
                }
            }

            // Print the resulting array
            for (String s : stringArray) {
                System.out.println(s);
            }
        }

    public static void removeFirst2(String[] stringArray) {
        // Example array of strings
        // Remove the first letter using a loop
        System.out.println("/////////");
        stringArray = Arrays.stream(stringArray)
                .map(s -> (s.length() > 1) ? s.substring(1) : "")
                .toArray(String[]::new);

        // Print the resulting array
        Arrays.stream(stringArray).forEach(System.out::println);
    }
    }


