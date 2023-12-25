package countCharacterOccurencesInString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Function {

    @Test
    public void countWord() {
        String str = "I am learninlg java";
        Assert.assertEquals((checkChar2(str,"l")),2);
    }

    public static void main(String[] args) {
        String str = "javaharten";
        System.out.println(checkChar3(str,"a"));

    }

    public int checkChar(String str,String chr){
        HashMap<String,Integer> map= new HashMap<>();
        int count=0;
       for(int i=0;i<str.length();i++){
           if(!map.containsKey(String.valueOf(str.charAt(i)))){
               map.put(String.valueOf(str.charAt(i)),1);
           }
           else
           {
               map.put(String.valueOf(str.charAt(i)), (map.get(String.valueOf(str.charAt(i)))) + 1);
           }
    }
         return map.get(chr);
}
    public int checkChar2(String str,String chr){
      return (str.length())-(str.replaceAll(chr,"").length());

    }

      public static int checkChar3(String str,String chr){
          List<String> list= Arrays.asList(str.split(""));
          return Collections.frequency(list,chr);


    }
}
