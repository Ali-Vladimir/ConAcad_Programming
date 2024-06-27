import java.util.Scanner;

public class p324 {
    int a_cases;
    int a_string;
    int v_valueAscii;
    int v_incrCharacter =0;
    int v_incrCases =0;
    char a_character;
    Scanner a_keyboard;
    public static void main(String[] args) {
        p324 object=new p324();
        object.m_acceptData();
        object.m_convert();
    }
    p324(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        a_cases = a_keyboard.nextInt();
    }
    void m_convert(){
        while(v_incrCases < a_cases){
            a_character = a_keyboard.next().charAt(0);
            a_string = a_keyboard.nextInt();
            if(a_string >0)
                while(v_incrCharacter < a_string){
                    System.out.print(a_character);
                    v_valueAscii = a_character;
                    v_valueAscii++;
                    a_character =(char) v_valueAscii;
                    v_incrCharacter++;
                }
            else{
                while(v_incrCharacter >= a_string){
                    System.out.print(a_character);
                    v_valueAscii = a_character;
                    v_valueAscii -=1;
                    a_character =(char) v_valueAscii;
                    v_incrCharacter -=1;
                }
            }
            v_incrCharacter =0;
            v_incrCases +=1;
            System.out.println();
        }
    }
}


