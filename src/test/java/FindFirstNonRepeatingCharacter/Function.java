package FindFirstNonRepeatingCharacter;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Function {
    // TODO: 12/25/2023 NOT FINISHED!!!!!!!!!!!!!!!!!!1
    //LinkedHashMap!!!!!!!!
    @Test
    public void countWord() {
        String str = "aswiss";
        checkWordWithSort(str);
    }


    public String checkWordWithSort(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!(map.containsKey(arr[i]))) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], (map.get(arr[i]) + 1));
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
               return entry.getKey().toString();
            }
        }
        return null;
    }

}

