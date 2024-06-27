import java.util.*;
import java.io.RandomAccessFile;

public class p357 {
    public static void main(String[] args) throws Exception {
        BinariesData object=new BinariesData();
        object.m_readFileName();
    }
}
class BinariesData {
    Scanner a_keyboard;
    int a_numberFloats =0, a_numberIntegers =0;
    BinariesData(){
        a_keyboard =new Scanner(System.in);
    }
    void m_readFileName(){
        String v_fileName;
        v_fileName= a_keyboard.nextLine();
        m_processName(v_fileName);
    }
    void m_processName(String p_direction){
        boolean v_flag=true;
        float v_unknownNumber=0;
        try(RandomAccessFile file=new RandomAccessFile(p_direction,"r")){
            while(v_flag){
                try{
                    v_unknownNumber=file.readFloat();
                }catch(Exception i){
                    v_flag=false;
                }
                if(v_flag) m_determineType(v_unknownNumber);
            }
        }catch(Exception _){
        }
        m_prints();
    }
    void m_determineType(double p_number){
        String v_aux=p_number+" ";
        if(v_aux.contains("E")) a_numberIntegers++;
        else a_numberFloats++;

    }
    void m_prints(){
        System.out.println("I "+ a_numberIntegers);
        System.out.println("F "+ a_numberFloats);
    }
}