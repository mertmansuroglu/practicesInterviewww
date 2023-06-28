package warmUpQuestions.stackOverFlowError;

public class StackOverFlowError {
    /**
     * First it allocates for  the memory allocation for all these 4 methods
     * ande memory allocation will be same reverse order. I t will kind of create a stack in the memory
     */

    public static void main(String[] args) {
        m1(null);
    }


    public static void m1(String a) {
        m2(a);
    }

    public static void m2(String a) {
        m3(a);
    }

    public static void m3(String a) {

    }

}

