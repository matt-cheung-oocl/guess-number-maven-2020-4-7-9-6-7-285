package com.oocl;

import java.util.Random;

import static com.oocl.GuessNumber.ANSWER_LENGTH;

public class RandomAnswerGenerator {

	public static final int MAX_NUMBER = 10;

	public String generate() {
		StringBuilder randomAnswer = new StringBuilder();
		for (int count = 0; count < ANSWER_LENGTH; count++) {
			String randomDigit = String.valueOf((new Random().nextInt(MAX_NUMBER)));
			while (randomAnswer.toString().contains(randomDigit)) {
				randomDigit = String.valueOf((new Random().nextInt(MAX_NUMBER)));
			}
			randomAnswer.append(randomDigit);
		}
		return randomAnswer.toString();
	}
}
