package warmUpQuestions.problemWithNumbers;

public class FactorialFind {
    public static void main(String[] args) {
        int number = 0;
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        System.out.println(fact);
        System.out.println(fact(4));
    }
    //eger fact(n) yaparsak stackoverflowa(lifo) doner hic bitmez run
    public static int fact(int n){
        if(n==1){
            return n;
        }
        return (n)*fact(n-1);
    }
}
