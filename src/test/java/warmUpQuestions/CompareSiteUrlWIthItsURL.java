package warmUpQuestions;

import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import java.net.URL;

public class CompareSiteUrlWIthItsURL {
    /**
     * compare site url with its ip address
     * abc.com ----> 89.90.98.101 ikisi ayni anlama gelir cunku
     */
    public static void main(String[] args) {

        try {
            System.out.println(new URL("https://app.hubspot.com").equals(new URL("https://104.19.155.83")));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            Assertions.assertEquals(new URL("https://app.hubspot.com"), new URL("https://104.19.155.83"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
