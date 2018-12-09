package org.nadeem.scorer;

import org.nadeem.scorer.utilities.ErrorResponse;
import org.nadeem.scorer.utilities.Validator;

/**
 * This is the Main Class of the Application
 *
 */
public class App {

	public static void main(String[] args) {
		try {
			BowlingGame game;
			// Validate App Arguments
			Validator.getInstance().validateAppArguments(args);
			if (!(ErrorResponse.getInstance().getErrorExists())) {
				String rolls = args[0];
				// Check if the rolls are Valid
				Validator.getInstance().validateRolls(rolls);
				if (!(ErrorResponse.getInstance().getErrorExists())) {
					// Create a new game using the rolls
					game = new BowlingGame(rolls);
					// Calculate Score of the Game
					game.calculateScore();
					System.out.println("Game Score is - " + game.getScore());
				} else
					System.out.println(ErrorResponse.getInstance().getMessage());

			} else
				System.out.println(ErrorResponse.getInstance().getMessage());
		} catch (Exception e) {
			System.err.println("Error in App Class - Error = " + e);
			e.printStackTrace();
		}
	}

}
