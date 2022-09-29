package spil;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import gui_main.GUI;

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
    private int playerCount;
    private int turn;

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
    public void setTurn(int turn){ this.turn = turn; }

    private int throwDice1 = new Random().nextInt(1, 7);
    private int throwDice2 = new Random().nextInt(1, 7);
    private int dices = throwDice1 + throwDice2;
    private int[] pdice1 = new int[playerCount];
    private int[] pdice2 = new int[playerCount];
    private int dice1 = throwDice1, dice2 = throwDice2;

    public int getThrowDice1(){
        return throwDice1;
    }
    public int getThrowDice2(){
        return throwDice2;
    }
    public int getDice1(){
        return dice1;
    }
    public int getDice2(){
        return dice2;
    }
    public int getDices(){
        return dices;
    }
    public int[] pdice1(){
        pdice1[turn - 1] = throwDice1;
        return pdice1;
    }
    public int[] pdice2(){
        pdice2[turn - 1] = throwDice1;
        return pdice2;
    }


}
class turn {
    private int start = -1, normalTurn, playerCount;
    //
    public void setPrevTurn(){
        this.normalTurn -= 1;
    }
    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }
    public int nextTurn() {
        if (start <= 0) {
            start += 1;
            normalTurn = new Random().nextInt(playerCount);
            normalTurn += 1;
        }
        else {
            normalTurn += 1;
        }
        return normalTurn;
    }
    public int currentTurn(){
        return normalTurn;
    }
}
class scoreBoard {
    String[] scoreBoard;
    int[] score;
}

public class Main{

    public static void main(String[] args) {
        players players = new players();
        diceThrow diceThrow = new diceThrow();
        turn turn = new turn();
        Scanner sc = new Scanner(System.in);
        scoreBoard scoreBoard = new scoreBoard();

        System.out.print("Welcome, please enter the amount of players at the table: ");
        int playerCount = sc.nextInt();
        String[] currentPlayers = players.playerNames(playerCount);
        diceThrow.setPlayerCount(playerCount);

        turn.setPlayerCount(playerCount);
        System.out.println("Thank you, scores will show up in console. Dices on screen.");
        System.out.println("Choosing random player as first player: ");
        System.out.println(currentPlayers[turn.currentTurn()] + " Starts the game. Press enter to launch game:");
        sc.nextLine();

        GUI gui = new GUI();
        gui.showMessage(currentPlayers[turn.currentTurn()] + " press 'OK' to throw the dice");
        int[] dices = {diceThrow.getDice1(), diceThrow.getDice2()};
        int[] pdices = new int[1];
        gui.setDice(dices[0], dices[1]);
        System.out.println(dices);

        while (true){
            if (dices[0] == 6 && dices[1] == 6 && pdices[0] == 6 && pdices[1] == 6){
                System.out.println(currentPlayers[turn.currentTurn()] + " has won the game, congrats!");
                break;
            }
            else if (scoreBoard.score[turn.currentTurn()] >= 40 && dices[0] == dices[1]){
                System.out.println(currentPlayers[turn.currentTurn()] + " has won the game, congrats!");
                break;
            }
            else if (pdices[0] == pdices[1] && diceThrow.getDices() == 0){
                System.out.println("Sorry, you lost all of your points :(");
                scoreBoard.score[turn.currentTurn()] = 0;
            }
            else if (pdices[0] == pdices[1]){
                System.out.println("Congrats, you got an extra turn!");
            }
            else {
                scoreBoard.score[turn.currentTurn()] += diceThrow.getDices();
            }
        }
    }
}