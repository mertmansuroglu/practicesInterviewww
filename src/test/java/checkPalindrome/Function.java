package checkPalindrome;

import java.util.Objects;
import java.util.stream.IntStream;

// TODO: 12/25/2023 FINISHED!!!!

//  String s= "malayalam";  reverside ayniysa
public class Function {
    public static boolean palindrome(String number) {
        char[] ch = String.valueOf(number).toCharArray();
        char[] newCh = new char[ch.length];
        int b = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            newCh[b] = ch[i];
            b++;
        }
        String reverse = String.valueOf(newCh);
        return reverse.equals(number);
    }
    

    public static void main(String[] args)
    {
        String s= "malayalam";
        System.out.println(isPalindromeStream(s));
//        isPalindromeStream(s);
    }



    public static boolean isPalindrome(String s)
    {

        String reversed= new StringBuilder(s).toString();
        return Objects.equals(s, reversed);
    }


    public static boolean isPalindromeStream(String s)
    {
//IntStream.range(0, s.length() / 2) generates indices from 0 to half of the string length.
        //noneMatch is used to check if there are no indices where the characters at those indices do not match.
        String lowerCase=s.toLowerCase();
        return IntStream.range(0,s.length()/2).noneMatch(i->lowerCase.charAt(i) !=lowerCase.charAt(s.length()-1-i));
    }


}
