import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        Gears object=new Gears();
        object.m_acceptData();

    }
}
class Gears {
    Scanner a_keyboard;
    float a_speed;
    float a_numbGears;
    float a_lastGear;
    float a_firstGear;
    float a_resultant;
    float a_teeth;
    Gears(){
        a_keyboard =new Scanner(System.in);
        return;
    }
    void m_acceptData(){

        a_speed = a_keyboard.nextInt();
        while(a_speed !=-1){
            m_encontrarRPM();
            m_acceptData();
        }

    }

    void m_encontrarRPM(){
        float v_incrEngranajes=0, v_unavez=1;
        a_numbGears = a_keyboard.nextInt();
        while(v_incrEngranajes< a_numbGears){
            a_teeth = a_keyboard.nextInt();
            if(v_unavez==1) a_firstGear = a_teeth;
            a_lastGear = a_teeth;
            ++v_incrEngranajes;
            ++v_unavez;
        }
        m_mostResultado();
    }
    void m_mostResultado(){
        a_resultant = a_firstGear / a_lastGear;
        a_resultant *= a_speed;
        System.out.println((int) a_resultant);
    }
}



