package com.oocl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		GuessNumber guessNumber = new GuessNumber();

		guessNumber.initializeGame();

		while (!guessNumber.isGameover()) {
			String input = scanner.nextLine();

			if (guessNumber.validateInput(input))
				System.out.println(guessNumber.compareAnswer(input));
			else
				System.out.println("Wrong Input，Input again");

			if (guessNumber.isAllCorrect()) {
          System.out.println("win, all correct");
          System.exit(0);
      }
		}
	}
}
