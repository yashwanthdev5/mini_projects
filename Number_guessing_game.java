
import java.util.Scanner;

public class Number_guessing_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 100) + 1; // Random number between 1 and 100
        int playAgain;
        int userGuess;
        do {
            System.out.println("-----------------Welcome to the Number Guessing Game!------------------");
            System.out.println("I have selected a number between 1 and 100. Can you guess it? ");
            System.out.println("Enter your guess: ");
            userGuess = sc.nextInt();
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number!");
                break;
            }
            System.out.println("Do you want to continue with guessing? (yes/no)");
            System.out.println("Enter 1 for yes  ||  any other number for no: ");
            playAgain = sc.nextInt();

        } while (playAgain == 1);
        System.out.println("Game Over!");
        System.out.println("The number was: " + numberToGuess);
        System.out.println("Thank you for playing! Goodbye!");
        sc.close();
    }
}
