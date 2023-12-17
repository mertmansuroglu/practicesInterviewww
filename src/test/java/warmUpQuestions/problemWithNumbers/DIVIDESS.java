package warmUpQuestions.problemWithNumbers;


public class DIVIDESS {

    public static void main(String[] args) {

//        This is a common issue with floating-point arithmetic due to the limitations of representing certain decimal values precisely in binary.
//        It's important to be aware of this behavior when working with floating-point numbers in computer programs.
        //This expression involves adding the decimal numbers 0.1 and 0.2.
        // In the binary floating-point representation used by computers (such as the IEEE 754 standard for double-precision floating-point numbers),
        // not all decimal numbers can be precisely represented.
        System.out.println(0.1+0.2);
//0.30000000000000004

        System.out.println(0.1+0.4);
//0.5


        //This expression involves dividing zero (0.0) by zero (0.0). According to the IEEE 754 floating-point standard, dividing zero by zero yields NaN:
        System.out.println(0.0/0.0);

        //NaN

        ///This expression involves dividing a non-zero number (9.0) by zero (0.0).
        // According to the IEEE 754 floating-point standard, dividing a non-zero number by zero yields positive infinity:
        System.out.println(9.0/0.0);
    }
}
