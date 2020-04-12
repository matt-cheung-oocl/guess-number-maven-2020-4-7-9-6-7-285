package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.mockito.Mockito;

public class RandomAnswerGeneratorTest {
	private  GuessNumber guessNumber;

	@Before
	public void setUp() throws Exception {
		String answer = "1234";
		RandomAnswerGenerator randomAnswerGenerator  = Mockito.mock(RandomAnswerGenerator.class);
		Mockito.when(randomAnswerGenerator.generate()).thenReturn(answer);
		guessNumber = new GuessNumber();
		guessNumber.initializeGame();
	}

	@Test
	public void should_return_4A0B_when_answer_is_1234_given_input_is_1234() {
		String input = "1234";
		String result = guessNumber.compareAnswer(input);
		Assert.assertEquals("4A0B", result);
	}

}