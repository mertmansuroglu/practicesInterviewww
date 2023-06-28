package checkPalindrome;

import java.util.Random;

public class testt {
    public static void main(String[] args) {
        Random rd= new Random();
        int b= rd.nextInt();
        for(int i=1;i<=5;i++){
            System.out.println(b);
            System.out.println("/////////////");
            System.out.println(Math.random()*100);
        }

    }
    public static void print(int n){
       System.out.println("mert");
        if(n>1)
        {
            print(n-1);
        }
        return;
    }

    public static void printReplace(){
        String name ="Mert";
        String s="i";
       s= s.replaceAll("i","iiiiiiiiii");
        s=  s.replaceAll("i","iiiiiiiiii");
        s=  s.replaceAll("i","iiiiiiiiii");
        s=   s.replaceAll("i","\n"+name);
        System.out.println(s);
        Random rd= new Random();
       int b= rd.nextInt();
    }
}
