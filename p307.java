import java.util.Scanner;
public class p307 {
    String a_type, a_data0, a_data1;
    float a_data2, a_data3, a_data4, a_data5;
    Scanner a_keyboard;
    public static void main(String[] args) {
        p307 object=new p307();
        object.m_acceptData();
        object.m_doOperations();
        object.m_acceptData();
        object.m_doOperations();
        object.m_acceptData();
        object.m_doOperations();
        object.m_acceptData();
        object.m_doOperations();
    }
    p307(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        a_type = a_keyboard.next();
        a_data0 = a_keyboard.next();
        a_data1 = a_keyboard.next();
        a_type = a_type.trim();
    }
    void m_doOperations(){
        a_data2 =Float.parseFloat(a_data0);
        a_data3 =Float.parseFloat(a_data1);
        switch(a_type){
            case "P":
                a_data4 =(float)Math.cos(Math.toRadians(a_data3)); a_data4 = a_data2 * a_data4; a_data4 *=10; a_data4 =(int)(a_data4); a_data4 /=10;
                System.out.print("X="+ a_data4);
                a_data5 =(float)Math.sin(Math.toRadians(a_data3)); a_data5 = a_data2 * a_data5; a_data5 *=10; a_data5 =(int)(a_data5); a_data5 /=10;
                System.out.println(" Y="+ a_data5); break;
            case "C":
                a_data4 = a_data2 * a_data2; a_data5 = a_data3 * a_data3; a_data4 =(float)Math.sqrt(a_data4 + a_data5); a_data4 *=10; a_data4 =(int)(a_data4); a_data4 /=10;
                System.out.print("r="+ a_data4 +" ");
                a_data4 = a_data3 / a_data2; a_data5 =(float)Math.atan(a_data4); a_data5 *= (float) (180/3.1415); a_data5 *=10; a_data5 =(int)(a_data5); a_data5 /=10;
                System.out.println("t="+ a_data5); break;
        }
    }
}


