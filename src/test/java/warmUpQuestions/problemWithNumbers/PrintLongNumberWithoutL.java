package warmUpQuestions.problemWithNumbers;

public class PrintLongNumberWithoutL {
    public static void main(String[] args) {

        /**
         * here, when we want to have long number wiuthout l?
         * below the main result should be 3,153,600,000 but when we printed it came as 1471228928??
         * 315360000 --> this is 36 bits(1111010101010110....) and thats why we put l to the end!!
         * because its crossed to maximum limit of 32 bit integer( 2,147,483,647)!!!
         * so, java will delete 4 bits at the end and convert 36 bit to 32 bit integer to decimal and show the result 1471228928
         * if you want to have real result, we need to add l to the end@
         */
        long longNumberWithoutL = 1000 * 60 * 60 * 24 * 365;
        long longNumberWithL = 1000 * 60 * 60 * 24 * 365l;
        System.out.println(longNumberWithoutL);
        System.out.println(longNumberWithL);
    }
}
