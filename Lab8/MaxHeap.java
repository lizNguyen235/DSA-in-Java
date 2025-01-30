import java.util.NoSuchElementException;

public class MaxHeap {
    int[] heap;
    private int heapSize;
    private int maxSize;

    public MaxHeap(int capity) {
        maxSize = capity;
        heap = new int[capity + 1];
        heapSize = 0;
        heap[0] = -1;
    }

    // các phương thức để tìm index cần thiết của index i
    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // hiện thực hóa insert
    public void insert(int v) {
        if (heapSize == maxSize) { // nếu mảng đã đạt giá trị tối đa thì không thể thêm vào nữa
            throw new NoSuchElementException("toi da roi");
        }
        heapSize++;
        heap[heapSize] = v;
        shiftUp(heapSize);
    }

    private void shiftUp(int i) {
        while (i > 1 && heap[parent(i)] < heap[i]) { // nếu như chưa phải là root và bị mâu thuẫn
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public int ExtractMax() {
        if (heapSize == 0) {
            throw new NoSuchElementException("khong co phan tu");
        }
        int max = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int i) {
        int maxv = heap[i];
        int max_id = i;
        while (i <= heapSize) {
            if (leftChild(i) < heapSize && heap[leftChild(i)] > maxv) { // nếu như có con va con lon hon cha
                maxv = heap[leftChild(i)];
                max_id = leftChild(i);
            }
            if (rightChild(i) < heapSize && heap[rightChild(max_id)] > maxv) { // nếu như có con va con lon hon cha
                maxv = heap[leftChild(i)];
                max_id = rightChild(i);
            }
            if (max_id != i) {
                swap(i, max_id);
            } else {
                break;
            }
        }
    }

}