import java.util.Scanner;
public class p152 {
    public static void main(String[] args) {
        Dispenser object=new Dispenser();
        object.m_acceptCases();
    }
}
class Dispenser {
    Scanner a_keyboard;
    int a_numbCases, a_numberDispatches, a_randomDes, a_nextDispatch, a_counter =1, a_onlyOne =1;
    Dispenser(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptCases(){
        int v_incrCases=0;
        a_numbCases = a_keyboard.nextByte();
        while(v_incrCases< a_numbCases){
            a_numberDispatches = a_keyboard.nextInt();
            a_randomDes = a_keyboard.nextInt();
            m_dispenserPills();
            ++v_incrCases;
        }
    }
    void m_dispenserPills(){
        int v_incrDispatches=0;
        a_numberDispatches -=1;
        while(v_incrDispatches< a_numberDispatches){
            ++a_counter;
            a_nextDispatch = a_keyboard.nextInt();
            a_randomDes += a_nextDispatch;
            if(a_randomDes >=100) m_removeLeftovers();
            ++v_incrDispatches;
        }
        a_counter =1;
        System.out.println();
    }
    void m_removeLeftovers(){
        a_randomDes = a_randomDes -100;
        if(a_onlyOne ==1)System.out.print(a_counter);
        else System.out.print(" "+ a_counter);
        a_counter =0;
        ++a_onlyOne;
    }
}


