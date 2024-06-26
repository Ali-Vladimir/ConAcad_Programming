import java.util.Scanner;
public class p172 {
    public static void main(String[] args) throws Exception {
        Palindrome object=new Palindrome();
        object.m_acceptCases();
    }
}
class Palindrome {
    Scanner a_keyboard;
    char[] a_palindrome;
    String a_string, a_cases;
    Palindrome(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptCases(){
        a_cases = a_keyboard.nextLine();
        m_acceptData();
    }
    void m_acceptData(){
        int v_incrCases=0,v_numbCases;
        v_numbCases=Integer.parseInt(a_cases);
        while(v_incrCases<v_numbCases){
            a_string = a_keyboard.nextLine().toUpperCase();
            m_modifyString();
            ++v_incrCases;
        }
    }
    void m_modifyString(){
        a_string = a_string.replace(" ","");
        a_palindrome = a_string.toCharArray();
        m_compare();

    }
    void m_compare(){
        int v_recto, v_reverse;
        for(v_recto=0, v_reverse= a_palindrome.length-1; v_recto<=v_reverse; ++v_recto,--v_reverse){
            if(a_palindrome[v_recto]!= a_palindrome[v_reverse]){ System.out.println("false");}
        }
    }
}


