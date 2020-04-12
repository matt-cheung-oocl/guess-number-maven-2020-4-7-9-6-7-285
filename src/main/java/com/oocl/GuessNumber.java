package com.oocl;

public class GuessNumber {

	public static final int ANSWER_LENGTH = 4;
	public static final int STARTING_INPUT_CHANCE = 6;
	private int remainingInputChance;
	private String randomAnswer;
	private boolean isAllCorrect;

	public boolean isAllCorrect() {
		return isAllCorrect;
	}

	public void setAllCorrect(boolean allCorrect) {
		isAllCorrect = allCorrect;
	}

	public int getRemainingInputChance() {
		return remainingInputChance;
	}

	public void setRemainingInputChance(int remainingInputChance) {
		this.remainingInputChance = remainingInputChance;
	}

	public void initializeGame() {
		RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
		this.randomAnswer = randomAnswerGenerator.generate();
		setRemainingInputChance(STARTING_INPUT_CHANCE);
		setAllCorrect(false);
	}

	public boolean validateInput(String input) {
		setRemainingInputChance(remainingInputChance - 1);
		if (input.length() != ANSWER_LENGTH) {
			return false;
		}
		for (int digit1 = 0; digit1 < input.length(); digit1++) {
			for (int digit2 = digit1 + 1; digit2 < input.length(); digit2++) {
				if (input.charAt(digit1) == input.charAt(digit2)) {
					return false;
				}
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
					if (inputDigit == answerDigit) {
						numberOfCorrectDigit++;
					}
					else {
						numberOfWrongPositionDigit++;
					}
				}
			}
		}
		if (numberOfCorrectDigit == input.length()) {
			this.isAllCorrect = true;
		}
		return numberOfCorrectDigit + "A" + numberOfWrongPositionDigit + "B";
	}

	public boolean isGameOver() {
		return this.remainingInputChance == 0;
	}
}
