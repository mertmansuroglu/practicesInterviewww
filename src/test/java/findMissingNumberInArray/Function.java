package findMissingNumberInArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Function {
    public static void main(String[] args) {
        //iki cesit cozum mumkun
        //cikarip ve cikarmadan toplami cikar
        // n*n+1/2 yap genel toplamdan cikar
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int sum = 0;
        int missedSum = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            missedSum += arr[i];
        }
        for (int i = 0; i <= arr[arr.length - 1]; i++) {
            sum += i;
        }
        System.out.println(Math.abs(missedSum - sum));
    }

    public static void findMissing(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int expected=arr[arr.length-1]*((arr[arr.length-1])+1);
        int last=expected/2;
        System.out.println(Math.abs(last-sum));
    }
}



