import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 7;

        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
        System.out.println("Try to guess it. You have " + MAX_ATTEMPTS + " attempts per round.");

        boolean playAgain;

        do {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;

            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < LOWER_BOUND || guess > UPPER_BOUND) {
                    System.out.println("Please enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                    continue;
                }

                attemptsLeft--;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("No attempts left. The correct number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");
    }
}
