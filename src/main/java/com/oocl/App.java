package com.oocl;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		GuessNumber guessNumber = new GuessNumber(new RandomAnswerGenerator());
		guessNumber.initializeGame();

		while (!guessNumber.isGameOver()) {
			System.out.println("Please Input Your 4-digit Answer... Input Chance Remaining: " + guessNumber.getRemainingInputChance());
			String inputAnswer = scanner.nextLine();

			if (guessNumber.validateInput(inputAnswer))
				System.out.println(guessNumber.compareAnswer(inputAnswer));
			else
				System.out.println("Wrong Input，Input again");

			if (guessNumber.isAllCorrect()) {
				System.out.println("win, all correct");
				System.exit(0);
			}
		}
	}
}
