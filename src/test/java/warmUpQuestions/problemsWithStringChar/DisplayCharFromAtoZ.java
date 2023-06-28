package warmUpQuestions.problemsWithStringChar;

import org.junit.jupiter.api.Test;

public class DisplayCharFromAtoZ {

    @Test
    public void displayChar() {
        for (char c = 'A'; c <= 'z'; c++) {
            System.out.println(c);
        }
    }
}
