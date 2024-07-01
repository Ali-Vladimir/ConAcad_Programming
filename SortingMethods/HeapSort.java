public class HeapSort {
    public static void main(String[] args) throws Exception {
        heapsort object = new heapsort();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.heapSort(array);
        System.out.println("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
class heapsort {
    public void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap_ify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap_ify(array, i, 0);
        }
    }
    void heap_ify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heap_ify(array, n, largest);
        }
    }
}