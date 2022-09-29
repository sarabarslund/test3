package test;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


class mig {
    private String ThisClass = "9";

}
class turn {
    int start = 0, normalTurn;

    int currentTurn(int turn) {
        if (start == 0) {
            start += 1;
            normalTurn = new Random().nextInt(turn);
            normalTurn += 1;
        }
        else {
            normalTurn += turn;
        }
        return normalTurn;
    }
}


public class test {
    public static void main(String[] args) {
        turn tur = new turn();
        System.out.println(tur.currentTurn(2));
        System.out.println(tur.currentTurn(2));
        System.out.println(tur.currentTurn(2));



        int[] pdice1 = {2,3,4};
        pdice1[0] = 3;
        }
    }

