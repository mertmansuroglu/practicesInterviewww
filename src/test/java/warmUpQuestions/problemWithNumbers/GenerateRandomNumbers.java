package warmUpQuestions.problemWithNumbers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumbers {
    /**
     * 1.Random class
     * 2.Math.random
     * 3.Thread local Random
     */
    public static void main(String[] args) {


        //Random class
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(rd.nextInt());
        }
        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(rd.nextInt(20)); //0 to 20 random numbers
        }
        System.out.println("-----------------------------------");

        //Math.random  0-1 arasinda deger atar ama 10 la carparsak 1 9 arasinda deger gelir!
        for (int i = 0; i < 5; i++) {
            System.out.println((int) (Math.random() * 10));
        }
        System.out.println("-----------------------------------");
        //Thread local Random
        for (int i = 0; i < 5; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt());
        }
        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 20));
        }
    }
}
