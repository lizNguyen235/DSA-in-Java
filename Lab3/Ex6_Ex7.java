public class Ex6_Ex7 {
    public static int findMinIter(int[] arr) {
        int min = arr[0];
        for (int e : arr) {
            if (e < min)
                min = e;
        }
        return min;
    }

    public static int findMinRecur(int[] arr, int size) {
        int min = arr[arr.length - size];
        if (size == 1) {
            return arr[arr.length - 1];
        }
        return min < findMinRecur(arr, size - 1) ? min : findMinRecur(arr, size - 1);
    }

    public static int sumArrayIter(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }

    public static int sumArrayRecur(int[] arr, int size) {
        if (size == 1) {
            return arr[arr.length - 1];
        }
        return arr[arr.length - size] + sumArrayRecur(arr, size - 1);
    }

    public static int countEvenNumberIter(int[] arr) {
        int count = 0;
        for (int e : arr) {
            if (e % 2 == 0)
                count++;
        }
        return count;
    }

    public static int countEvenNumberRecur(int[] arr, int size) {
        if (size == 1) {
            if (arr[arr.length - 1] % 2 == 0)
                return 1;
            return 0;
        }
        if (arr[arr.length - size] % 2 == 0)
            return 1 + countEvenNumberRecur(arr, size - 1);
        return countEvenNumberRecur(arr, size - 1);

    }

    public static void main(String[] args) {
        System.out.println(countEvenNumberIter(new int[] { 1, 3, 5, 7, -3, 3, 2 }));
        System.out.println(countEvenNumberRecur(new int[] { 1, 3, 5, 7, -3, 3, 2 }, 7));
    }
}
