import java.util.Scanner;

public class p150 {
    public static void main(String[] args) {
        Problems object=new Problems();
        object.m_decideTime();
    }
}
class Problems {
    Scanner a_keyboard;
    int a_numbCases, a_camino, a_ages;
    float a_distance, a_time;
    Problems(){
        a_keyboard =new Scanner(System.in);
        a_numbCases = a_keyboard.nextInt();
    }
    void m_decideTime(){
        int v_numbEspecial=0, v_timeLimit, v_totals=0, v_incrCases=0;
        while(v_incrCases< a_numbCases){
            a_distance = a_keyboard.nextInt();
            a_time = a_keyboard.nextInt();
            a_camino= a_keyboard.nextInt();
            do{
                a_ages = a_keyboard.nextInt();
                if(a_ages >=65 || a_ages <14) v_numbEspecial+=1;
                v_totals+=1;
            }while(a_ages !=0);
            v_numbEspecial-=1;
            v_totals-=1;
            v_totals=v_totals/2;
            if(v_numbEspecial>v_totals){
                if(a_camino==1){
                    a_time = a_time - (a_distance /2) *60;
                }
                else {
                    a_time = a_time -(float)(a_distance /0.5)*60;
                }
                v_timeLimit=(int)(a_time);
                System.out.println(v_timeLimit);
            }
            else if(a_camino==1){
                a_time = a_time - (a_distance /3) *60;
                v_timeLimit=(int)(a_time);
                System.out.println(v_timeLimit);}
            else{
                a_time = a_time - a_distance *60;
                v_timeLimit=(int)(a_time);
                System.out.println(v_timeLimit);}
            v_totals=0;
            v_numbEspecial=0;
            v_incrCases++;
        }
    }
}


