import java.util.Scanner;

public class p302 {
    String v_data1, v_data2, v_data3, v_data4, v_data5, v_data6;
    public static void main(String[] args) throws Exception {
        p302 object=new p302();
        object.m_acceptData();
        object.m_sortThem();
    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        v_data1 =v_keyboard.nextLine();
        v_data2 =v_keyboard.nextLine();
        v_data3 =v_keyboard.nextLine();
        v_data4 =v_keyboard.nextLine();
        v_data5 =v_keyboard.nextLine();
        v_data6 =v_keyboard.nextLine();
    }
    void m_sortThem(){
        System.out.println(v_data6 +" "+ v_data3 +" "+ v_data2);
        System.out.println(v_data1 +" "+ v_data5 +" "+ v_data4);
    }
}