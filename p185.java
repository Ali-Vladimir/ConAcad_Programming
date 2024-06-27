import java.util.Scanner;
import java.text.DecimalFormat;

public class p185 {
    float v_broad,v_largo,a_area;
    public static void main(String[] args) {
        p185 object=new p185();
        object.m_acceptData();
        object.m_conv1();
        object.m_conv2();
        object.m_conv3();
        object.m_printResult();
    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        v_broad =v_keyboard.nextFloat();
        v_largo=v_keyboard.nextFloat();
    }
    void m_conv1(){
        a_area= v_broad *v_largo;
        a_area=(a_area/3)*2;
        a_area/=1.8;
    }
    void m_conv2(){
        a_area*=3;
        a_area/=1.5;
    }
    void m_conv3(){
        a_area*=0.750;
        a_area/=2.5;
    }
    void m_printResult(){
        DecimalFormat decimoles=new DecimalFormat("##.##");
        System.out.println(decimoles.format(a_area));
    }
}