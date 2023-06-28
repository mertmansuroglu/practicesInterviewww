package warmUpQuestions.problemWithNumbers;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        int a = rd.nextInt();

        if (a % 2 == 0) {
            System.out.println("even");
        } else
            System.out.println("odd");
    }
}
