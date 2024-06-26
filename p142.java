import java.util.Scanner;

public class p142 {
    public static void main(String[] args) {
        ISBN10 object=new ISBN10();
        object.m_acceptCases();
    }
}
class ISBN10{
    Scanner a_keyboard;
    int a_storage;
    String a_string, a_numberCases;
    ISBN10(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptCases(){
        int v_incrCases=0,v_numbCases;
        a_numberCases = a_keyboard.nextLine();
        v_numbCases=Integer.parseInt(a_numberCases);
        while(v_incrCases<v_numbCases){
            m_acceptISBN();
            ++v_incrCases;
        }
    }
    void m_acceptISBN(){
        a_string = a_keyboard.nextLine();
        a_string = a_string.replace(" ","");
        a_string = a_string.replace("-","");
        m_multiplyString();
    }
    void m_multiplyString(){
        int v_valor,v_multiplication=1,v_counter=0,v_incrString=0,v_largeString;
        v_largeString= a_string.length();
        v_largeString-=2;
        while(v_incrString<=v_largeString){
            v_valor=Character.getNumericValue(a_string.charAt(v_counter));
            v_valor*=v_multiplication;
            a_storage +=v_valor;
            ++v_counter;
            ++v_multiplication;
            ++v_incrString;
        }
        m_printResult();
        a_storage =0;
    }
    void m_printResult(){
        int v_result;
        v_result= a_storage %11;
        if (v_result==Character.getNumericValue(a_string.charAt(9))) System.out.println("CORRECTO");
        else System.out.println("INCORRECTO");
    }

}


