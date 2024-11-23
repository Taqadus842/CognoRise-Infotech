package NumberGuessingGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        int maxAttempt = 5; 
        boolean isCorrect = false; 
        
        Random genRandom = new Random();
        int randNum = genRandom.nextInt(100) + 1; 

        System.out.println("Welcome to Number Guessing System!");
        System.out.println("Enter a number between 1 and 100.");
        System.out.println("You have " + maxAttempt + " attempts to guess.");

        Scanner scanner = new Scanner(System.in);
        for (int attempts = 1; attempts <= maxAttempt; attempts++) { // Use attempts correctly
            System.out.print("Enter your guess: ");
            int guessByUser = scanner.nextInt();

            if (guessByUser == randNum) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                isCorrect = true;
                break; 
            } else if (guessByUser < randNum) {
                System.out.println("Too Low! Try Again.");
            } else {
                System.out.println("Too High! Try Again.");
            }

           
            System.out.println("You have " + (maxAttempt - attempts) + " attempts remaining.");
        }

       
        if (!isCorrect) {
            System.out.println("SORRY! You've used all your attempts. The correct number was: " + randNum);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
