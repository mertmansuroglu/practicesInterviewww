package reverseNumber;

public class Function {
    public static void main(String[] args) {
        int a=12345;
        char[] arr= Integer.toString(a).toCharArray();
        char[] newArr= new char[arr.length];
        int b=0;
        for(int i=arr.length-1;i>=0;i--){
            newArr[b]+=Character.valueOf(arr[i]);
            b++;
        }
        System.out.println(Integer.parseInt(String.valueOf(newArr)));
    }
}
