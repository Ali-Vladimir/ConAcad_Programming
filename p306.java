import java.util.Scanner;

public class p306 {
    Scanner v_keyboard =new Scanner(System.in);
    String v_nombre, v_nombre1, v_nombre2, v_nombre3, v_vuelo, v_vuelo1, v_vuelo2, v_vuelo3;
    String v_horas, v_horas1, v_horas2, v_horas3, v_precio, v_precio1, v_precio2, v_precio3;
    byte v_horaInt, v_horaInt1, v_horaInt2, v_horaInt3;
    int v_precInt, v_precInt1, v_precInt2, v_precInt3;

    public static void main(String[] args) {
        p306 object=new p306();
        object.m_acepDatos();
        object.m_haceConversiones();
        object.m_mostResultados();

    }
    void m_acepDatos(){
        v_nombre= v_keyboard.nextLine();
        v_vuelo= v_keyboard.next();
        v_horas= v_keyboard.next();
        v_precio= v_keyboard.next();
    }
    void m_haceConversiones(){

        v_horaInt=Byte.parseByte(v_horas);
        v_horaInt1=Byte.parseByte(v_horas1);
        v_horaInt2=Byte.parseByte(v_horas2);
        v_horaInt3=Byte.parseByte(v_horas3);
        v_precInt=Integer.parseInt(v_precio);
        v_precInt1=Integer.parseInt(v_precio1);
        v_nombre1= v_keyboard.nextLine();
        v_vuelo1= v_keyboard.next();
        v_horas1= v_keyboard.next();
        v_precio1= v_keyboard.next();
        v_keyboard.nextLine();
        v_nombre2= v_keyboard.nextLine();
        v_vuelo2= v_keyboard.next();
        v_horas2= v_keyboard.next();
        v_precio2= v_keyboard.next();
        v_keyboard.nextLine();
        v_nombre3= v_keyboard.nextLine();
        v_vuelo3= v_keyboard.next();
        v_horas3= v_keyboard.next();
        v_precio3= v_keyboard.next();
        v_precInt2=Integer.parseInt(v_precio2);
        v_precInt3=Integer.parseInt(v_precio3);
    }
    void m_mostResultados(){
        switch(v_vuelo){

            case "NO": if (v_horaInt<24)System.out.println(v_nombre+" COMPRA"); else System.out.println(v_nombre+" NO COMPRA"); break;

            case "SI": if (v_horaInt<=6)System.out.println(v_nombre+" COMPRA"); else if (v_precInt<10000) System.out.println(v_nombre+" COMPRA"); else System.out.println(v_nombre+" NO COMPRA"); break;
        }
        switch(v_vuelo1){

            case "NO": if (v_horaInt1<24)System.out.println(v_nombre1+" COMPRA"); else System.out.println(v_nombre1+" NO COMPRA"); break;

            case "SI": if (v_horaInt1<=6)System.out.println(v_nombre1+" COMPRA"); else if (v_precInt1<10000) System.out.println(v_nombre1+" COMPRA"); else System.out.println(v_nombre1+" NO COMPRA"); break;
        }
        switch(v_vuelo2){

            case "NO": if (v_horaInt2<24)System.out.println(v_nombre2+" COMPRA"); else System.out.println(v_nombre2+" NO COMPRA"); break;

            case "SI": if (v_horaInt2<=6)System.out.println(v_nombre2+" COMPRA"); else if (v_precInt2<10000) System.out.println(v_nombre2+" COMPRA"); else System.out.println(v_nombre2+" NO COMPRA"); break;
        }
        switch(v_vuelo3){

            case "NO": if (v_horaInt3<24)System.out.println(v_nombre3+" COMPRA"); else System.out.println(v_nombre3+" NO COMPRA"); break;

            case "SI": if (v_horaInt3<=6)System.out.println(v_nombre3+" COMPRA"); else if (v_precInt3<10000) System.out.println(v_nombre3+" COMPRA"); else System.out.println(v_nombre3+" NO COMPRA"); break;
        }

    }}

