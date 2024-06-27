import java.util.Scanner;

public class p297 {
    int v_numb1, v_numb2, v_numb3;
    float v_aux,v_aux2;
    public static void main(String[] args) throws Exception {
        p297 object=new p297();
        object.m_acceptData();
        object.m_splitType1();
        object.m_splitType2();
        object.m_splitType3();
        object.m_printResult();
    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        v_numb1 =v_keyboard.nextInt();
        v_numb2 =v_keyboard.nextInt();
        v_numb3 =v_keyboard.nextInt();

    }
    void m_splitType1(){
        v_aux=(float) v_numb1 / v_numb2;
        v_aux2=(float) v_numb1 / v_numb3;
        m_printResult();
    }
    void m_splitType2(){
        v_aux=(float) v_numb2 / v_numb1;
        v_aux2=(float) v_numb2 / v_numb3;
        m_printResult();
    }
    void m_splitType3(){
        v_aux=(float) v_numb3 / v_numb1;
        v_aux2=(float) v_numb3 / v_numb2;
        m_printResult();
    }
    void m_printResult(){
        v_aux*=100;
        v_aux=(int)(v_aux);
        v_aux/=100;
        v_aux2*=100;
        v_aux2=(int)(v_aux2);
        v_aux2/=100;
        System.out.println(v_aux);
        System.out.println(v_aux2);
    }
}