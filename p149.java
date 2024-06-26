import java.util.Scanner;

public class p149 {
    public static void main(String[] args) {
        ISBN13 object=new ISBN13();
        object.m_acceptCases();
    }
}
class ISBN13{
    Scanner a_keyboard;
    String a_numberCases, a_string;
    int a_character, a_accumulator;
    ISBN13(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptCases(){
        int v_incrCases=0, v_numbCases;
        a_numberCases = a_keyboard.nextLine();
        v_numbCases=Integer.parseInt(a_numberCases);
        while(v_incrCases<v_numbCases){
            m_acceptISBN();
            ++v_incrCases;
        }

    }
    void m_acceptISBN(){
        int v_longString;
        a_string = a_keyboard.nextLine();
        v_longString= a_string.length();
        if(v_longString==17){
            a_string = a_string.replace("-","");
            a_string = a_string.replace(" ","");
            m_compISBN();}
        else m_compISBN();
    }
    void m_compISBN(){
        int v_length, v_incrString=6, v_multiple=1,v_counter=0;
        v_length= a_string.length();
        v_length-=1;
        if(v_length==12){
            while(v_incrString<v_length){
                a_character =Character.getNumericValue(a_string.charAt(v_counter));
                a_character *=v_multiple;
                m_accumulate();
                v_multiple+=2;
                ++v_counter;
                a_character =Character.getNumericValue(a_string.charAt(v_counter));
                a_character *=v_multiple;
                m_accumulate();
                v_multiple-=2;
                ++v_counter;
                ++v_incrString;
            }
            m_printResult();
        }else System.out.println("INCORRECTO");
    }
    void m_accumulate(){
        a_accumulator += a_character;
    }
    void m_printResult(){
        int v_residue;
        v_residue= a_accumulator %10;
        if (v_residue != 0) {
            v_residue = 10 - v_residue;
        }
        if(v_residue==Character.getNumericValue(a_string.charAt(12))) System.out.println("CORRECTO");
        else System.out.println("INCORRECTO");
        a_accumulator =0;
    }

}




