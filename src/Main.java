/*
 * Name: JiaJia Liu
 * Email: jpl5840@psu.edu
 * Course: IST 261
 * Assignment: IA03
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{

  public static void main(String[] args) {
    System.out.println("Name: JiaJia Liu");
    System.out.println("Email: jpl5840@psu.edu");
    System.out.println("Course: IST 261");
    System.out.println("Assignment: IA03");
    System.out.println("");

    ArrayList<Integer> randomNumberList = new ArrayList<Integer>();

    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();

    String userInput = "Y";
    int count = 0;
    int correct = 0;
    int incorrect = 0;

    // Ensure that the first random number will be considered the highest so far
    int highestRandom = Integer.MIN_VALUE;

    // Ensure that the first random number will be considered the lowest so far
    int lowestRandom = Integer.MAX_VALUE;

    while (userInput.equals("Y")) {
      count++;
      /*
       * To get a random integer between 2 and 10, we get a random int
       * between 1 and 5 (inclusive), then double it.
       *
       * Since Random.nextInt(5) returns a random integer between 0 and 4
       * (inclusive), we add 1 to it.  That gets us between 1 and 5.
       *
       * Doubling that result will give us the random integer between 2 and 10.
       */
      int randomInt = 2 * (random.nextInt(5) + 1);
      randomNumberList.add(randomInt);
      
      if (randomInt > highestRandom) {
        highestRandom = randomInt;
      }

      if (randomInt < lowestRandom) {
        lowestRandom = randomInt;
      }

      boolean validUserIntAnswer = false;
      int userIntAnswer = 0;
      do {
        try {
        System.out.print("What is half of " + randomInt + "? ");
        userIntAnswer = keyboard.nextInt();
          System.out.println("You answered: " + userIntAnswer);
          keyboard.nextLine();
        } catch (Exception e) {
          System.out.println("You must enter a positive number with no decimals");
        }

        validUserIntAnswer = userIntAnswer >= 0;
        if (!validUserIntAnswer){
          System.out.println("You must enter a positive number with no decimals");
        }
      } while (!validUserIntAnswer);


      if (userIntAnswer == (randomInt / 2)) {
        System.out.println("Correct!");
        correct++;
      } else {
        System.out.println("Wrong!");
        incorrect++;
      }

      boolean validAnswer = false;
      do {
        System.out.print("Another number? ");
        userInput = keyboard.nextLine();
        System.out.println("");
        validAnswer = userInput.equals("Y") || userInput.equals("N");
        if (!validAnswer) {
          System.out.println("You must enter Y or N");
        }
      }
      while (!validAnswer);

    }
    System.out.println("Game over");
    System.out.println("You answered " + count + " questions");
    System.out.println(correct + " were right");
    System.out.println(incorrect + " were wrong");
    System.out.println("You got " + (100 * correct / count) + "% right");
    System.out.println("The highest random number you were given:  " + highestRandom);
    System.out.println("The lowest random number you were given:  " + lowestRandom);
    System.out.println("\nThe list of numbers you were given: ");
    for(Integer randomList : randomNumberList){
      System.out.println(randomList);
    }

  }
}
