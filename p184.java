import java.util.Scanner;
import java.text.DecimalFormat;
public class p184{
    float a_invitedChild, a_presentChild, a_result;
    Scanner a_keyboard;
    String a_aux;
    public static void main(String[] args) {
        p184 object=new p184();
        object.m_acceptData();
        object.m_divCake();
        object.m_acceptData();
        object.m_divCake();
    }
    p184(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        a_invitedChild = a_keyboard.nextFloat();
        a_presentChild = a_keyboard.nextFloat();
    }
    void m_divCake(){
        DecimalFormat decimoles=new DecimalFormat("##.##");
        if (a_presentChild > a_invitedChild || a_presentChild == a_invitedChild) System.out.print(" 0%");
        else {
            a_result = a_presentChild / a_invitedChild; a_result =1- a_result; a_result *=100;
            a_aux=decimoles.format(a_result);
            System.out.print(" "+a_aux);System.out.print("%");}
    }
}