package warmUpQuestions.problemsWithStringChar;

public class RemoveWhiteSpacesInString {
    public static void main(String[] args) {
        String s = "i love mert   but you are ass hole   really?";
        String newS = s.replaceAll(" ", "");
        String newsS = s.replaceAll("\\s", "");
        System.out.println(newS);
        System.out.println(newsS);
        String str = "    Selenium        is awesome   ";
//asagifaki bosluklari zaten arrayde null gorunecegi icin wordleri ekler
        String[] strArry = str.split("\\s");
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < strArry.length; i++) {
            bf.append(strArry[i].trim());
        }
        System.out.println(bf);
    }
}
