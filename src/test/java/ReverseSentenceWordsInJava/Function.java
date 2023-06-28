package ReverseSentenceWordsInJava;

public class Function {

    public static void main(String[] args) {
        String str= "We are learning";
        reverseWords(str);

    }
    public static void reverseWords(String str){
        String newS= "";
        String[] arr=   str.split(" ");
        for(int i=arr.length-1;i>=0;i--)
        {
         newS+=arr[i]+" ";
        }
        System.out.println(newS);
        }
}
