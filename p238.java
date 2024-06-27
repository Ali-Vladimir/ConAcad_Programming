import java.util.Scanner;

public class p328 {
    private String a_name1, a_name2, a_name3;
    private byte a_age1, a_age2, a_age3;
    Scanner a_keyboard;
    public static void main(String[] args) {
        p328 object = new p328();
        object.m_doComparison();
    }
    public p328() {
        a_keyboard = new Scanner(System.in);
    }
    public void m_doComparison() {
        for (int i = 0; i < 3; i++) {
            m_acceptData();
            m_compareAges();
        }
    }
    public void m_acceptData() {
        a_name1 = a_keyboard.next();
        a_age1 = Byte.parseByte(a_keyboard.next());
        a_name2 = a_keyboard.next();
        a_age2 = Byte.parseByte(a_keyboard.next());
        a_name3 = a_keyboard.next();
        a_age3 = Byte.parseByte(a_keyboard.next());
    }
    public void m_compareAges() {
        if (a_age1 == a_age2 && a_age1 == a_age3) {
            System.out.println(a_name1 + " " + a_name2 + " " + a_name3);
        } else if (a_age1 >= a_age2 && a_age1 >= a_age3) {
            if (a_age1 == a_age2) {
                System.out.println(a_name1 + " " + a_name2);
            } else if (a_age1 == a_age3) {
                System.out.println(a_name1 + " " + a_name3);
            } else {
                System.out.println(a_name1);
            }
        } else if (a_age2 >= a_age1 && a_age2 >= a_age3) {
            if (a_age2 == a_age1) {
                System.out.println(a_name1 + " " + a_name2);
            } else if (a_age2 == a_age3) {
                System.out.println(a_name2 + " " + a_name3);
            } else {
                System.out.println(a_name2);
            }
        } else if (a_age3 >= a_age1 && a_age3 >= a_age2) {
            if (a_age3 == a_age1) {
                System.out.println(a_name1 + " " + a_name3);
            } else if (a_age3 == a_age2) {
                System.out.println(a_name2 + " " + a_name3);
            } else {
                System.out.println(a_name3);
            }
        }
    }
}