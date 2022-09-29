package test;

import java.util.Random;
public class test {
    public static void main(String[] args) {
        int sumOfRolls, sides = 6, dice1, dice2, count=0;
        int[] arr;
        arr = new int[(sides * 2) + 1];


        for (int i = 0; i < 1000; i++) { //Repeats 1000 times
            dice1 = new Random().nextInt(1, 7);
            dice2 = new Random().nextInt(1, 7);
            sumOfRolls = dice1 + dice2; //Sums both rolls
            if (dice1==dice2){
                count++; //Counts instances
            }
            for (int j = 2; j < (sides * 2) + 1; j++) { //Goes through all the possible values of sums of roll
                if (sumOfRolls == j) { //Checks if sum of rolls is equal to the value presented by the for loop
                    arr[j]++; //Adds that value to array
                }
            }
        }
        System.out.println("\n\n\nRoll Total  Frequency");
        System.out.println("---------------------");
        for (int i = 2; i < (sides * 2) + 1; i++) { //Displays each value of array
            System.out.print(i + "           " + arr[i] + "\n");
        }
        System.out.println("instances of rolls with two of a kind:\n"+count);

    }
}