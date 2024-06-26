import java.util.Scanner;

public class p180 {

    float v_datoa, v_datob, v_datoc, v_datoa1, v_datob1, v_datoc1, v_datoa2, v_datob2, v_datoc2, v_datoa3, v_datob3, v_datoc3;

    public static void main(String[] args){

        p180 object=new p180();
        object.m_acepDatos();
        object.m_potentiate();
        object.m_redound();
        object.m_check();

    }
    void m_acepDatos(){
        Scanner v_keyboard=new Scanner(System.in);

        v_datoa=v_keyboard.nextFloat();
        v_datob=v_keyboard.nextFloat();
        v_datoc=v_keyboard.nextFloat();

        v_datoa1=v_keyboard.nextFloat();
        v_datob1=v_keyboard.nextFloat();
        v_datoc1=v_keyboard.nextFloat();

        v_datoa2=v_keyboard.nextFloat();
        v_datob2=v_keyboard.nextFloat();
        v_datoc2=v_keyboard.nextFloat();

        v_datoa3=v_keyboard.nextFloat();
        v_datob3=v_keyboard.nextFloat();
        v_datoc3=v_keyboard.nextFloat();

    }
    void m_potentiate(){

        v_datoa=(v_datoa*v_datoa);
        v_datob=(v_datob*v_datob);
        v_datoc=(v_datoc*v_datoc);

        v_datoa1=(v_datoa1*v_datoa1);
        v_datob1=(v_datob1*v_datob1);
        v_datoc1=(v_datoc1*v_datoc1);

        v_datoa2=(v_datoa2*v_datoa2);
        v_datob2=(v_datob2*v_datob2);
        v_datoc2=(v_datoc2*v_datoc2);

        v_datoa3=(v_datoa3*v_datoa3);
        v_datob3=(v_datob3*v_datob3);
        v_datoc3=(v_datoc3*v_datoc3);
    }
    void m_redound(){

        v_datoa=Math.round(v_datoa*100);
        v_datoa=v_datoa/100;
        v_datob=Math.round(v_datob*100);
        v_datob=v_datob/100;
        v_datoc=Math.round(v_datoc*100);
        v_datoc=v_datoc/100;

        v_datoa1=Math.round(v_datoa1*100);
        v_datoa1=v_datoa1/100;
        v_datob1=Math.round(v_datob1*100);
        v_datob1=v_datob1/100;
        v_datoc1=Math.round(v_datoc1*100);
        v_datoc1=v_datoc1/100;

        v_datoa2=Math.round(v_datoa2*100);
        v_datoa2=v_datoa2/100;
        v_datob2=Math.round(v_datob2*100);
        v_datob2=v_datob2/100;
        v_datoc2=Math.round(v_datoc2*100);
        v_datoc2=v_datoc2/100;

        v_datoa3=Math.round(v_datoa3*100);
        v_datoa3=v_datoa3/100;
        v_datob3=Math.round(v_datob3*100);
        v_datob3=v_datob3/100;
        v_datoc3=Math.round(v_datoc3*100);
        v_datoc3=v_datoc3/100;
    }
    void m_check(){

        if (v_datoa+v_datob==v_datoc)System.out.println("CUMPLE"); else System.out.println("NO CUMPLE");

        if (v_datoa1+v_datob1==v_datoc1)System.out.println("CUMPLE"); else System.out.println("NO CUMPLE");

        if (v_datoa2+v_datob2==v_datoc2)System.out.println("CUMPLE"); else System.out.println("NO CUMPLE");

        if (v_datoa3+v_datob3==v_datoc3)System.out.println("CUMPLE"); else System.out.println("NO CUMPLE");
    }
}


