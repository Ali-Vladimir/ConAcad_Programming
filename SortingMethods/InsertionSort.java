public class InsertionSort {
    public static void main(String[] args) {
        InsertionSortClass object = new InsertionSortClass();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.m_insertionSort(array);
        object.m_printArray(array);
    }
}

class InsertionSortClass {
    
    void m_insertionSort(int[] p_array) {
        int v_i = 1, v_key, v_j, v_length;
        v_length = p_array.length;
        while (v_i < v_length) {
            v_key = p_array[v_i];
            v_j = v_i - 1;
            while (v_j >= 0 && p_array[v_j] > v_key) {
                p_array[v_j + 1] = p_array[v_j];
                v_j = v_j - 1;
            }
            p_array[v_j + 1] = v_key;
            v_i++;
        }
    }

    void m_printArray(int[] p_array) {
        int v_counter = 0, v_length;
        v_length = p_array.length;
        System.out.println("Array ordenado:");
        while (v_counter < v_length) {
            System.out.print(p_array[v_counter] + " ");
            v_counter++;
        }
        System. out.println();
    }
}