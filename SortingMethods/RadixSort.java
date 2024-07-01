import java.util.*;

public class RadixSort {
    public static void main(String[] args) throws Exception {
        Radixsort object = new Radixsort();
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        object.radixSort(array);
        System.out.println("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
class Radixsort {
    void radixSort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }
    int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
            
        }
    }
}