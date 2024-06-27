import java.util.*;

public class p189 {
    byte a_player1Turn1, a_player2Turn1, a_player3Turn1, a_player1Turn2, a_player2Turn2, a_player3Turn2;
    public static void main(String[] args) {
        p189 object=new p189();
        object.m_acceptData();
        object.m_addScore();
        object.m_mostPodio();

    }
    void m_acceptData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_player1Turn1 =v_keyboard.nextByte();
        a_player2Turn1 =v_keyboard.nextByte();
        a_player3Turn1 =v_keyboard.nextByte();
        a_player1Turn2 =v_keyboard.nextByte();
        a_player2Turn2 =v_keyboard.nextByte();
        a_player3Turn2 =v_keyboard.nextByte();
    }
    void m_addScore(){
        a_player1Turn1 += a_player1Turn2;
        a_player2Turn1 += a_player2Turn2;
        a_player3Turn1 += a_player3Turn2;
    }
    void m_mostPodio(){
        if (a_player1Turn1 > a_player2Turn1 && a_player1Turn1 > a_player3Turn1){
            if (a_player2Turn1 > a_player3Turn1){System.out.println("1 y 3");}
            else{System.out.println("1 y 2");}
        }
        else{
            if (a_player2Turn1 > a_player1Turn1 && a_player2Turn1 > a_player3Turn1){
                if (a_player1Turn1 > a_player3Turn1){System.out.println("2 y 3");}
                else{System.out.println("2 y 1");}
            }
            else{
                if(a_player3Turn1 > a_player1Turn1 && a_player3Turn1 > a_player2Turn1){
                    if(a_player1Turn1 > a_player2Turn1){System.out.println("3 y 2");}
                    else {System.out.println("3 y 1");}
                }
            }
        }
    }
}

