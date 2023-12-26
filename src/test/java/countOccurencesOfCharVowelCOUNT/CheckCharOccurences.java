package countOccurencesOfCharVowelCOUNT;

import com.google.common.base.CharMatcher;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
// TODO: 12/25/2023  FINISHED
public class CheckCharOccurences {

    @Test
    public void checkCharOccurences() {
        HashMap<String, Integer> map = new HashMap<>();
        String str = "I love coding";
        char[] ch = str.toCharArray();
        int countI = 0;
        int countO = 0;
        for (int i = 0; i < ch.length; i++) {
            if (Character.valueOf(ch[i]) == 'o') {
                countO++;
            } else if (Character.valueOf(ch[i]) == 'I') {
                countI++;
            }
        }
        map.put(String.valueOf('I'), countI);
        map.put(String.valueOf('o'), countO);
        System.out.println(map);
//          return map;
    }

    @Test
    public void checkWovelOccurences() {
        HashMap<String, Integer> map = new HashMap<>();
        String str = "i love coding";
        char[] ch = str.toCharArray();
        int countUnsuz = 0;
        int countWovel = 0;
        for (int i = 0; i < ch.length; i++) {
            if (Character.valueOf(ch[i]) == 'o' || Character.toString(ch[i]).equalsIgnoreCase("e") || Character.toString(ch[i]).equalsIgnoreCase("a") || Character.toString(ch[i]).equalsIgnoreCase("u") || Character.toString(ch[i]).equalsIgnoreCase("i")) {
                countWovel++;
            } else if (!Character.toString(ch[i]).equalsIgnoreCase(" ")) {
                countUnsuz++;

            }
        }
        map.put("unlu sayisi", countWovel);
        map.put("unsuz sayisi", countUnsuz);
        System.out.println(map);
    }

    //USING GOOGLE GUAVA IS AMAZING!
    @Test
    public void checkWovelOccurencesGuava() {
        String test = "i love coding";
        int voWelCount = CharMatcher.anyOf("aeiouAEIOU").countIn(test);
        System.out.println(voWelCount);
    }
}




