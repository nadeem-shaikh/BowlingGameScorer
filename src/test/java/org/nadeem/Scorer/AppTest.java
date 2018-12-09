package org.nadeem.Scorer;

import org.junit.Before;
import org.nadeem.scorer.BowlingGame;
import org.nadeem.scorer.utilities.ErrorResponse;
import org.nadeem.scorer.utilities.Validator;

import junit.framework.TestCase;

/**
 * Unit test for American Ten Pin Bowling Application
 */
public class AppTest extends TestCase {

	@Before
	public void setUp() throws Exception {
		ErrorResponse.getInstance().setErrorExists(false);
	}

	/**
	 * Test Case for Validating App Arguments)
	 */
	public void testValidAppArguments() {

		// Pass Score as App Argument
		String[] args = { "5/5/5/5/5/5/5/5/5/6/5" };

		// Validate App Arguments
		Validator.getInstance().validateAppArguments(args);

		// As argument provided is valid, errorExists should be false
		assertEquals(ErrorResponse.getInstance().getErrorExists(), false);

	}

	/**
	 * Test Case for Validating App Arguments)
	 */
	public void testInvalidAppArguments() {

		// Pass Score as App Argument
		String[] args = {};

		// Validate App Arguments
		Validator.getInstance().validateAppArguments(args);

		// As argument provided is invalid, errorExists should be true
		assertEquals(ErrorResponse.getInstance().getErrorExists(), true);

	}

	/**
	 * Test Case for Invalid Character "0" in rolls
	 */
	public void testInvalidCharZeroInRolls() {

		// Initialize rolls with values containing invalid character 0
		String rolls = "XXXXX0XXXXXX";
		// Validate App Arguments
		Validator.getInstance().validateRolls(rolls);

		// As rolls contain invalid character, errorExists should be true
		assertEquals(ErrorResponse.getInstance().getErrorExists(), true);

	}
	
	/**
	 * Test Game Score for Sample Rolls which contains 12 rolls : 12 Strikes = 10
	 * frames * 30 points = 300
	 */
	public void testAppForAllStrikes() {

		String rolls = "XXXXXXXXXXXX";
		BowlingGame game = new BowlingGame(rolls);
		int score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 300);
	}

	/**
	 * Test Game Score for Sample Rolls which contains 20 rolls : 10 pairs of 9 and
	 * miss = 10 frames * 9 points = 90
	 */
	public void testAppForNineAndMiss() {

		String rolls = "9-9-9-9-9-9-9-9-9-9-";
		BowlingGame game = new BowlingGame(rolls);
		int score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 90);
	}

	/**
	 * Test Game Score for Sample Rolls which contains 21 rolls : 10 pairs of 5 and
	 * spare, with a final 5 = 10 frames * 15 points = 150
	 */
	public void testAppForFiveAndSpare() {

		String rolls = "5/5/5/5/5/5/5/5/5/5/5";
		BowlingGame game = new BowlingGame(rolls);
		int score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 150);
	}

	public void testAppForSamples() {
		String rolls = "5/5/5/5/5/5/5/5/5/6/3";
		BowlingGame game = new BowlingGame(rolls);
		int score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 149);

		rolls = "XXXXXXXXXX81";
		game = new BowlingGame(rolls);
		score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 287);

		rolls = "X81XXXXXXXXXX";
		game = new BowlingGame(rolls);
		score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 268);

		rolls = "X8/XXXXXXXXXX";
		game = new BowlingGame(rolls);
		score = game.calculateScore();
		System.out.println("Game Score is - " + score);
		assertEquals(score, 280);
	}
}
