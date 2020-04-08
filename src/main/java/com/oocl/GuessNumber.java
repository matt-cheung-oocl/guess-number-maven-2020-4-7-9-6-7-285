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

	public String validateInput(String input) {
		if (input.length() != 4)
			return "Wrong Input，Input again";
		for (int digit1 = 0; digit1 < input.length(); digit1++) {
			for (int digit2 = digit1 + 1; digit2 < input.length(); digit2++) {
				if (input.charAt(digit1) == input.charAt(digit2))
					return "Wrong Input，Input again";
			}
		}
		return "ok";
	}
}
