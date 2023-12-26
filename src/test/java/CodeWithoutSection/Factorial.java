package CodeWithoutSection;

public class Factorial {
    // TODO: 12/25/2023 FINISHED
    public static void main(String[] args) {
        int a=5;
        System.out.println(fact2(a));
        System.out.println(fact(a));

    }
    public static int fact(int b){
        //we have recursive case+stopping criterion+unintenional case!!!!
      if(b<=1){
          return 1;
      }
      return fact(b-1)*b;
    }

    public static int fact2(int c){
      int fact=1;
        for(int i=c;i>=1;i--){
            fact*=(i);
        }
        return fact;
    }
}
