import java.util.Arrays;

public class Sorting {
    // đưa phần tử nhỏ nhất lên đầu
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) { // nếu là dấu bé là thứ tự giảm dần
                    index = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // cái này là turn sắp xếp, nếu có 5 phần tử thì chỉ cần 4 turn
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static insertSort(int[] arr) {
        
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 4, 1 };
        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}