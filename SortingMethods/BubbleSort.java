public class BubbleSort {
    public static void main(String[] args) {
        BubbleSortClass object = new BubbleSortClass();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.m_bubbleSort(array);
        object.m_printArray(array);
    }
}

class BubbleSortClass {
    
    void m_bubbleSort(int[] p_array) {
        int v_i = 0, v_j, v_temp, v_length;
        v_length = p_array.length;
        while (v_i < v_length - 1) {
            v_j = 0;
            while (v_j < v_length - v_i - 1) {
                if (p_array[v_j] > p_array[v_j + 1]) {
                    v_temp = p_array[v_j];
                    p_array[v_j] = p_array[v_j + 1];
                    p_array[v_j + 1] = v_temp;
                }
                v_j++;
            }
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
        System.out.println();
    }
}