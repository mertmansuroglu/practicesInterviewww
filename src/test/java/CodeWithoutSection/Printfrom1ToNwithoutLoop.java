package CodeWithoutSection;

public class Printfrom1ToNwithoutLoop {


    // TODO: 12/25/2023 FINISHED!!!!
    public static void main(String[] args) {
        printNumbers1TOn(10);
        System.out.println("/////////////////");
        printNumbersFIRSTtoLAST(2,5);

    }
    private static void printNumbers1TOn(int n){
//we have recursive case+stopping criterion+unintenional case!!!!
        if(n>0)
        {
            printNumbers1TOn(n-1);
            System.out.println(n+" ");
        }
        return;
    }
    private static void printNumbersFIRSTtoLAST(int initial,int last){
  //
        if(initial<=last)
        {
            System.out.println(initial+" ");
            printNumbersFIRSTtoLAST(initial+1,last);
        }
        return;
    }

}
