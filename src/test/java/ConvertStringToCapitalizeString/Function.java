package ConvertStringToCapitalizeString;

public class Function {
    public static void main(String[] args) {
        String s="mert mansur ovski";
       String[] newS= s.split("\\s");
        String empty = "";
        for(int i=0;i<newS.length;i++)
        {
           String first= newS[i].substring(0,1).toUpperCase();
           String rest= newS[i].substring(1);
           empty=empty+first+rest;
        }
        System.out.println(empty.trim());
    }
}
