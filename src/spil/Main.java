package spil;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import gui_main.GUI;

// Saves player names
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
// Throws the dices
class diceThrow {
    private int playerCount, turn;

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
    public void setTurn(int turn){ this.turn = turn; }

    private int[] dices = {new Random().nextInt(1, 7), new Random().nextInt(1,7)};
    private int[] pdices1 = new int[playerCount];
    private int[] pdices2 = new int[playerCount];
    void setpDices() {
        this.pdices1 = new int[playerCount];
        this.pdices2 = new int[playerCount];
    }
    void setDices(){
        this.dices[0] = new Random().nextInt(1,7);
        this.dices[1] = new Random().nextInt(1,7);
        pdices1[turn] = dices[0];
        pdices2[turn] = dices[1];
    }

    public int[] getDices(){
        return dices;
    }
    public int[] pdice1(){
        return pdices1;
    }
    public int[] pdice2(){
        return pdices2;
    }


}
// Chooses whom turn it is
class turn {
    private int start = 0, normalTurn, playerCount;
    //
    public void setPrevTurn(){
        if (this.normalTurn - 1 < 0){
            normalTurn = playerCount - 1;
        }
        else {
            this.normalTurn -= 1;
        }
    }
    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }
    public int nextTurn() {
        if (start <= 0) {
            start += 1;
            normalTurn = new Random().nextInt(0, playerCount - 1);
            normalTurn += 1;
        }
        else {
            normalTurn += 1;
        }
        if (normalTurn > playerCount - 1){
            normalTurn = 0;
        }
        return normalTurn;
    }
    public int currentTurn(){
        return normalTurn;
    }
}
// Saves scores
class scoreBoard {
    String[] scoreBoard;
    int[] score;
}


public class Main{

    public static void main(String[] args) {

        // Initiates other classes
        players players = new players();
        diceThrow diceThrow = new diceThrow();
        turn turn = new turn();
        Scanner sc = new Scanner(System.in);
        scoreBoard scoreBoard = new scoreBoard();

        // Setting player count and names
        System.out.print("Welcome, please enter the amount of players at the table: ");
        int playerCount = sc.nextInt();

        // Sets the number of players in relevant classes.
        String[] currentPlayers = players.playerNames(playerCount);
        turn.setPlayerCount(playerCount);
        diceThrow.setPlayerCount(playerCount);diceThrow.setpDices();
        scoreBoard.score = new int[playerCount];
        // Choose player to start the game
        System.out.println("Thank you, scores will show up in console. Dices on gui.");
        System.out.println("Choosing random player as first player: ");
        System.out.println(currentPlayers[turn.currentTurn()] + " Starts the game. Press enter to launch game:");
        sc.nextLine();
        sc.nextLine();

        // Setup the GUI
        GUI gui = new GUI();
        gui.showMessage(currentPlayers[turn.currentTurn()] + " press 'OK' to throw the dice");
        // Throws the dices for the first time and saves pdices as a variable
        diceThrow.setTurn(turn.currentTurn());
        diceThrow.setDices();
        int[] dices = diceThrow.getDices();
        int[] pdices = new int[playerCount];
        // Shows dices on GUI
        gui.setDice(dices[0], dices[1]);
        System.out.println(Arrays.toString(dices));
        // Specific game rules. Class not made as all sub-classses is in use here. As such it would make no sense.
        while (true){
            // Extra-assignment 3
            if (dices[0] == 6 && dices[1] == 6 && pdices[0] == 6 && pdices[1] == 6){
                System.out.println(currentPlayers[turn.currentTurn()] + " has won the game, congrats!");
                break;
            }
            // extra-assignment 4
            else if (scoreBoard.score[turn.currentTurn()] >= 40 && dices[0] == dices[1]){
                System.out.println(currentPlayers[turn.currentTurn()] + " has won the game, congrats!");
                break;
            }
            // extra-assignment 1
            else if (dices[0] == dices[1] && dices[0] + dices[1] == 2){
                System.out.println("Sorry, you lost all of your points :(");
                scoreBoard.score[turn.currentTurn()] = 0;
            }
            // extra-assignment 2
            else if (dices[0] == dices[1]){
                System.out.println("Congrats, you got an extra turn!");
                scoreBoard.score[turn.currentTurn()] = dices[0] + dices[1];
                turn.setPrevTurn();
            }
            // primary assignment
            else {
                scoreBoard.score[turn.currentTurn()] += dices[0] + dices[1];
            }
            System.out.println(Arrays.toString(dices));
            // Players and scoreboard
            System.out.println(Arrays.toString(currentPlayers));
            System.out.println(Arrays.toString(scoreBoard.score));
            //Tests
            System.out.println(Arrays.toString(diceThrow.pdice1()));
            System.out.println(Arrays.toString(diceThrow.pdice2()));
            System.out.println(turn.currentTurn());
            gui.showMessage(currentPlayers[turn.currentTurn()] + "'s dices on the board. Click ok for next player");
            diceThrow.setTurn(turn.nextTurn());diceThrow.setTurn(turn.currentTurn());diceThrow.setDices();
            gui.setDice(dices[0],dices[1]);
            System.out.println();


        }
    }
}