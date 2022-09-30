package spil;

import java.util.Random;
import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        // Indsætter værdier
        int dice1 = 0, dice2 = 0, p1dice1 = 0, p1dice2 = 0, p2dice1 = 0, p2dice2 = 0;
        int player1 = 0, player2 = 0;
        int turn = -1;
        //
        // Start GUI
        GUI gui = new GUI();

        // Sætter et loop op, som stopper hvis enten spiller 1 eller spiller 2 vinder
        while (true) {
            long end3 = System.currentTimeMillis();
            // Gemmer forrige kast for at opfylde condition 3

            // Vælger hvilken spiller som skal slå terningen
            turn++;
            System.out.println(turn + " " + turn % 2);
            if (turn % 2 == 0) {
                p1dice1 = dice1;
                p1dice2 = dice2;
                System.out.println("Player 1 please roll the spil.dice, press 'ok'");
                gui.showMessage("Player 1 now");
            } else {
                p2dice1 = dice1;
                p2dice2 = dice2;
                System.out.println("Player 2 please roll the spil.dice, press 'ok'");
                gui.showMessage("Player 2 now");
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
            // Hvis en spiller har fpet to 6'ere to gange i streg har spilleren vundet
            if ((dice1 == 6 && dice2 == 6 && p1dice1 == 6 && p1dice2 == 6 && turn % 2 == 0 ) || (dice1 == 6 && dice2 == 6 && p2dice1 == 6 && p2dice2 == 6 && turn % 2 != 0 )) {
                if (turn % 2 == 0) {
                    System.out.println("Congrats, player1 won!");
                    gui.close();
                    break;
                } else {
                    System.out.println("Congrats, player2 won!");
                    gui.close();
                    break;
                }
            }
            // Condition 1 fra opg
            else if (dice1 == dice2 && dice1 + dice2 == 2) {
                System.out.println("Sorry, you lost all your points :(");
                if (turn % 2 == 0) {
                    player1 = 0;
                } else {
                    player2 = 0;
                }
            }
            // Condition 2 fra opg
            else if (dice1 == dice2 && ((turn % 2 == 0 && player1 < 40) || (turn % 2 != 0 && player2 < 40))) {
                System.out.println("Congrats, you got an extra try!");
                turn--;
                if (turn % 2 != 0) {
                    player1 += (dice1 + dice2);
                } else {
                    player2 += (dice1 + dice2);
                }
            }
            // Condition 4 fra opg
            else if (dice1 == dice2) {
                if (player1 >= 40) {
                    System.out.println("Congrats, player 1 won!");
                    gui.close();
                    break;
                } else {
                    System.out.println("Congrats, player 2 won!");
                    gui.close();
                    break;
                }
                // hvis ingen condition
            } else {
                if (turn % 2 == 0) {
                    player1 += (dice1 + dice2);
                } else {
                    player2 += (dice1 + dice2);
                }
            }
            //regnskab
            long end2 = System.currentTimeMillis();
            System.out.println("Player 1 currently has: " + player1 + " points. Player 2 currently have: " + player2 + " points");
        }
    }
}
