import java.util.Scanner;

public class p145 {
    public static void main(String[] args){
        Search object=new Search();
        object.m_acceptData();

    }
}

class Search {
    Scanner a_keyboard;
    int a_limitInferior,a_limitSuperior, a_dataToSearch;
    Search(){
        a_keyboard =new Scanner(System.in);
    }

    void m_acceptData(){
        do{
            a_limitInferior= a_keyboard.nextInt();
            a_limitSuperior= a_keyboard.nextInt();
            a_dataToSearch = a_keyboard.nextInt();
            m_checkNumbers();
        }while(a_limitInferior!=0 && a_limitSuperior!=0 && a_dataToSearch !=0);

    }
    void m_checkNumbers(){
        if(a_limitInferior!=0 && a_limitSuperior!=0 && a_dataToSearch !=0){
            if(a_limitInferior<0 && a_limitInferior== a_dataToSearch) m_NegativeBinarySearch();
            else if(a_dataToSearch <a_limitInferior || a_dataToSearch >a_limitSuperior) m_printComparison(-1);
            else if(a_limitInferior>0) m_PositiveBinarySearch();
            else m_binarySearch();
        }
    }
    void m_binarySearch(){
        int v_middleValue,v_counter=1;
        do{
            v_middleValue=(a_limitInferior+a_limitSuperior)/2;
            if(a_dataToSearch >v_middleValue) a_limitInferior=v_middleValue+1;
            else {a_limitSuperior=v_middleValue-1; a_limitInferior-=1;}
            v_counter++;
        }while(v_middleValue!= a_dataToSearch);
        m_printComparison(v_counter);
    }


    void m_NegativeBinarySearch(){
        int v_middleValue,v_counter=1;
        do{
            v_middleValue=(a_limitInferior+a_limitSuperior)/2;
            if(a_dataToSearch >v_middleValue) a_limitInferior=v_middleValue+1;
            else a_limitSuperior=v_middleValue-1;
            v_counter++;
        }while(v_middleValue!= a_dataToSearch);
        m_printComparison(v_counter);
    }

    void m_PositiveBinarySearch(){
        int v_middleValue,v_counter=1;
        do{
            v_middleValue=(a_limitInferior+a_limitSuperior)/2;
            if(a_dataToSearch >v_middleValue) a_limitInferior=v_middleValue+1;
            else {a_limitSuperior=v_middleValue; }
            v_counter++;
        }while(v_middleValue!= a_dataToSearch);
        m_printComparison(v_counter);
    }

    void m_printComparison(int p_result){
        System.out.println(p_result);
    }
}

