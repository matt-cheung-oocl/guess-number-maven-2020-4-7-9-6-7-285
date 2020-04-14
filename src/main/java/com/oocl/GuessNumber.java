package com.oocl;

public class GuessNumber {

	static final int ANSWER_LENGTH = 4;
	private static final int STARTING_INPUT_CHANCE = 6;
	private int remainingInputChance;
	private String randomAnswer;
	private boolean isAllCorrect;

	public GuessNumber(RandomAnswerGenerator randomAnswerGenerator) { this.randomAnswer = randomAnswerGenerator.generate(); }

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

	public boolean isGameOver() {
		return this.remainingInputChance == 0;
	}


	public void initializeGame() {
		setRemainingInputChance(STARTING_INPUT_CHANCE);
		setAllCorrect(false);
	}

	public boolean validateInput(String inputNumbers) {
		setRemainingInputChance(remainingInputChance - 1);
		if (inputNumbers.length() != ANSWER_LENGTH) {
			return false;
		}
		for (int digit1 = 0; digit1 < inputNumbers.length(); digit1++) {
			for (int digit2 = digit1 + 1; digit2 < inputNumbers.length(); digit2++) {
				if (inputNumbers.charAt(digit1) == inputNumbers.charAt(digit2)) {
					return false;
				}
			}
		}
		return true;
	}

	public String compareAnswer(String inputNumbers) {
		int numberOfCorrectDigit = 0;
		int numberOfWrongPositionDigit = 0;

		for (char number : inputNumbers.toCharArray()) {
			boolean isPositionAndNumberCorrect = this.randomAnswer.contains(Character.toString(number))
							&& this.randomAnswer.indexOf(number) == inputNumbers.indexOf(number);
			boolean isNumberCorrectWithWrongPosition = this.randomAnswer.contains(Character.toString(number))
							&& this.randomAnswer.indexOf(number) != inputNumbers.indexOf(number);
			if (isPositionAndNumberCorrect) {
				numberOfCorrectDigit++;
			}
			if (isNumberCorrectWithWrongPosition) {
				numberOfWrongPositionDigit++;
			}
		}
		if (numberOfCorrectDigit == inputNumbers.length()) {
			this.isAllCorrect = true;
		}
		return numberOfCorrectDigit + "A" + numberOfWrongPositionDigit + "B";
	}
}
