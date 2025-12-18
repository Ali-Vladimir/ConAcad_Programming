public class QuickSort {
    public static void main(String[] args) {
        QuickSortClass object = new QuickSortClass();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.m_quickSort(array, 0, array.length - 1);
        object.m_printArray(array);
    }
}

class QuickSortClass {
    
    void m_quickSort(int[] p_array, int p_low, int p_high) {
        int v_pi;
        if (p_low < p_high) {
            v_pi = m_partition(p_array, p_low, p_high);
            m_quickSort(p_array, p_low, v_pi - 1);
            m_quickSort(p_array, v_pi + 1, p_high);
        }
    }
    
    int m_partition(int[] p_array, int p_low, int p_high) {
        int v_pivot, v_i, v_j;
        v_pivot = p_array[p_high];
        v_i = p_low - 1;
        v_j = p_low;
        while (v_j < p_high) {
            if (p_array[v_j] < v_pivot) {
                v_i++;
                m_swap(p_array, v_i, v_j);
            }
            v_j++;
        }
        m_swap(p_array, v_i + 1, p_high);
        return v_i + 1;
    }
    
    void m_swap(int[] p_array, int p_i, int p_j) {
        int v_temp;
        v_temp = p_array[p_i];
        p_array[p_i] = p_array[p_j];
        p_array[p_j] = v_temp;
    }
    
    void m_printArray(int[] p_array) {
        int v_counter = 0, v_length;
        v_length = p_array.length;
        System.out.println("Array ordenado:");
        while (v_counter < v_length) {
            System.out.print(p_array[v_counter] + " ");
            v_counter++;
        }
        System.out.println();
    }
}