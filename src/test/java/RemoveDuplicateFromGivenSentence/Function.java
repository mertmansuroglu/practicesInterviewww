package RemoveDuplicateFromGivenSentence;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Function {
    // TODO: 12/25/2023 pARTIALLY FINISHED!!!!
    public static void main(String[] args) {
        int[] arr = {1,2,2,5,6,4,5,3,5,6};
        removeDuplicatedElementsWithSet3(arr);

    }

    public static void removeDuplicatedElementsWithSet(){
        String name= "hello I hello love you";
       String[] names= name.split("\\s");
      String newS="";
        Set<String> set= new LinkedHashSet<>();
        int count=0;
        for(int i=0;i<names.length;i++){
            if(!set.add(names[i])){
                System.out.println(names[i]);
            }
        }
        for(String s:set){
            newS=newS+s+" ";
        }
        System.out.println(newS);

    }

    public static void removeDuplicatedElementsWithSet2() {
        // Set the path to your ChromeDriver executable
        int[] arr= {1,1,3,5,6,7,8,8,9};
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        Object[] neww=  set.toArray();
        for(int i=0;i<neww.length;i++)
        {
            System.out.println(neww[i]);
        }
    }
    public static int[] getUniqueArray(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            set.add(value);
        }
        // Set'ten alınan benzersiz elemanları içeren bir Integer dizisi
        Integer[] uniqueArray = set.toArray(new Integer[0]);

        // Integer dizisini int dizisine dönüştürme
        int[] result = new int[uniqueArray.length];
        for (int i = 0; i < uniqueArray.length; i++) {
            result[i] = uniqueArray[i];
        }

        return result;
    }

    public static void removeDuplicatedElementsWithSet3( int[] arr) {
    int[] newAr= Arrays.stream(arr).distinct().toArray();
        for(int s:newAr){
            System.out.print(s);
        }
    }
}
