package checkPrimeNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static checkPrimeNumber.PrimeNumber.isPrimeNumber;

class PrimeNumberTest {
// Bir sayı, sadece 1 ve kendisi olmak üzere tam olarak iki pozitif bölen içeriyorsa, o sayı asal olarak kabul edilir.
// Başka bir deyişle, asal sayılar yalnızca 1 ve kendisi olmak üzere sadece iki pozitif bölen içeren sayılardır.
//
//Örneğin, 2, 3, 5, 7, 11 gibi sayılar asal sayılardır çünkü sadece 1 ve kendilerine bölünebilirler.
    @Test
    void primeNumberTest() {
        int a = 37;
        Assertions.assertTrue(PrimeNumber.primeNumber(a));
    }

    @Test
    void primeNumberTest2() {
        int number = 37;
        boolean isPrime = isPrimeNumber(number);

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    public boolean primeNumberTestg() {
        int a = 37;
        for(int i=1;i<a;i++)
        {
            if(i!=1&&i != a)
            {
                if(a%i==0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}