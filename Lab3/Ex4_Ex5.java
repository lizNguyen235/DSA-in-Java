public class Ex4_Ex5 {
    public static int tong_a(int n) {
        if (n <= 0)
            return 0;
        return 2 * n + 1 + tong_a(n - 1);
    }

    public static int factorial_iter(int n) {
        if (n == 0)
            return 1;
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= i;
        }
        return p;
    }

    public static int tong_b(int n) {
        if (n == 0)
            return 0;
        return factorial_iter(n) + tong_b(n - 1);

    }

    public static int tich_c(int n) {
        if (n == 0)
            return 1;
        return factorial_iter(n) * tich_c(n - 1);

    }

    public static int P(int n, int r) {
        if (r <= 0 || r > n) {
            return 1;
        }
        return n * P(n - 1, r);
    }

    public static double P(int n) {
        if (n <= 1)
            return 3;
        return Math.pow(2, n) + Math.pow(n, 2) + P(n - 1);
    }

    public static int convertToBinary(int n) {
        if (n < 2)
            return 1;
        return n % 2 + 10 * convertToBinary(n / 2);
    }

    public static void main(String[] args) {
        // System.out.println(tich_c(1));
        // System.out.println(tich_c(2));
        // System.out.println(tich_c(4));
        System.out.println(convertToBinary(3));
    }
}