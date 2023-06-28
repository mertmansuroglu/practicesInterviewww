package swapTwoNumbers;

public class Function {

    public static void main(String[] args) {
        int a=10;
                int b=20;
        int temp;
        temp=a;
        a=b;
        b=temp;
        System.out.println(a+""+b);
    }

    public void withoutThirdVar()
    {
        int x=5;
        int y=10;

        x=x+y;//15
        y=x-y;//5
        x=x-y;
        System.out.println(x+","+y);
    }

    public void withoutThirdVar2()
    {
        int x=5;
        int y=10;

        x=x*y;//15
        y=x/y;//5
        x=x/y;
        System.out.println(x+","+y);
    }
}
