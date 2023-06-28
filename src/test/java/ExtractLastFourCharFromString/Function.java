package ExtractLastFourCharFromString;

public class Function {

    public static void main(String[] args) {
        String str="www.google.com";

       String neww= str.substring((str.length()-4),str.length());
        System.out.println(neww);

    }
        }
