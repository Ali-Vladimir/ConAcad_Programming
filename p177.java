import java.util.Scanner;

public class p177 {
    public static void main(String[] args) {
        Mail object=new Mail();
        object.m_acceptData();
    }
}
class Mail{
    Scanner a_keyboard;
    String[] a_array;
    Mail(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        int v_iterator=0,v_numbCases=Integer.parseInt(a_keyboard.nextLine());
        while(v_iterator<v_numbCases){
            String v_mail= a_keyboard.nextLine();
            if(v_mail.length()==1) m_prints('D');
            else m_processString(v_mail);
            v_iterator++;
        }
    }
    void m_processString(String p_mail){
        if(p_mail.charAt(0) == 64 ) m_prints('U');
        else{
            a_array =p_mail.split("@");
            if(a_array.length!=2) m_prints('D');
            else{
                if(m_checkPoints(a_array[0],'U'))
                    if(m_checkPoints(a_array[1],'D'))
                        if(!m_checkDomain(a_array[1])) m_prints('D');
                        else m_prints('B');
            }
        }
    }
    boolean m_checkDomain(String p_word) {
        int v_iterator = 0;
        while (v_iterator < p_word.length()) {
            char character = p_word.charAt(v_iterator);
            if (!((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') ||
                    (character >= '0' && character <= '9') || character == '-' || character == '.')) {
                return false;
            }
            v_iterator++;
        }
        return true;
    }
    boolean m_checkPoints(String p_word, char p_character){
        int v_iterator=0;
        boolean v_flag=false;
        while(v_iterator<p_word.length()){
            if(p_word.charAt(v_iterator)==46 && v_flag){
                m_prints(p_character);
                return false;
            }
            else v_flag= p_word.charAt(v_iterator) == 46 && !v_flag;
            v_iterator++;
        }
        return true;
    }
    void m_prints(char p_option){
        switch (p_option){
            case 'U':
                System.out.println("USUARIO INCORRECTO");
                break;
            case 'D':
                System.out.println("DOMINIO INCORRECTO");
                break;
            case 'B':
                System.out.println(a_array[1]);
                break;
            default:
                System.out.println("Fallo Algo");
                break;
        }
    }
}