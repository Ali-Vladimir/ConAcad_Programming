import java.util.Scanner;
public class p1 {
    public static void main(String[] args) {
        Scanner a_keyboard = new Scanner(System.in);
        Sum objet1 = new Sum();
        System.out.println(objet1.m_sum(a_keyboard.nextInt(), a_keyboard.nextInt()));
    }
}
class Sum {
    int m_sum(int p_number1, int p_number2) {
        p_number1+=p_number2;
        return p_number1;
    }
}
