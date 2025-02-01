package Big_O_square;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        selectionSortAsc(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    //ascending order
    public static void selectionSortAsc(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            //find the minimum element in the unsorted part of the array
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    //descending order
    public static void selectionSortDesc(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            //find the maximum element in the unsorted part of the array
            for(int j = i + 1; j < n; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            //swap
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
