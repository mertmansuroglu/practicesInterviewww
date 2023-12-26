package CodeWithoutSection;

import net.minidev.json.JSONUtil;

public class PrintHelloWithoutSemicolon {
//    public static void main(String[] args) {
//        if(System.out.printf("Hellow world"+"\n")==null){
//
//        }
//        if(System.out.append("Hellow world"+"\n")==null){
//
//        }
//    }


    public static void main(String[] args) {
        int a=5;

        System.out.println( pr(a));
    }


    public static int pr(int a)
    {
        if(a<1)
        {
           return 1;
        }
        return pr(a-1)*a;
    }


}

