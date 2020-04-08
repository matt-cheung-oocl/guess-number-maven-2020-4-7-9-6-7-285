package com.oocl;

import java.util.Random;

public class GuessNumber {

	private int remainingInputChance;
	private String randomAnswer;
	private boolean isAllCorrect;

	public boolean isAllCorrect() {
		return isAllCorrect;
	}

	public void setAllCorrect(boolean allCorrect) {
		isAllCorrect = allCorrect;
	}

	public String getRandomAnswer() {
		return randomAnswer;
	}

	public void setRemainingInputChance(int remainingInputChance) {
		this.remainingInputChance = remainingInputChance;
	}

	public void initializeGame() {
		generateRandomAnswer();
		setRemainingInputChance(6);
		setAllCorrect(false);
	}

	public void generateRandomAnswer() {
		String randomAnswer = "";
		for (int count = 0; count < 4; count++) {
			String randomDigit = String.valueOf((new Random().nextInt(10)));
			while (randomAnswer.contains(randomDigit)) {
				randomDigit = String.valueOf((new Random().nextInt(10)));
			}
			randomAnswer += randomDigit;
		}
		this.randomAnswer = randomAnswer;
	}

	public boolean validateInput(String input) {
		setRemainingInputChance(remainingInputChance - 1);
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

	public String compareAnswer(String input) {
		int numberOfCorrectDigit = 0;
		int numberOfWrongPositionDigit = 0;
		for (int inputDigit = 0; inputDigit < input.length(); inputDigit++) {
			for (int answerDigit = 0; answerDigit < this.randomAnswer.length(); answerDigit++) {
				if (this.randomAnswer.charAt(answerDigit) == input.charAt(inputDigit)) {
					if (inputDigit == answerDigit)
						numberOfCorrectDigit++;
					else
						numberOfWrongPositionDigit++;
				}
			}
		}
		if (numberOfCorrectDigit == input.length())
			this.isAllCorrect = true;
		return numberOfCorrectDigit + "A" + numberOfWrongPositionDigit + "B";
	}

	public boolean isGameover() {
		if (this.remainingInputChance == 0)
			return true;
		else
			return false;
	}
}
