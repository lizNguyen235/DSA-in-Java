import java.util.*;

class Sosanh implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (a % 2 == 0 && b % 2 == 0) {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        } else if (a % 2 != 0 && b % 2 != 0) {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (a % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

public class Practice {
    public static int convertBi(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 2) + convertBi(n / 2) * 10;
    }

    public static String reserve(int n) {
        if (n == 0) {
            return "";
        }
        return String.valueOf(n % 10) + reserve(n / 10);
    }

    public static int countChar(String s, int index, char x) {
        if (index == 0) {
            return x == s.charAt(index) ? 1 : 0;
        }
        return x == s.charAt(index) ? 1 + countChar(s, index - 1, x) : countChar(s, index - 1, x);
    }

    public static String format(int n) {
        switch (n) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return String.valueOf(n);

        }
    }

    public static String convertHex(int n) {
        if (n == 0) {
            return "";
        }
        return convertHex(n / 16) + format(n % 16);
    }

    public static void printIndex(int[] a, int index) {
        if (index == 0) {
            return;
        }
        if (index == 1) {
            System.out.println(a[index]);
            return;
        }
        if ((Math.log(index) / Math.log(2)) == (int) (Math.log(index) / Math.log(2))) {
            System.out.println(a[index]);
            printIndex(a, index - 1);
        } else {
            printIndex(a, index - 1);
        }
    }

    public static void main(String[] args) {
        int n = 50;
        Integer[] a = { 6, 3, 7, 2, 5, 1, 9, 3 };
        Arrays.sort(a, new Sosanh());
        System.out.println(Arrays.toString(a));
    }
}
