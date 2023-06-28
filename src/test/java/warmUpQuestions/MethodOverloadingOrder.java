package warmUpQuestions;

import org.junit.jupiter.api.Assertions;

public class MethodOverloadingOrder {


    /**
     * method overloading sirasi   1.int 2.long 3.Integer 4.int...
     */
    public static void print(Integer i) {
        System.out.println("integer");
    }

    public static String print(int i) {
        return "int";
    }

    public static void print(long i) {
        System.out.println("long");
    }

    //asagidaki int array analamina gelir
    public static void print(int... i) {
        System.out.println("int arrr");
    }

    public static void main(String[] args) {
        //asagida mesela 10 dedik gitti inti calistirdi once int olmasaydi longu calistiracakti
        print(10);
        Assertions.assertEquals("int", print(10));
    }
}
