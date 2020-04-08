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
}
