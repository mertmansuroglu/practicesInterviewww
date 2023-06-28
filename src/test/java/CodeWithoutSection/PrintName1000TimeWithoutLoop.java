package CodeWithoutSection;

public class PrintName1000TimeWithoutLoop {
    public static void main(String[] args) {
        String name = "hello world";
        String s = "i";
        s = s.replaceAll("i", "iiiiiiiiii");
        s = s.replaceAll("i", "iiiiiiiiii");
        s = s.replaceAll("i", "iiiiiiiiii");
        s = s.replaceAll("i", name + "\n");
        System.out.println(s);

//////////// bu tarz recursionla nasil yapiliyor ona bakacaksin
    }
}
