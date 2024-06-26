import java.util.Scanner;

public class p178 {
    int a_Cases;
    float a_depotInitial, a_growthRate, a_amount;
    Scanner a_keyboard;
    public static void main(String[] args) {
        p178 object=new p178();
        object.m_aceCases();
        object.m_calcGrowthRate();

    }
    p178(){
        a_keyboard =new Scanner(System.in);
    }
    void m_aceCases(){
        a_Cases = a_keyboard.nextInt();
    }
    void m_calcGrowthRate(){
        int v_incrCases=0, v_counter=0;
        float v_growth;
        while(v_incrCases< a_Cases){
            a_depotInitial = a_keyboard.nextFloat();
            if(a_depotInitial <=0){ a_keyboard.nextFloat(); a_keyboard.nextFloat(); System.out.println("-1");}
            else{
                a_growthRate = a_keyboard.nextFloat();
                if(a_growthRate >100 || a_growthRate <1){ a_keyboard.nextFloat(); System.out.println("-1");}
                else{
                    a_amount = a_keyboard.nextFloat();
                    if(a_amount <= a_depotInitial) System.out.println("0");
                    else{
                        a_growthRate /=100;
                        while(a_depotInitial <= a_amount){
                            v_growth= a_depotInitial;
                            v_growth*= a_growthRate;
                            a_depotInitial +=v_growth;
                            ++v_counter;
                        }
                        System.out.println(v_counter);
                        v_counter=0;
                        a_depotInitial =0;
                    }
                }
            }
            ++v_incrCases;
        }
    }
}


