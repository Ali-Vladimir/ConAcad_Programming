public class ShellSort {
    public static void main(String[] args) {
        ShellSortClass object = new ShellSortClass();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        object.m_shellSort(array);
        object.m_printArray(array);
    }
}

class ShellSortClass {
    
    void m_shellSort(int[] p_array) {
        int v_n, v_increment, v_i, v_temp, v_j;
        v_n = p_array.length;
        v_increment = 1;
        while (v_increment < v_n / 3) {
            v_increment = v_increment * 3 + 1;
        }
        while (v_increment > 0) {
            v_i = v_increment;
            while (v_i < v_n) {
                v_temp = p_array[v_i];
                v_j = v_i;
                while (v_j >= v_increment && p_array[v_j - v_increment] > v_temp) {
                    p_array[v_j] = p_array[v_j - v_increment];
                    v_j -= v_increment;
                }
                p_array[v_j] = v_temp;
                v_i++;
            }
            v_increment /= 3;
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