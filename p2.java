import java.util.Scanner;

public class p2 {
    public static void main(String[] args) throws Exception {
        addLongIntegers object=new addLongIntegers();
        object.m_acceptanceCases();
    }
}

class addLongIntegers {
    Scanner a_keyboard;
    String a_number1, a_number2;
    String a_resultant ="";

    addLongIntegers(){
        a_keyboard=new Scanner(System.in);
    }

    void m_acceptanceCases(){
        int v_numbCases;
        v_numbCases=a_keyboard.nextInt();
        a_keyboard.nextLine();
        m_acceptNumbers(v_numbCases*2);
    }

    void m_acceptNumbers(int p_repetitions){
        int v_iterador=0;
        while(v_iterador<p_repetitions){
            a_number1 =a_keyboard.nextLine();
            a_number2 =a_keyboard.nextLine();
            m_equalize();
            v_iterador+=2;
        }
    }

    void m_equalize(){
        int v_difference,v_iterador=0;
        v_difference=Math.abs(a_number1.length()- a_number2.length());
        if(a_number1.length()> a_number2.length()){
            while(v_iterador<v_difference){
                a_number2 ="0"+a_number2;
                v_iterador++;
            }
        }else{
            while(v_iterador<v_difference){
                a_number1 ="0"+a_number1;
                v_iterador++;
            }
        }
        m_add();
    }

    void m_add(){
        int v_iterador;
        String v_digito1,v_digito2;
        int v_unidadMayor=0,v_aux;
        for(v_iterador= a_number1.length()-1; v_iterador>=0; v_iterador--){
            v_digito1=""+ a_number1.charAt(v_iterador);
            v_digito2=""+ a_number2.charAt(v_iterador);
            v_aux=Integer.parseInt(v_digito1)+Integer.parseInt(v_digito2)+v_unidadMayor;
            if(v_aux>9){
                a_resultant =v_aux%10+a_resultant;
                v_unidadMayor=v_aux/10;
            }else{
                a_resultant =v_aux+a_resultant;
                v_unidadMayor=0;
            }
        }
        if(v_unidadMayor>0) a_resultant =v_unidadMayor+ a_resultant;
        m_printResult();
    }

    void m_printResult(){
        System.out.println(a_resultant);
        a_resultant ="";
    }


}

