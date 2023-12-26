package CodeWithoutSection;

public class PrintName1000TimeWithoutLoop {
    // TODO: 12/25/2023 PARTIALLY FINISHED
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


    public static void print(int n){
        System.out.println("mert");
        if(n>1)
        {
            print(n-1);
        }
        return;
    }

}
