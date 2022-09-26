package spil;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import gui_main.GUI;

class allPlayers {
    private String[] hiddenPlayers() {
        String usrInput;
        String[] players;
        Scanner sc = new Scanner(System.in);

        int playerCount = sc.nextInt();
        sc.nextLine();

        players = new String[playerCount];

        for (int i = 1; i <= playerCount; i++) {

            System.out.println("Enter name of player number: " + i + ".");
            usrInput = sc.nextLine();
            players[i - 1] = usrInput;

        }
        return players;
    }
    public String[] players(){
        return this.hiddenPlayers();
    }
}
class diceRolls {
    private int[] HiddenDices() {
        int dice1, dice2;
        dice1 = new Random().nextInt(1, 7);
        dice2 = new Random().nextInt(1, 7);
        int[] dices = {dice1, dice2};
        return dices;
    }
    public int[] dices(){
        return this.HiddenDices();
    }
}
class

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, please enter the amount of players participating: ");
        // Bruger en klasse til af definerer spillerne
        allPlayers players = new allPlayers();
        // Laver det om fra memmory kode til et array:
        String[] names = players.players();
        // Udskriver array, skal fjernes?
        System.out.println(Arrays.toString(names));
        System.out.println("Thank you, please proceed to the game:");
        GUI gui = new GUI();
        gui.showMessage("Player 1 press to start the game: ");

    }
}
