package RemoveSpecailStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    public static void main(String[] args) {
        String a = "!#!%@^&$^*U&mert";
        //asagida direk replace all dedik ve junklari sildik
            findWithoutSpecial(a);
            removeSpecial(a);

    }
    public static void findWithoutSpecial(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String result = matcher.group();
            System.out.print(result);
            //asagidaki regex e uyanl
        }
    }
    public static void removeSpecial(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println("\n" + s);
        }
    }

