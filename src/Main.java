
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner brugerinput = new Scanner(System.in);
        int alder;
        //brugerinput = new java.util.Scanner(System.in);
        alder = brugerinput.nextInt();

        if (alder > 18) {
            System.out.println("Du er myndig");

        } else
            System.out.println("Du er ikke myndig");
    }
}