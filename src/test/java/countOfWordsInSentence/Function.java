package countOfWordsInSentence;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Function {
    // TODO: 12/25/2023 FINISHED
    @Test
    public void countWord() {
        String str = "I am learning learning java java";
        Assert.assertEquals((isPrime(str,"java")),2);
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

    public static int isPrime(String t,String c)
    {
        String[] arr= t.split(" ");
        return  Collections.frequency(Arrays.asList(arr),c);
    }

       }

