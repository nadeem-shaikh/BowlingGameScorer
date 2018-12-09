package org.nadeem.scorer;

public class BowlingGame {
	private String rolls;
	private int score;

	public String getRolls() {
		return rolls;
	}

	public void setRolls(String rolls) {
		this.rolls = rolls;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public BowlingGame(String rolls) {
		this.rolls = rolls;
	}

	public Integer calculateScore() {

		// Calculate the number of bonus balls awarded after the final frame.
		int bonusRolls = 0;

		if (rolls.charAt(rolls.length() - 3) == 'X') {
			bonusRolls = 2;
		} else if (rolls.charAt(rolls.length() - 2) == '/') {
			bonusRolls = 1;
		}

		System.out.println("rolls are - " + rolls);

		// Calculate base Score for Each Frame
		for (int i = 0; i < (rolls.length() - bonusRolls); i++) {
			// System.out.println("Character is - " + rolls.charAt(i));

			score += pointForScore(rolls, i);

			// Calculate bonus per frame for a Spare
			if (rolls.charAt(i) == '/') {
				score += pointForScore(rolls, i + 1);
			}

			// Calculate bonus per frame for a Strike
			if (rolls.charAt(i) == 'X') {
				score += pointForScore(rolls, i + 1) + pointForScore(rolls, i + 2);
			}
		}
		return score;
	}

	public Integer pointForScore(String rolls, Integer index) {
		if (rolls.charAt(index) == 'X')
			return 10;
		if (rolls.charAt(index) == '-')
			return 0;
		if (rolls.charAt(index) == '/')
			return (10 - Integer.parseInt(rolls.charAt(index - 1) + ""));
		else
			return Integer.parseInt(rolls.charAt(index) + "");
	}

}
