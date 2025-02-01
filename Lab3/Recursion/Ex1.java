package Recursion;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println(Factorial(5));
        System.out.println(myPow(2, 3));
        System.out.println(countDigit(1234));
        System.out.println(GCD(12, 15));
        System.out.println(checkPrime(6, 2));
    }

    public static int Factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * Factorial(n - 1);
    }
    public static int myPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * myPow(x, n - 1);
    }
    public static int countDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + countDigit(n / 10);
    }
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
    public static boolean checkPrime(int n, int i) {
       if(n <= 2) {
           return (n == 2) ? true : false;
       }
        if(n % i == 0) {
            return false;
        }
        // we have to check only i <= sqrt(n) because if n is not a prime number then it has a divisor
        // sqrt(n) * sqrt(n) = n => if sqrt(n) < i then i * i > n
        if(i * i > n) {
            return true;
        }
        return checkPrime(n, i + 1);
    }
}
