import java.util.Scanner;

public class p325 {
    public static void main(String[] args) throws Exception {
        LaDispersionHASH object=new LaDispersionHASH();
        object.m_acceptCases();
    }
}
class LaDispersionHASH{
    Scanner a_keyboard;
    String[] a_separateNames;
    String[] a_array;
    float a_collisions =0;
    LaDispersionHASH(){
        a_keyboard =new Scanner(System.in);
    }
    void m_printPercentCollision(){
        int v_percentage;
        v_percentage=(int)(a_collisions /a_array.length*100);
        System.out.println(v_percentage+"%");
    }
    void m_acceptCases(){
        byte v_numbCases,v_iterator=0;
        v_numbCases=Byte.parseByte(a_keyboard.nextLine());
        while(v_iterator<v_numbCases){
            m_acceptNames();
            m_convertKeys();
            v_iterator++;
            m_printPercentCollision();
            a_collisions =0;
        }

    }
    void m_acceptNames(){
        String v_string;
        v_string= a_keyboard.nextLine();
        a_separateNames =v_string.split(":");
        a_array=new String[a_separateNames.length];
    }
    void m_convertKeys(){
        int v_iterator=0;
        while(v_iterator< a_separateNames.length){
            m_bending(a_separateNames[v_iterator]);
            v_iterator++;
        }
    }
    void m_bending(String p_name){
        char[] v_lettres=p_name.toCharArray();
        int v_iterator=0;
        double v_key;
        String v_number="";
        while(v_iterator<v_lettres.length){
            v_number=v_number+(int)(v_lettres[v_iterator]);
            v_iterator++;
        }
        v_key= m_getDoubledValue(v_number)%a_array.length;
        m_store(v_key);
    }
    void m_store(double p_position){
        if(a_array[(int)(p_position)]==null) a_array[(int)(p_position)]="lleno";
        else ++a_collisions;
    }
    double m_getDoubledValue(String p_number){
        double v_half1,v_half2;
        int v_iterator=0;
        String v_aux="";
        char[] v_number=p_number.toCharArray();
        while(v_iterator<v_number.length/2){
            v_aux=v_aux+v_number[v_iterator];
            v_iterator++;
        }
        v_half1=Double.parseDouble(v_aux);
        v_aux="";
        while(v_iterator<v_number.length){
            v_aux=v_aux+v_number[v_iterator];
            v_iterator++;
        }
        v_half2=Double.parseDouble(v_aux);
        return (v_half1+v_half2);
    }
}