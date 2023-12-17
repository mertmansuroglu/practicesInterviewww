package countOfWordsGivenString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;

public class Function {

    @Test
    public void countWord() {
        String str = "I am learning learning java java";
        Assert.assertEquals((checkWord(str,"java")),2);
    }

       public int checkWord(String str,String word){
           String[] arr= str.split(" ");
           HashMap<String,Integer> map= new HashMap<String, Integer>();
           int count=0;
           for(int i=0;i<arr.length;i++) {
               if (!map.containsKey(arr[i])) {
                   map.put(arr[i], 1);
               } else {
                   map.put(arr[i], (map.get(arr[i]) + 1));
               }
           }
           for(String x: map.keySet()){
               System.out.println("The count of word"+x+"="+map.get(x));

           }
           return map.get(word);
       }

       }

