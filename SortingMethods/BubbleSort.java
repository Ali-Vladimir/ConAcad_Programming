public class BubbleSort {
    public static void main(String[] args) throws Exception {
        bubblesort objeto=new bubblesort();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        objeto.bubbleSort(array);
        System.out.println("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

class bubblesort {
    void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
