package findSecondHighest;

import java.util.*;
// TODO: 12/25/2023 pARTIALLY FINISHED!!!!
public class Function {
    public static void main(String[] args) {
        //    boxed(): The boxed() method is then applied. When working with streams of primitive data types (like int),
//    you often need to convert them to their corresponding wrapper classes (e.g., Integer) to leverage certain operations that are available for objects.
//    The boxed() method does this conversion by boxing ea
        int[] arr= {100,14,46,47,94,94,100,52,86,36,94,89};
       int high= Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();
        System.out.println(high);

        testAlternative();

    }

    public static void testAlternative() {
        int[] arr = {12, 3, 4, 5, 7, 10};

        // TreeSet ile benzersiz sayıları sakla ve sırala
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();
        for (int num : arr) {
            uniqueNumbers.add(num);
        }

        // Eğer küme boyutu 2 veya daha fazlaysa, ikinci en yüksek sayıyı bul
        if (uniqueNumbers.size() >= 2) {
            uniqueNumbers.pollLast(); // En yükseği çıkar (son elemanı alır)
            int secondHighest = uniqueNumbers.last(); // Son eleman şu anda ikinci en yüksek sayı
            System.out.println("Second Highest: " + secondHighest);
        } else {
            System.out.println("Array does not have a second highest element.");
        }
    }


}
//Create a method to find the second-highest number in an array: {100,14,46,47,94,94,100,52,86,36,94,89}