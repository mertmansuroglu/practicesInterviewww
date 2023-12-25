package warmUpQuestions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//Certainly! Another approach for reading and writing text files in Java is to use the java.nio.file package,
// which provides more modern and flexible file I/O operations.
// The Files class in this package simplifies the process. Here's an example:
public class ReadTextFileNIO {
    public static void main(String[] args) {
        // Specify the path to the text file
        String filePath = "path/to/your/textfile.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
