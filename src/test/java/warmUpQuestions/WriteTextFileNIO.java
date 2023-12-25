package warmUpQuestions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WriteTextFileNIO {
    public static void main(String[] args) {
        // Specify the path to the text file
        String filePath = "path/to/your/outputfile.txt";

        List<String> content = Arrays.asList("Hello, this is a line of text.", "Another line of text.");

        try {
            Files.write(Paths.get(filePath), content);

            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
