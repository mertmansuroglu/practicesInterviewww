package warmUpQuestions.problemWithNumbers;

public class MinValOfDouble {
    /**
     * Min Val of double
     */
    public static void main(String[] args) {

        //double min value is pozitive number!!
        System.out.println(Double.MIN_VALUE);
        //below min value is double pozitive number so between dsouble and 0.0d min is 0.0
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        //we have double max below
        System.out.println(Double.MAX_VALUE);
    }
}
