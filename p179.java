import java.util.Scanner;
public class p179 {
    Scanner a_keyboard;
    int a_numbCases, a_numStatues, a_height, a_maxima, a_minima;
    public static void main(String[] args) {
        p179 object=new p179();
        object.m_checkNumbCases();
        object.m_acceptData();
    }
    p179(){
        a_keyboard =new Scanner(System.in);
    }
    void m_checkNumbCases(){
        a_numbCases = a_keyboard.nextInt();
    }
    void m_acceptData(){
        int v_incrCases=0, v_incrStatues=1,v_counter=1;
        while(v_incrCases< a_numbCases){
            a_numStatues = a_keyboard.nextInt();
            while(v_incrStatues<= a_numStatues){
                a_height = a_keyboard.nextInt();
                if(v_counter==1){a_maxima= a_height; a_minima= a_height;}
                if(a_maxima< a_height) a_maxima= a_height;
                if(a_minima> a_height) a_minima= a_height;
                ++v_counter;
                ++v_incrStatues;
            }
            a_maxima-=a_minima;
            v_incrStatues-=2;
            a_maxima-=v_incrStatues;
            System.out.println(a_maxima);
            a_maxima=0;
            a_minima=0;
            v_counter=1;
            v_incrStatues=1;
            ++v_incrCases;
        }
    }
}