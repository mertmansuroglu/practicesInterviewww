package reverseEachWords;

public class Function {

    public static void main(String[] args) {
        String str= "how are you";
        reverseWords(str);

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
}
