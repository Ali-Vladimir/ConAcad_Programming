import java.util.Scanner;
public class p181 {
    String v_cade1,v_cade2,v_cade3,v_cade4;
    int v_numb1, v_numb2, v_numb3, v_numb4;
    public static void main(String[] args) throws Exception {
        p181 object=new p181();
        object.m_acceptData();
        object.m_doDifferences();
    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        v_cade1=v_keyboard.nextLine();
        v_cade2=v_keyboard.nextLine();
        v_cade3=v_keyboard.nextLine();
        v_cade4=v_keyboard.nextLine();
        v_numb1 =Integer.parseInt(v_cade1);
        v_numb2 =Integer.parseInt(v_cade2);
        v_numb3 =Integer.parseInt(v_cade3);
        v_numb4 =Integer.parseInt(v_cade4);
    }
    void m_doDifferences(){
        System.out.print(Math.abs(v_numb2 - v_numb1)+" ");
        System.out.print(Math.abs(v_numb2 - v_numb3)+" ");
        System.out.print(Math.abs(v_numb3 - v_numb4));
    }
}