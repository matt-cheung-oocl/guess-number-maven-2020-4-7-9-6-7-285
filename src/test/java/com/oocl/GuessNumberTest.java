package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuessNumberTest {

	private GuessNumber guessNumber = new GuessNumber(new RandomAnswerGenerator());

	@Test
	public void should_return_invalid_and_invalid_input_message() {
		assertFalse(guessNumber.validateInput("1134"));
		assertFalse(guessNumber.validateInput("12"));
		assertTrue(guessNumber.validateInput("1234"));
	}

	@Before
	public void setUp() {
		String answer = "1234";
		RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
		Mockito.when(randomAnswerGenerator.generate()).thenReturn(answer);
		guessNumber = new GuessNumber(randomAnswerGenerator);
	}

	@Test
	public void should_return_4A0B_when_answer_is_1234_given_input_is_1234() {
		String inputNumbers = "1234";
		String result = guessNumber.compareAnswer(inputNumbers);
		Assert.assertEquals("4A0B", result);
	}

	@Test
	public void should_return_2A2B_when_answer_is_1234_given_input_is_1243() {
		String inputNumbers = "1243";
		String result = guessNumber.compareAnswer(inputNumbers);
		Assert.assertEquals("2A2B", result);
	}

	@Test
	public void should_return_1A1B_when_answer_is_1234_given_input_is_1628() {
		String inputNumbers = "1628";
		String result = guessNumber.compareAnswer(inputNumbers);
		Assert.assertEquals("1A1B", result);
	}

	@Test
	public void should_return_0A4B_when_answer_is_1234_given_input_is_4321() {
		String inputNumbers = "4321";
		String result = guessNumber.compareAnswer(inputNumbers);
		Assert.assertEquals("0A4B", result);
	}

	@Test
	public void should_return_0A2B_when_answer_is_1234_given_input_is_9821() {
		String inputNumbers = "9821";
		String result = guessNumber.compareAnswer(inputNumbers);
		Assert.assertEquals("0A2B", result);
	}

	@Test
	public void should_return_0A0B_when_answer_is_1234_given_input_is_9876() {
		String inputNumbers = "9876";
		String result = guessNumber.compareAnswer(inputNumbers);
		Assert.assertEquals("0A0B", result);
	}
}
