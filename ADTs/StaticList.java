public class StaticListM {
    public static void main(String[] args) throws Exception {
        StaticList object=new StaticList(5);
        object.m_add(4);
        object.m_add(3);
        object.m_printList();
        object.m_remover(10);
        object.m_add(20);
        object.m_add(2);
        object.m_printList();
        object.m_add(5);
        object.m_add(-8);
        object.m_remover(2);
        object.m_printList();
    }
}
class StaticList {
    int[] a_array;
    int a_counter;
    StaticList(int p_longitude){
        a_array =new int[p_longitude];
        a_counter =0;
    }
    void m_add(int p_number){
        int v_iterator=0;
        boolean v_flag=false;
        if(a_counter ==0){ a_array[0]=p_number;
            a_counter++;}
        else if(a_counter == a_array.length) System.out.println("Overflow");
        else{
            while(v_iterator< a_counter){
                if(a_array[v_iterator]>p_number && !v_flag){
                    m_loop(v_iterator);
                    a_array[v_iterator]=p_number;
                    v_flag=true;
                }
                v_iterator++;
            }
            if(!v_flag){
                a_array[a_counter]=p_number;
            }
            a_counter++;
        }
    }
    void m_printList(){
        int v_iterator;
        for(v_iterator=0; v_iterator< a_counter; v_iterator++){
            System.out.print("["+ a_array[v_iterator]+"] ");
        }
        System.out.println();
    }
    void m_loop(int p_dot){
        int v_iterator;
        for(v_iterator= a_array.length-2; v_iterator>=p_dot; v_iterator--){
            a_array[v_iterator+1]= a_array[v_iterator];
        }
    }
    void m_remover(int p_data){
        if(m_check(p_data)){
            int v_dot= m_search(p_data);
            m_loopA(v_dot);
            a_counter--;
        }else{
            System.out.println("UnderFlow");
        }
    }
    void m_loopA(int p_dot){
        int v_iterator;
        for(v_iterator=p_dot; v_iterator<= a_array.length-2; v_iterator++){
            a_array[v_iterator]= a_array[v_iterator+1];
        }
    }
    int m_search(int p_number){
        int v_iterator=0,v_position=0;
        while(v_iterator< a_array.length){
            if(a_array[v_iterator]==p_number) v_position=v_iterator;
            v_iterator++;
        }
        return v_position;
    }
    boolean m_check(int p_number){
        boolean v_flag=false;
        int v_iterator;
        for(v_iterator=0; v_iterator< a_array.length; v_iterator++){
            if(a_array[v_iterator]==p_number) v_flag=true;
        }
        return v_flag;
    }
}
