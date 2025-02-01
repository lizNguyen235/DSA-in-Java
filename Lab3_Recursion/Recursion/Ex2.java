package Recursion;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println(function1(5));
        System.out.println(function2(5));
        System.out.println(function3(5));
        System.out.println(function4(5, 2));
        System.out.println(function5(5));
    }

    public static int function1(int n) {
        if(n == 0) {
            return 0;
        }
        return 2 *n + 1 + function1(n - 1);
    }
    public static int function2(int n) {
        if(n == 1) {
            return 1;
        }
        return  Factorial(n) * function2(n - 1);
    }

    public static int function3(int n) {
        if(n == 0) {
            return 0;
        }
        return Factorial(n) + function3(n - 1);
    }

    public static int function4(int n, int r) {
       if(n == r) {
            return 1;
       }
       return n * function4(n - 1, r);
    }

    public static int function5(int n) {
        if(n == 1) {
            return 3;
        }
        return (int)Math.pow(2, n) + n * n + function5(n - 1);
    }

    public static int Factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

}
