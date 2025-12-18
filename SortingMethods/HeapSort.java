public class HeapSort {
    public static void main(String[] args) {
        HeapSortClass object = new HeapSortClass();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.m_heapSort(array);
        object.m_printArray(array);
    }
}

class HeapSortClass {
    
    void m_heapSort(int[] p_array) {
        int v_length, v_i, v_temp;
        v_length = p_array.length;
        v_i = v_length / 2 - 1;
        while (v_i >= 0) {
            m_heapify(p_array, v_length, v_i);
            v_i--;
        }
        v_i = v_length - 1;
        while (v_i >= 0) {
            v_temp = p_array[0];
            p_array[0] = p_array[v_i];
            p_array[v_i] = v_temp;
            m_heapify(p_array, v_i, 0);
            v_i--;
        }
    }
    
    void m_heapify(int[] p_array, int p_n, int p_i) {
        int v_largest, v_left, v_right, v_swap;
        v_largest = p_i;
        v_left = 2 * p_i + 1;
        v_right = 2 * p_i + 2;
        if (v_left < p_n && p_array[v_left] > p_array[v_largest]) {
            v_largest = v_left;
        }
        if (v_right < p_n && p_array[v_right] > p_array[v_largest]) {
            v_largest = v_right;
        }
        if (v_largest != p_i) {
            v_swap = p_array[p_i];
            p_array[p_i] = p_array[v_largest];
            p_array[v_largest] = v_swap;
            m_heapify(p_array, p_n, v_largest);
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
        System.out. println();
    }
}