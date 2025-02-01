package Big_O_nlogn;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void mergeSort(int[] arr, int first, int last) {
        if(first < last) {
            int m = (first + last) / 2; //find middle point
            mergeSort(arr, first, m);
            mergeSort(arr, m + 1, last);
            merge(arr, first, m, last);
        }
    }
    public static void merge(int[] arr, int first, int middle, int last) {
        // Find sizes of two subarrays to be merged
        int sizeLeft = middle - first + 1;
        int sizeRight = last - middle;
        // Create temp arrays
        int[] left = new int[sizeLeft];
        int[] right = new int[sizeRight];
        // Copy data to temp arrays
        for(int i = 0; i < sizeLeft; i++) {
            left[i] = arr[first + i];
        }
        for(int j = 0; j < sizeRight; j++) {
            right[j] = arr[middle + 1 + j];
        }
        // Merge the temp arrays
        int i,j,k;
        for( i = 0, j = 0, k = first; i < sizeLeft && j < sizeRight; k++) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
        // Copy remaining elements of left[] if any
        while(i < sizeLeft) {
            arr[k] = left[i];
            i++;
            k++;
        }
        // Copy remaining elements of right[] if any
        while(j < sizeRight) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
