package RemoveDuplicateFromGivenSentence;

import java.util.*;

public class Function {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        removeDuplicatedElementsWithSet();

    }

    public static void removeDuplicatedElementsWithSet(){
        String name= "hello I hello love you";
       String[] names= name.split("\\s");
      String newS="";
        Set<String> set= new LinkedHashSet<>();
        int count=0;
        for(int i=0;i<names.length;i++){
            if(set.add(names[i])==false){
                System.out.println(names[i]);
            }
        }
        for(String s:set){
            newS=newS+s+" ";
        }
        System.out.println(newS);

    }
}
