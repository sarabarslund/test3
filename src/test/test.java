package test;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import spil.Main;


class mig {
    private String ThisClass = "9";

}

public class test {
    public static void main(String[] args) {




        int throwDice1 = new Random().nextInt(1, 7);
        int throwDice2 = new Random().nextInt(1, 7);
        int dices = throwDice1 + throwDice2;

        System.out.println(throwDice1 +" | " + throwDice2 + " | " + dices);

        }
    }

