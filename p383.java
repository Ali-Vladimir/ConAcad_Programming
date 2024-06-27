import java.util.Scanner;

public class p383 {
    public static void main(String[] args) {
        DropTheNumber object=new DropTheNumber();
        object.m_acceptStack();
        object.m_emptyStack();

    }
}
class DropTheNumber{
    Scanner a_keyboard;
    int [] a_stack;
    int a_top;
    DropTheNumber(){
        a_keyboard =new Scanner(System.in);
        a_top =0;
    }
    void m_acceptStack(){
        a_stack =new int[a_keyboard.nextInt()];
        m_travelStack();
    }
    void m_travelStack(){
        int v_iterator;
        for(v_iterator=0; v_iterator< a_stack.length; v_iterator++){
            m_push(a_keyboard.nextInt());
            m_fuse();
        }
    }
    void m_push(int p_number){
        a_stack[a_top++]=p_number;
    }
    void m_fuse(){
        if(a_top >1){
            if(a_stack[a_top -2]== a_stack[a_top -1]){
                m_pop();
                m_fuse();
            }
        }
    }
    void m_pop(){
        int v_aux= a_top -2;
        --a_top;
        a_stack[v_aux]= a_stack[v_aux]*2;
    }
    void m_emptyStack(){
        while (a_top >0){
            System.out.println(a_stack[--a_top]);
        }
    }
}


