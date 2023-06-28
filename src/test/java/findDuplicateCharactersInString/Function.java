package findDuplicateCharactersInString;

import org.apache.logging.log4j.core.appender.rolling.action.ZipCompressAction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Function {


    @Test
    public void countWord() {
        String str = "laptot";
        DuplicatedElementsWithSet();
    }


    public String checkWordWithSort(String str,String word){
        char[] arr= str.toCharArray();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[i+1]){
                return String.valueOf(arr[i]);
            }
      }
        return null;
}

    public void checkWordsWithMap(String str){
        char[] arr= str.toCharArray();
        HashMap<Character,Integer> map= new HashMap<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(!(map.containsKey(arr[i]))){
               map.put(arr[i],1);
            }else{
                map.put(arr[i],(map.get(arr[i])+1));
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
           if(entry.getValue()>1){
               System.out.println(entry.getKey()+"---");
           }
        }

    }
    public void DuplicatedElementsWithSet(){
        String names[]={"java","mert","mert","java"};

        Set<String> set= new HashSet<>();
        int count=0;
        for(int i=0;i<names.length;i++){
            if(set.add(names[i])==false){
                System.out.println(names[i]);
            }
        }
        for(String s:set){
            System.out.println();
        }

    }
}

//