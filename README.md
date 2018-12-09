# BowlingGameScorer

Given a valid sequence of rolls for one line of American Ten-Pin Bowling, this application produces total score for the game.

# Set Up

You will need below tools before you run this application

1.  git - https://git-scm.com/

2.  java version "1.8.0_191" - https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.htm
3.  Apache Maven 3.6.0 - https://maven.apache.org/download.cgi

# Solution Overview

1.  The entry to the application is App.java. The Applications takes the first string input as Rolls of the Game and calculates the Game Score based on the rolls.
2.  BowlingGame.java represent the Bowling Game and contains the score and rolls. This Class also contains the method calculateScore which takes input as rolls and calculates total Score.
3. Utilities folder contains the Validator and Error Response Class
4. Application contains 7 test cases which covers validation checks and score calculation for sample rolls

# Assumption
1.  The rolls have a valid sequence for one line of American Ten-Pin Bowling
2.  Validation is done such that only characters 1-9, X, - and "/" are allowed in input

# Steps To Run The Program

1.  git clone https://github.com/nadeem-shaikh/BowlingGameScorer.git
2.  cd BowlingGameScorer/
3.  mvn package
4.  java -jar target/scorer-0.0.1-SNAPSHOT.jar XXXXXXXXXXXX
