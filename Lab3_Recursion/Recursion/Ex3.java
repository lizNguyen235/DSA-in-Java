package Recursion;

public class Ex3 {
    public static void main(String[] args) {
        
    }
    public static int minArray(int[] arr, int n) {
        if(n == 1) {
            return arr[0];
        }
        return Math.min(arr[n - 1], minArray(arr, n - 1));
    }
    public static int sumArray(int[] arr, int n) {
        if(n == 1) {
            return arr[0];
        }
        return arr[n - 1] + sumArray(arr, n - 1);
    }
    public static int evenArray(int[] arr, int n) {
        if(n == 1) {
            return (arr[0] % 2 == 0) ? 1 : 0;
        }
        return (arr[n - 1] % 2 == 0 ? 1 : 0) + evenArray(arr, n - 1);
    }
}
