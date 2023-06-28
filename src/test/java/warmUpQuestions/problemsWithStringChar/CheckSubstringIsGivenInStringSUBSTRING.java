package warmUpQuestions.problemsWithStringChar;

public class CheckSubstringIsGivenInStringSUBSTRING {
    public static void main(String[] args) {
        System.out.println(isSubstring("mert mans", "v"));
        System.out.println(isSubstring2("mert mans", "ns"));
        System.out.println(isSubstringRegex("mert mans", "o"));
        System.out.println(isSubstringContains("mert mans", "a"));
    }

    public static boolean isSubstring(String main, String sub) {
        return main.lastIndexOf(sub) >= 0;
    }

    public static boolean isSubstringContains(String main, String sub) {

        return main.contains(sub);
    }

    public static boolean isSubstringRegex(String main, String sub) {

        return main.matches(".*" + sub + ".*");
    }

    public static boolean isSubstring2(String main, String sub) {
        char[] arr = main.toCharArray();
        char[] subArr = sub.toCharArray();
        for (int i = 0; i < subArr.length; i++) {
            for (int a = 0; a < arr.length; a++) {
                if (arr[a] == subArr[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
