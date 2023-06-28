package warmUpQuestions.problemsWithStringChar;

public class EscapeSpecialCharacters {
    public static void main(String[] args) {
        System.out.println("/\"hello\"/");
        System.out.println("\"hello\"");
        System.out.println("/'hello'/");
        System.out.println(" I love \"java\" and \"programming\"");
        System.out.println("'I love \"java\" and \"programming\"'");
        String name = "mert";
        //first put single quote then +var name  then double quote
        //cunku double quote icerisine single quote koyacaz ama bizim var double quote cunku string
        String xpath = "//input[@id='" + name + "']";
        //input[@id='mert']

    }

}
