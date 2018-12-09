package org.nadeem.scorer.utilities;

public class Validator {
	private static Validator validatorObj = new Validator();

	public static Validator getInstance() {
		if (validatorObj == null)
			validatorObj = new Validator();
		return validatorObj;
	}

	public void validateRolls(String rolls) {

		// Check if the length of the scores provided is less than 12 or more than 21
		if (rolls.length() < 12 || rolls.length() > 21) {

			// Set Error flag to true
			ErrorResponse.getInstance().setErrorExists(true);

			// Set Error Message
			ErrorResponse.getInstance().setMessage("Please Provide Valid Rolls");
		}

		// Ensure that Scores contains characters present in the list 0,1,2,3,4,5,6,7,8,9,X,/,-
		if (!(rolls.matches("^[X/1-9\\-]+$"))) {
			
			// Set Error flag to true
			ErrorResponse.getInstance().setErrorExists(true);

			// Set Error Message
			ErrorResponse.getInstance().setMessage("Rolls Contain Invalid Values");
		}
	}

	public void validateAppArguments(String[] args) {

		// Initialize Error Flag to False
		ErrorResponse.getInstance().setErrorExists(false);

		// Check if the length of the scores provided is less than 12 or more than 21
		if (!(args.length > 0)) {
			// Set Error flag to true
			ErrorResponse.getInstance().setErrorExists(true);

			// Set Error Message
			ErrorResponse.getInstance().setMessage("Please Provide Valid Input to Application");
		}
	}
}
