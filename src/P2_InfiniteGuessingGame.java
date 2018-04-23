/*
	ISYS 320
	Name(s):
	Date: 
*/


import java.util.Random;
import java.util.Scanner;

public class P2_InfiniteGuessingGame {

	public static void main(String[] args) {
		int secretNumber = getSecretNumber();
		int numberOfGuessesAllowed = 7;

		outputWelcomeMessage();
		int guessesTaken = playGame(secretNumber, numberOfGuessesAllowed);
		outputEndingMessage(guessesTaken, numberOfGuessesAllowed, secretNumber);
	}

	public static void outputWelcomeMessage() {
		System.out.println("This is a guessing game.");
		System.out.println("I picked a random number from 1 to 100");
	}

	public static void outputEndingMessage(int guessesTaken, int numberOfGuessesAllowed, int secretNumber) {
		if (guessesTaken < numberOfGuessesAllowed) {
			System.out.println("Congratuations, you guessed it!");
		} else {
			System.out.println("The secret number was " + secretNumber + ". Try again.");
		}
	}

	public static int getSecretNumber() {
		Random generator = new Random();
		return generator.nextInt(100) + 1;
	}

	public static int getNextGuess() {
		Scanner console = new Scanner(System.in);
		int nextGuess;
		do {
			System.out.println("What is your guess? ");
			nextGuess = console.nextInt();

			if (nextGuess < 0 || nextGuess > 100) {
				System.out.println("ERROR: Guess should be between 0 and 100");
			}
		} while (nextGuess < 0 || nextGuess > 100);

		return nextGuess;
	}

	public static int playGame(int secretNumber, int allowedGuesses) {
		int numOfGuessesTaken = 0;
		while (numOfGuessesTaken < allowedGuesses) {
			int nextGuess = getNextGuess();

			if (nextGuess == secretNumber) {
				return numOfGuessesTaken;
			} else {
				System.out.println("Nope, guess again. ");
				numOfGuessesTaken++;
				
				return nextGuess;
			}
		}

		return numOfGuessesTaken;
	}

}
