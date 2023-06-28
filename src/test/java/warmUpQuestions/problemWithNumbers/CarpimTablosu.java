package warmUpQuestions.problemWithNumbers;

import org.testng.annotations.Test;

public class CarpimTablosu {

    public static void main(String[] args) {
        int num = 5;
        for (int i = 1; i <= num; i++) {
            System.out.println(num + "x" + i + "=" + (num * i));
        }
    }

    @Test
    public void link() {
        String name = "Linkedln";
        String newss = name.toUpperCase();
        System.out.println(name);
        System.out.println(newss);
    }
}
