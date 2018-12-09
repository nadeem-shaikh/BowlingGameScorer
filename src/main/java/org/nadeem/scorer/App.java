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

			Validator.getInstance().validateAppArguments(args);
			if (!(ErrorResponse.getInstance().getErrorExists())) {
				String rolls = args[0];
				game = new BowlingGame(rolls);
				Validator.getInstance().validateRolls(rolls);
				if (!(ErrorResponse.getInstance().getErrorExists())) {
					game.calculateScore();
					System.out.println("Game Score is - " + game.getScore());
				} else {
					System.out.println(ErrorResponse.getInstance().getMessage());

				}
			} else
				System.out.println(ErrorResponse.getInstance().getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
