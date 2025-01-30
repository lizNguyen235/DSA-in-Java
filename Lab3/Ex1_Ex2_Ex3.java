public class Ex1_Ex2_Ex3 {
    public static int factorial_iter(int n) {
        if (n == 0)
            return 1;
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= i;
        }
        return p;
    }

    public static int factorial_recur(int n) {
        if (n == 1 | n == 0)
            return 1;
        return n * factorial_recur(n - 1);
    }

    public static int Power_iter(int x, int n) {
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= x;
        }
        return p;
    }

    public static int Power_recur(int x, int n) {
        if (n == 0)
            return 1;
        return x * Power_recur(x, n - 1);
    }

    public static int count_iter(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static int count_recur(int n) {
        if (n / 10 == 0)
            return 1;
        return 1 + count_recur(n / 10);
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime(int n, int d) {
        if (d < 2)
            return false;
        if (d == 2)
            return true;
        if (n % d == 0)
            return false;
        return isPrime(n, d - 1);
    }

    public static int GCD_iter(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int GCD_recur(int a, int b) {
        if (a == b)
            return a;
        else
            return GCD_recur(Math.min(a, b), Math.abs(a - b));
    }

    public static void main(String[] args) {
        // System.out.println(factorial_iter(5));
        // System.out.println(factorial_recur(0));
        // System.out.println(Power_iter(2,5));
        // System.out.println(Power_recur(2,5));
        // System.out.println(count_iter(100));
        // System.out.println(count_recur(1));
        // System.out.println(isPrime(7,6));
        System.out.println(GCD_iter(13, 12));
        System.out.println(GCD_recur(24, 12));
    }
}