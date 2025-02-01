package Big_O_square;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        insertionSortAsc(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    //ascending order
    public static void insertionSortAsc(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    //descending order
    public static void insertionSortDesc(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
