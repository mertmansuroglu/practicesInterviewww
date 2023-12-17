package countOfWordsInSentence;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Functional {

    @Test
    public void countWord() {
        String str = "iiibbbtttr";
        Assert.assertEquals((checkWord2(str,"java")),2);
    }

    public StringBuilder checkWord(String str, String word){
        String[] arr= str.split("");
        System.out.println(arr[0]);
        List<String> list= Arrays.asList(arr);
        LinkedHashSet<String> set=new LinkedHashSet<>(list);
        HashMap<String,Integer> map= new HashMap<String, Integer>();
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i],1);
            }
            else
            {
                map.put(arr[i], (map.get(arr[i]) + 1));
            }
        }
        StringBuilder son = new StringBuilder();
        for (String element : set) {
            if (!element.isEmpty()) {
                son.append(element).append(map.get(element));
            }
        }
        return son;
    }


    public StringBuilder checkWord2(String str, String word){
     LinkedHashSet<Character> uniqueCharacters = new LinkedHashSet<>();
        Map<Character,Integer> characterCountMap= new HashMap<>();
        for(char c:str.toCharArray())
        {
            uniqueCharacters.add(c);
            //characterCountMap.getOrDefault(c, 0): This part retrieves the current count of the character c from the map.
            // If the map doesn't contain the key c, it returns a default value of 0.
            characterCountMap.put(c,characterCountMap.getOrDefault(c,0)+1);
        }
        StringBuilder son = new StringBuilder();
        for (char element : uniqueCharacters) {
                son.append(element).append(characterCountMap.get(element));

        }
        System.out.println(son);
        return son;
    }
}
