package spil;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class players {
    private String usrInput;
    private String[] players;
    private Scanner sc = new Scanner(System.in);
    public String[] playerNames(int playerCount) {

        players = new String[playerCount];
        for (int i = 1; i <= playerCount; i++) {

            System.out.println("Enter name of player number: " + i + ".");
            usrInput = sc.nextLine();
            players[i - 1] = usrInput;
        }
        return players;
    }
}
class diceThrow {
    int dice1 = new Random().nextInt(1, 7);
    int dice2 = new Random().nextInt(1, 7);
    int dices = dice1 + dice2;
    }
class turn {
    private int start = 0, normalTurn, playerCount;
    public void playerCount(int playerCount){
        this.playerCount = playerCount;
    }
    public int currentTurn(int turn) {
        if (start == 0) {
            start += 1;
            normalTurn = new Random().nextInt(playerCount);
            normalTurn += 1;
        }
        else {
            normalTurn += turn;
        }
        return normalTurn;
    }
}
class gameRules {
    private diceThrow dices = new diceThrow();
    private int dice1 = dices.dice1;
    private int dice2 = dices.dice1;
    private int p1dice1, p1dice2, p2dice1, p2dice2;
    String win = "Player wins";
    public void getMainGame(int dice1,int dice2,int p1dice1,int p1dice2,int p2dice1,int p2dice2) {
        int mainGame;
        if (dice1 == 6 && dice2 == 6 && p1dice1 == 6 && p1dice2 == 6) {


        }
    }
}

public class Main{
    public static void main(String[] args) {
        // This section only launches the objects except for playerCount as it's used in mutiple objects
        int playerCount;
        diceThrow dc = new diceThrow();
        System.out.println(dc.dices);
        players player = new players();
        Scanner sc = new Scanner(System.in);
        playerCount = sc.nextInt();

        String[] me = player.playerNames(playerCount);
        System.out.println(Arrays.toString(me));

        if (playerCount == 0) {
            System.out.println("NO");
        }

        turn tur = new turn();
        tur.playerCount(playerCount);


    }
}