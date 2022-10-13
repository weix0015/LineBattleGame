import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dice {
    static Random random = new Random();
    static int resultat = random.nextInt(6) + 1;
    static int nuværendeFeltPlayer = 10;
    static int nuværendeFeltEnemy = -10;

    int rolldice() {
        Random random = new Random();
        int move = random.nextInt(6 ) + 1;
        return move;
    }

    int rolldice1() {
        Random random = new Random();
        int move = random.nextInt(6 ) + 1;
        return move;
    }

    int rolldice2() {
        Random random = new Random();
        int move = random.nextInt(6 ) + 1;
        return move;
    }

    int rolldice3() {
        Random randomEnemy = new Random();
        int moveEnemy = random.nextInt(6 ) + 1;
        return moveEnemy;
    }

    int rolldice4() {
        Random randomEnemy = new Random();
        int moveEnemy = random.nextInt(6 ) + 1;
        return moveEnemy;
    }

    int rolldice5() {
        Random randomEnemy = new Random();
        int moveEnemy = random.nextInt(6 ) + 1;
        return moveEnemy;
    }

    public void start() {
        System.out.println("Vælg et træk");
        System.out.println("Type 1 - Forward");
        System.out.println("Type 2 - Move Backward");
        System.out.println("Type 3 - Attack");
        System.out.println("Type 4 - Surrender");
        System.out.println("Type 5 - Bomb");
        System.out.println("Type 6 - Active Bomb");

    }

    public void forward() {
        System.out.println("Du er rykket et felt frem");
    }

    public void forward2(int a) {
        System.out.println("Du er rykket to felter frem");
        a = 9;
    }

    public int enemy() {
        Random random = new Random();
        int computer = random.nextInt(6 ) + 1;
        return computer;
    }

    public void backward(int a, int b) {
        if (a == 1) {

        }
    }
    // Move Forward
    public void rykfrem() {
        if (resultat == 1 || resultat == 3 || resultat == 5) {
            int antalRyk = 1;
            nuværendeFeltPlayer = nuværendeFeltPlayer - antalRyk;
            System.out.println("Du har slået " + resultat + ". " + "Du står nu på " + nuværendeFeltPlayer);
        } else if (resultat == 2 || resultat == 4 || resultat == 6) {
            int antalRyk = 2;
            nuværendeFeltPlayer = nuværendeFeltPlayer - antalRyk;
            System.out.println("Du har slået " + resultat + ". " + "Du står nu på " + nuværendeFeltPlayer);
        }
    }
    // Move Backward
    public static void træktilbage() {
        if (resultat == 1 || resultat == 2)
        {
            int antalRyk = 1;
            nuværendeFeltPlayer = nuværendeFeltPlayer + antalRyk;
            System.out.println("Du har slået " + resultat + ". " + "Du står nu på " + nuværendeFeltPlayer);

        } else if (resultat == 3 || resultat == 4) {
            int antalRyk = 2;
            nuværendeFeltPlayer = nuværendeFeltPlayer + antalRyk;
            System.out.println("Du har slået " + resultat + ". " + "Du står nu på " + nuværendeFeltPlayer);

        } else if (resultat == 5 || resultat == 6) {
            int antalRyk = 3;
            nuværendeFeltPlayer = nuværendeFeltPlayer + antalRyk;
            System.out.println("Du har slået " + resultat + ". " + "Du står nu på " + nuværendeFeltPlayer);
        }
    }

    public void ildkræft() {
        if (resultat == 1) {
            int antalIldkræft = 100;
            System.out.println("Du har slået " + resultat + ". " + "Du angriber med " + antalIldkræft);

        } else if (resultat == 2) {
            int antalIldkræft = 200;
            System.out.println("Du har slået " + resultat + ". " + "Du angriber med " + antalIldkræft);

        } else if (resultat == 3) {
            int antalIldkræft = 300;
            System.out.println("Du har slået " + resultat + ". " + "Du angriber med " + antalIldkræft);

        } else if (resultat == 4) {
            int antalIldkræft = 400;
            System.out.println("Du har slået " + resultat + ". " + "Du angriber med " + antalIldkræft);
        } else if (resultat == 5) {
            int antalIldkræft = 500;
            System.out.println("Du har slået " + resultat + ". " + "Du angriber med " + antalIldkræft);
        } else if (resultat == 6) {
            int antalIldkræft = 600;
            System.out.println("Du har slået " + resultat + ". " + "Du angriber med " + antalIldkræft);
        }
    }
}