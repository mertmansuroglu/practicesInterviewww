package checkPalindrome;

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

    public static void main(String[] args) {


        System.out.println(palindrome("malayalam"));
    }


}
