public class ShellSortM {
    public static void main(String[] args) throws Exception {
        Shellsort object = new Shellsort();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.shellSort(array);
        System.out.println("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
class Shellsort {
    void shellSort(int[] array) {
        int n = array.length;
        int increment = 1;
        while (increment < n / 3) {
            increment = increment * 3 + 1;
        }
        while (increment > 0) {
            for (int i = increment; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= increment && array[j - increment] > temp) {
                    array[j] = array[j - increment];
                    j -= increment;
                }
                array[j] = temp;
            }
            increment /= 3;
        }
    }
}