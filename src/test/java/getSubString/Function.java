package getSubString;

public class Function {

    public static void main(String[] args) {
        String str = "www.google.com";
        String target=str.substring(0,3);
        String lastcom=str.substring(str.length()-3,str.length());
        System.out.println(target);
        System.out.println(lastcom);

    }
}
