import java.util.Scanner;
public class p304 {
    String a_name, a_sportActivity, a_socialActivity, a_environmentActivity;
    float a_cali1, a_cali2, a_cali3;
    float a_aux;
    int a_caliFinal;
    Scanner a_keyboard;
    public static void main(String[] args) {
        p304 object=new p304();
        object.m_acceptData();
        object.m_obtainAverage();
        object.m_sumaBono();
        object.m_printResult();
        object.m_acceptData();
        object.m_obtainAverage();
        object.m_sumaBono();
        object.m_printResult();
        object.m_acceptData();
        object.m_obtainAverage();
        object.m_sumaBono();
        object.m_printResult();

    }
    p304(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        a_name = a_keyboard.nextLine();
        a_cali1= a_keyboard.nextFloat();
        a_cali2= a_keyboard.nextFloat();
        a_cali3= a_keyboard.nextFloat();
        a_sportActivity = a_keyboard.next().toUpperCase();
        a_socialActivity = a_keyboard.next().toUpperCase();
        a_environmentActivity = a_keyboard.nextLine().toUpperCase();
        a_environmentActivity = a_environmentActivity.trim();
    }
    void m_obtainAverage(){
        a_aux=(a_cali1+a_cali2+a_cali3)/3;
    }
    void m_sumaBono(){
        switch(a_sportActivity){
            case"SI":if(a_socialActivity.equals("SI")&& a_environmentActivity.equals("SI")) a_aux=((a_aux*30)/100)+a_aux;
            else if (a_socialActivity.equals("NO")&& a_environmentActivity.equals("NO")) a_aux=((a_aux*5)/100)+a_aux;
            else a_aux=((a_aux*20)/100)+a_aux; break;

            case"NO":if(a_socialActivity.equals("NO")&& a_environmentActivity.equals("NO")) a_aux+=0;
            else if (a_socialActivity.equals("SI")&& a_environmentActivity.equals("SI")) a_aux=((a_aux*20)/100)+a_aux;
            else a_aux=((a_aux*10)/100)+a_aux; break;
        }
    }
    void m_printResult(){
        a_caliFinal=(int)Math.floor(a_aux);
        if (a_caliFinal<100) System.out.println(a_name +" "+a_caliFinal); else System.out.println(a_name +" 100");
    }
}