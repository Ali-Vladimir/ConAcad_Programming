import java.util.Scanner;
import java.text.DecimalFormat;
public class p298 {
    float v_valueT, v_valueY, v_valueZ;
    public static void main(String[] args) throws Exception {

        p298 object=new p298();
        object.m_acceptData();
        object.m_doOperations();
    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        v_valueZ =v_keyboard.nextFloat();
        v_valueY =v_keyboard.nextFloat();
        v_valueT =v_keyboard.nextFloat();
    }
    void m_doOperations(){
        DecimalFormat decimoles=new DecimalFormat("###.###");
        System.out.println(decimoles.format(Math.sqrt(18*Math.pow(v_valueZ,2) -4*Math.pow(v_valueT,6)* v_valueY)/Math.pow(v_valueT,3)));

    }
}