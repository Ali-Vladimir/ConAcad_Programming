import java.util.Scanner;

public class p169 {
    public static void main(String[] args) {
        Springfield object=new Springfield();
        object.m_acceptCases();
    }
}
class Springfield{
    Scanner a_keyboard;
    int a_cases, a_numbM, a_numbLeft, a_numbRight, a_onlyOne=1;
    Springfield(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptCases(){
        a_cases = a_keyboard.nextInt();
        m_acceptData();
    }
    void m_acceptData(){
        int v_incrCases=0;
        while(v_incrCases< a_cases){
            a_numbM = a_keyboard.nextInt();
            if(a_numbM <0) a_numbM *=-1;
            a_numbLeft = a_keyboard.nextInt();
            a_numbRight = a_keyboard.nextInt();
            m_findData();
            ++v_incrCases;
        }
    }
    void m_findData(){
        int v_multiplication=0,v_repetition,v_counter=0;
        if(a_numbM ==0)System.out.println("S/M");
        else{
            if(a_numbLeft >=0&& a_numbRight >=0){
                if(a_numbLeft > a_numbRight){
                    v_repetition= a_numbM;
                    while(a_numbM <= a_numbLeft){
                        a_numbM =v_repetition;
                        a_numbM *=v_multiplication;
                        ++v_multiplication;
                        if(a_numbM <= a_numbLeft && a_numbM >= a_numbRight){
                            m_printResult();++v_counter;}
                    }
                    if(v_counter==0)System.out.println("S/M");
                    else System.out.println();
                    a_onlyOne=1;
                }
                else if(a_numbRight >= a_numbLeft){
                    v_repetition= a_numbM;
                    while(a_numbM <= a_numbRight){
                        a_numbM =v_repetition;
                        a_numbM *=v_multiplication;
                        ++v_multiplication;
                        if(a_numbM >= a_numbLeft && a_numbM <= a_numbRight){
                            m_printResult();++v_counter;}
                    }
                    if(v_counter==0)System.out.println("S/M");
                    else System.out.println();
                    a_onlyOne=1;
                }
            }
            else if(a_numbLeft < a_numbRight){
                v_repetition= a_numbM;
                a_numbM *= a_numbLeft;
                while(a_numbM <= a_numbRight){
                    a_numbM +=v_repetition;
                    if(a_numbM >= a_numbLeft && a_numbM <= a_numbRight){
                        m_printResult();++v_counter;}
                }
                if(v_counter==0)System.out.println("S/M");
                else System.out.println();
                a_onlyOne=1;
            }
            else if(a_numbLeft > a_numbRight){
                v_repetition= a_numbM;
                a_numbM *= a_numbRight;
                while(a_numbM <= a_numbLeft){
                    a_numbM +=v_repetition;
                    if(a_numbM <= a_numbLeft && a_numbM >= a_numbRight){
                        m_printResult();++v_counter;}
                }
                if(v_counter==0)System.out.println("S/M");
                else System.out.println();
                a_onlyOne=1;
            }}
    }
    void m_printResult(){
        if(a_onlyOne==1)System.out.print(a_numbM);
        else System.out.print(","+ a_numbM);
        ++a_onlyOne;
    }
}