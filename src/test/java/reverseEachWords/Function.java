package reverseEachWords;

public class Function {
    // TODO: 12/25/2023 partially FINISHED
    public static void main(String[] args) {
        String str= "how are you";
        System.out.println(   reverseWordss(str));
     ;

    }
    public static void reverseWords(String str){
        String newS= "";
        String[] arr=   str.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            for(int a=arr[i].length()-1;a>=0;a--)
            {
                newS+= arr[i].charAt(a);
            }
            newS+=" ";
        }
        System.out.println(newS);
    }

    public static String reverseWordss(String str){
        String newS= "";
        String[] arr=   str.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            String rev= new StringBuilder(arr[i]).reverse().toString();
            newS+=" "+rev;
        }
        return newS.trim();


    }
}
