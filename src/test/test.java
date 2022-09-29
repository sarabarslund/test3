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



        int throwDice1 = new Random().nextInt(1, 7);
        int throwDice2 = new Random().nextInt(1, 7);
        int dices = throwDice1 + throwDice2;

        System.out.println(throwDice1 +" | " + throwDice2 + " | " + dices);

        }
    }

