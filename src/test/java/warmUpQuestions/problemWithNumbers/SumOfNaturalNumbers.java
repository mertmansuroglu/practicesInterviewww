package warmUpQuestions.problemWithNumbers;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        int num = 100;
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
        int sum2 = 0;
        int k = 1;
        while (k <= num) {
            sum2 += k;
            k++;
        }
        System.out.println(sum2);
    }
}
