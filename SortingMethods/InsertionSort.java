public class InsertionSortM {
    public static void main(String[] args) throws Exception {
        Insertionsort object = new Insertionsort();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.insertionSort(array);
        System.out.println("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
class Insertionsort {
    void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}