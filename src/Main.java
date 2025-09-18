import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(".......Velkommen.......");
        System.out.println("tryk 1 for at starte");
        System.out.println("tryk 2 for at afslutte");
        int menu = input.nextInt();

        if (menu == 1) {
            playGame();
        } else if (menu==2) {
            System.out.println("afslutter Programmet");
            System.exit(0);
        } else {
            System.out.println("ugyldigt kommando");
        }
    }

    public static int difficulty(Scanner input) {

        System.out.println("Vælg sværhedsgrad: \n1. let 1-10 \n2. mellem 1-50 \n3. svær 1-100");
        int max;

        switch (max = input.nextInt()) {
            case 1: max = 10; break;
            case 2: max = 50; break;
            case 3: max = 100; break;
            default:
                System.out.println("ugyldig sværhedsgrad prøv igen");
        }
        return max;
    }
    public static int randomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max+1);
    }

    public static void playGame() {
        Scanner input = new Scanner(System.in);
        int max = difficulty(input);
        int target = randomNumber(max);
        int tries = 0;
        System.out.println("jeg vælger et tal mellem 0 og " + max);

        int guess = 0;
        while (guess != target) {
            System.out.print("indtast dit gæt: ");
            guess = input.nextInt();
            tries++;

            System.out.println(checkGuess(guess, target));

        }
        System.out.println("Tillykke! Du har gættet tallet på " + tries + " forsøg!");
        handlePlayAgain(input);
    }

    public static String checkGuess(int guess, int target) {
            if (guess < target) {
                return "tallet er højere";
            } else if (guess > target) {
                return "tallet er lavere";
            }  else {
                return "korrekt";
            }
    }

    public static void handlePlayAgain(Scanner input) {

        while (true) {
            System.out.println("vil du spille igen?(ja/nej) ");
            String answer = input.next().trim().toLowerCase();

            switch (answer) {
                case "ja": playGame(); break;
                case "nej":
                    System.out.println("afslutter programmet") ;System.exit(0);
                default: System.out.println("ugyldigt svar, svar ja eller nej"); break;
            }
        }
    }
}