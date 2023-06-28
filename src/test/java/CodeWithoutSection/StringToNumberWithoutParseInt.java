package CodeWithoutSection;

public class StringToNumberWithoutParseInt {

    public static void main(String[] args) {
        String s = "123";
        // Initialize a variable
        int num = 0;
        int n = s.length();

        // Iterate till length of the string
        for(int i = 0; i < n; i++)

            // Subtract 48 from the current digit
            num = num * 10 + ((int)s.charAt(i) - 48);

        // Print the answer
        System.out.print(num);
    }
    }

//Approach: The idea is to use the ASCII value of the digits from 0 to 9 start from 48 – 57.
//Therefore, to change the numeric character to an integer subtract 48 from the ASCII value of the character will give the corresponding digit for the given character.