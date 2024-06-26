import java.util.Scanner;
public class p173 {
    int a_Cases, a_incrCases, a_number, a_area=1, a_incrNumerous=1;
    Scanner a_keyboard;
    public static void main(String[] args){
        p173 object=new p173();
        object.m_acceptData();
        object.m_calcArea();
    }
    p173(){
        a_keyboard =new Scanner(System.in);
    }
    void m_acceptData(){
        a_Cases = a_keyboard.nextInt();
    }
    void m_calcArea(){
        while(a_incrCases < a_Cases){
            a_number = a_keyboard.nextInt();
            while (a_incrNumerous <= a_number){
                a_area+= a_incrNumerous * 4;
                a_area=a_area- 4;
                a_incrNumerous++;
            }
            System.out.println(a_area);
            a_area=1;
            a_incrNumerous =1;
            a_incrCases++;
        }
    }
}