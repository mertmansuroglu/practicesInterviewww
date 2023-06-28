package checkIfArmstrong;

import java.util.ArrayList;
import java.util.List;

public class CheckArstrong {

    public static boolean checkArmstrong(int number) {
        char[] ch = String.valueOf(number).toCharArray();
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            sum += ((int) Math.pow(Integer.parseInt(String.valueOf(ch[i])), ch.length));
        }
        return sum == number;
    }

    public static boolean checkArmstrongAlternative(int num) {
        List<Integer> arr = new ArrayList<>();
        int yedek = num;
        while (num != 0) {
            int n = num % 10;
            arr.add(n);
            num = num / 10;

        }
        int sum = arr.stream().mapToInt(N -> (int) Math.pow(N, arr.size())).sum();
        return sum == yedek;
    }

    public static boolean checkArmstrongAlternative2(int num) {

        int yedek = num;
        int result = 0;
        int lentgh = String.valueOf(num).length();
        while (num != 0) {
            int n = num % 10;
            result += (int) Math.pow(n, lentgh);
            num = num / 10;

        }
        return result == yedek;
    }

}
