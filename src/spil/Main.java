package spil;

import java.util.Scanner;
import java.util.Random;
import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        // Indsætter værdier
        int dice1 = 0, dice2 = 0, pdice1, pdice2;
        int player1 = 0, player2 = 0;
        int turn = -1;

        // Start GUI
        GUI gui = new GUI();

        // Sætter et loop op, som stopper hvis enten spiller 1 eller spiller 2 vinder
        while (true) {
            // Gemmer forrige kast for at opfylde condition 3
            pdice1 = dice1;
            pdice2 = dice2;
            // Vælger hvilken spiller som skal slå terningen
            turn += 1;
            System.out.println(turn + " " + turn % 2);
            if (turn % 2 == 0) {
                System.out.println("Player 1 please roll the spil.dice, press 'ok'");
                String testuser = gui.getUserString("Player 1 next");
            } else if (turn % 2 != 0) {
                System.out.println("Player 2 please roll the spil.dice, press 'ok'");
                String testuser = gui.getUserString("Player 2 next");
            }
            // Laver to tilfældige tal mellem 1 og 6
            long start = System.currentTimeMillis();
            dice1 = new Random().nextInt(1, 7);
            dice2 = new Random().nextInt(1, 7);
            gui.setDice(dice1, dice2);
            long end = System.currentTimeMillis();
            System.out.println("Dice 1 roll: " + dice1 + ", spil.dice 2 roll: " + dice2 + ".");
            // indsætter parametre i prioriteret rækkefølge
            // Condition 3 fra opg
            if (dice1 == 6 && dice2 == 6 && pdice1 == 6 && pdice2 == 6) {
                if (turn % 2 == 0) {
                    System.out.println("Congrats, player1 won!");
                    break;
                } else if (turn % 2 != 0) {
                    System.out.println("Congrats, player2 won!");
                    break;
                }
            }
            // Condition 1 fra opg
            else if (dice1 == dice2 && dice1 + dice2 == 2) {
                System.out.println("Sorry, you lost all your points :(");
                if (turn % 2 == 0) {
                    player1 = 0;
                } else if (turn % 2 != 0) {
                    player2 = 0;
                }
            }
            // Condition 2 fra opg
            else if (dice1 == dice2 && (player2 < 40 || player1 < 40)) {
                System.out.println("Congrats, you got an extra try!");
                turn -= -1;
                if (turn % 2 != 0) {
                    player1 += (dice1 + dice2);
                } else if (turn % 2 == 0) {
                    player2 += (dice1 + dice2);
                }
            }
            // Condition 4 fra opg
            else if (dice1 == dice2 && (player1 >= 40 || player2 >= 40)) {
                if (player1 >= 40) {
                    System.out.println("Congrats, player 1 won!");
                    gui.close();
                    break;
                } else if (player2 >= 40) {
                    System.out.println("Congrats, player 2 won!");
                    gui.close();
                    break;
                }
                // hvis ingen condition
            } else {
                if (turn % 2 == 0) {
                    player1 += (dice1 + dice2);
                } else if (turn % 2 != 0) {
                    player2 += (dice1 + dice2);
                }
            }
            //regnskab
            long end2 = System.currentTimeMillis();
            System.out.println("It took: " + (end - start) + " ms to show the dice on the board!");
            System.out.println("It took: " + (end2 - start) + " ms to throw the dice and finish all the checks");
            System.out.println("Player 1 currently has: " + player1 + " points. Player 2 currently have: " + player2 + " points");
        }
    }
}