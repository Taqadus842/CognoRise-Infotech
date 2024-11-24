package HangmanGame;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {
            "programming", "java", "internship", "hangman", "developer",
            "computer", "software", "engineer", "coding", "technology",
            "application", "design", "security", "data", "network"
        };
        Random random = new Random();
        String selectedWord = words[random.nextInt(words.length)];

        int maxAttempts = 6, attempts = 0;
        char[] guessedWord = new char[selectedWord.length()];
        boolean[] guessedLetters = new boolean[26];
        Scanner scanner = new Scanner(System.in);

        // Initialize guessedWord array with dashes
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + maxAttempts + " attempts to guess the word.");

        // Start guessing loop
        while (attempts < maxAttempts && String.valueOf(guessedWord).contains("-")) {
            System.out.println("\nWord: " + String.valueOf(guessedWord)); // Display current guessed word
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0); // Read guessed letter

            // Check if input is a valid letter
            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            // Check if letter has already been guessed
            if (guessedLetters[guess - 'a']) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            // Mark the letter as guessed
            guessedLetters[guess - 'a'] = true;
            boolean correctGuess = false;

            // Check if the guessed letter is in the selected word
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    guessedWord[i] = guess; // Fill in the guessed letter
                    correctGuess = true;
                }
            }

            // Provide feedback to the user
            if (correctGuess) {
                System.out.println("Correct guess!");
            } else {
                attempts++;
                System.out.println("Incorrect guess. Attempts remaining: " + (maxAttempts - attempts));
            }
        }

        // Game over conditions: either guessed correctly or ran out of attempts
        if (String.valueOf(guessedWord).equals(selectedWord)) {
            System.out.println("\nCongratulations! You guessed the word: " + selectedWord);
        } else {
            System.out.println("\nGame over! The word was: " + selectedWord);
            displayHangman(maxAttempts); // Show the full hangman after max attempts
        }

        scanner.close();
    }

    // Function to display the hangman graphic
    public static void displayHangman(int attempts) {
        String[] hangman = {
            "  +---+\n      |\n      |\n      |\n     ===",
            "  +---+\n  O   |\n      |\n      |\n     ===",
            "  +---+\n  O   |\n  |   |\n      |\n     ===",
            "  +---+\n  O   |\n /|   |\n      |\n     ===",
            "  +---+\n  O   |\n /|\\  |\n      |\n     ===",
            "  +---+\n  O   |\n /|\\  |\n /    |\n     ===",
            "  +---+\n  O   |\n /|\\  |\n / \\  |\n     ==="
        };
        System.out.println(hangman[attempts]);
    }
}
