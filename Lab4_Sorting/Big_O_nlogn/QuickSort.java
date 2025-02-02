package Big_O_nlogn;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 3, 1};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        // Choose the pivot element is the first element
        int pivot = arr[low];
        // Index of smaller element
        int i = low;
        int j = high + 1;
       do {
            // move i until find the element greater or equal than pivot
            // move j until find the element less or equal than pivot
           do {
                i++;
            } while(arr[i] < pivot && i < high);
           do {
                j--;
            } while(arr[j] > pivot && j > low);
            // Swap the element at i and j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        } while(i < j);
        // Swap the pivot element with the element at j
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // Swap the pivot element with the element at j
        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
}
