package ReverseString;

import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Function {

    public static void main(String[] args) {
        String str = "mert";
        new Function().checkReverse(str);
    }
    public void checkReverse(String str) {
        char[] arr = str.toCharArray();
        String neww="";
       for(int i=arr.length-1;i>=0;i--){
          neww+=String.valueOf(arr[i]);
       }
        System.out.println(neww);
    }

    public void checkReversebUFFER(String str) {
       StringBuffer SB= new StringBuffer(str);
       SB.reverse();
        System.out.println(SB);
    }

}
