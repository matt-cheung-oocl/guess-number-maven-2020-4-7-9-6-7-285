package com.oocl;

import java.util.Random;

public class GuessNumber {

	public String generateRandomAnswer() {
		String randomAnswer = "";
		for (int count = 0; count < 4; count++) {
			String randomDigit = String.valueOf((new Random().nextInt(10)));
			while (randomAnswer.contains(randomDigit)) {
				randomDigit = String.valueOf((new Random().nextInt(10)));
			}
			randomAnswer += randomDigit;
		}
		return randomAnswer;
	}

	public boolean validateInput(String input) {
		if (input.length() != 4)
			return false;
		for (int digit1 = 0; digit1 < input.length(); digit1++) {
			for (int digit2 = digit1 + 1; digit2 < input.length(); digit2++) {
				if (input.charAt(digit1) == input.charAt(digit2))
					return false;
			}
		}
		return true;
	}

	public String compareAnswer(String randomAnswer, String input) {
		int numberOfCorrectDigit = 0;
		int numberOfWrongPositionDigit = 0;
		for (int inputDigit = 0; inputDigit < input.length(); inputDigit++) {
			for (int answerDigit = 0; answerDigit < randomAnswer.length(); answerDigit++) {
				if (randomAnswer.charAt(answerDigit) == input.charAt(inputDigit)) {
					if (inputDigit == answerDigit)
						numberOfCorrectDigit++;
					else
						numberOfWrongPositionDigit++;
				}
			}
		}
		return numberOfCorrectDigit + "A" + numberOfWrongPositionDigit + "B";
	}
}
