import java.util. Arrays;

public class RadixSort {
    public static void main(String[] args) {
        RadixSortClass object = new RadixSortClass();
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        object.m_radixSort(array);
        object.m_printArray(array);
    }
}

class RadixSortClass {
    
    void m_radixSort(int[] p_array) {
        int v_max, v_exp;
        v_max = m_getMax(p_array);
        v_exp = 1;
        while (v_max / v_exp > 0) {
            m_countingSort(p_array, v_exp);
            v_exp *= 10;
        }
    }
    
    int m_getMax(int[] p_array) {
        int v_max, v_i, v_length;
        v_max = p_array[0];
        v_i = 1;
        v_length = p_array. length;
        while (v_i < v_length) {
            if (p_array[v_i] > v_max) {
                v_max = p_array[v_i];
            }
            v_i++;
        }
        return v_max;
    }
    
    void m_countingSort(int[] p_array, int p_exp) {
        int v_n, v_i, v_index;
        v_n = p_array.length;
        int[] v_output = new int[v_n];
        int[] v_count = new int[10];
        Arrays.fill(v_count, 0);
        v_i = 0;
        while (v_i < v_n) {
            v_index = (p_array[v_i] / p_exp) % 10;
            v_count[v_index]++;
            v_i++;
        }
        v_i = 1;
        while (v_i < 10) {
            v_count[v_i] += v_count[v_i - 1];
            v_i++;
        }
        v_i = v_n - 1;
        while (v_i >= 0) {
            v_index = (p_array[v_i] / p_exp) % 10;
            v_output[v_count[v_index] - 1] = p_array[v_i];
            v_count[v_index]--;
            v_i--;
        }
        v_i = 0;
        while (v_i < v_n) {
            p_array[v_i] = v_output[v_i];
            v_i++;
        }
    }
    
    void m_printArray(int[] p_array) {
        int v_counter = 0, v_length;
        v_length = p_array.length;
        System. out.println("Array ordenado:");
        while (v_counter < v_length) {
            System.out.print(p_array[v_counter] + " ");
            v_counter++;
        }
        System.out.println();
    }
}