import java.util.Scanner;

public class p319 {
    String a_name1, a_name2, a_name3, a_name4, a_name5, a_name6, a_name7, a_name8, a_name9;
    int a_age1, a_age2, a_age3, a_age4, a_age5, a_age6, a_age7, a_age8, a_age9;
    public static void main(String[] args) {
        p319 object=new p319();
        object.m_acceptData();
        object.m_doFirstCase1();
        object.m_doSecondCase2();
        object.m_doThirdCase3();
    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_name1 =v_keyboard.nextLine();
        a_name2 =v_keyboard.nextLine();
        a_name3 =v_keyboard.nextLine();
        a_age1 =v_keyboard.nextInt();
        a_name4 =v_keyboard.next();
        a_name5 =v_keyboard.next();
        a_name6 =v_keyboard.next();
        a_age4 =v_keyboard.nextInt();
        a_name7 =v_keyboard.next();
        a_name8 =v_keyboard.next();
        a_name9 =v_keyboard.next();
        a_age7 =v_keyboard.nextInt();
    }
    void m_doFirstCase1(){
        a_age2 = a_age1 -2;
        a_age3 = a_age2 -3;
        System.out.println("SOY "+ a_name3 +" Y TENGO "+ a_age3);
    }
    void m_doSecondCase2(){
        a_age5 = a_age4 -2;
        a_age6 = a_age5 -3;
        System.out.println("SOY "+ a_name6 +" Y TENGO "+ a_age6);
    }
    void m_doThirdCase3(){
        a_age8 = a_age7 -2;
        a_age9 = a_age8 -3;
        System.out.println("SOY "+ a_name9 +" Y TENGO "+ a_age9);
    }
}