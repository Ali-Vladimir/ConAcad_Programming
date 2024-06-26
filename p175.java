import java.util.Scanner;

public class p175 {
    Scanner a_keyboard;
    int a_numbCases, a_incrCases =0, a_increase, a_Decrement, a_Meta;
    public static void main(String[] args){
        p175 object=new p175();
        object.m_acceptData();
        object.m_calcIncrease();
    }
    p175(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        a_numbCases = a_keyboard.nextInt();
    }
    void m_calcIncrease(){
        int v_dias=0, v_counter=0;
        while(a_incrCases < a_numbCases){
            a_increase = a_keyboard.nextInt();
            a_Decrement = a_keyboard.nextInt();
            a_Meta= a_keyboard.nextInt();
            if(a_increase <= a_Decrement)System.out.println("0");
            else{
                while(v_dias<a_Meta){
                    v_dias+= a_increase;
                    v_dias-= a_Decrement;
                    v_counter++;
                }
                System.out.println(v_counter);
                v_counter=0;
                v_dias=0;
            }
            a_incrCases++;
        }
    }
}