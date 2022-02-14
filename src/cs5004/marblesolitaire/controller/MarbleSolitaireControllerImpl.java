package cs5004.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cs5004.marblesolitaire.model.impl.MarbleSolitaireModel;


/**
 * The the marble solitaire controller implementation class. It only has one method, playGame.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  Readable in;
  Appendable out;

  /**
   * This is the constructor for the controller implementation class. It throws an IllegalArgExcep
   * if either the Readable or Appendable are null.
   *
   * @param rd - the readable that is passed through
   * @param ap - the appendable that is passed through
   * @throws IllegalArgumentException when either the rd or ap are null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if ((rd == null) || (ap == null)) {
      throw new IllegalArgumentException("Error: reader and/or appendable cannot be null.\n");
    }
    this.in = rd;
    this.out = ap;
  }

  /**
   * This method plays a new game of marble solitaire using the passed in model. Will throw an
   * exception if the model is null or if the controller is unable to receive input / give output.
   *
   * @param model - the model passed in to play the game
   * @throws IllegalArgumentException when the model that is passed through is null
   */
  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException {
    // check for nulls
    if (model == null) {
      throw new IllegalArgumentException("Error: model cannot be null.\n");
    }

    // print the board for the game to begin
    printGame("", model);

    // start the scanner
    Scanner userInput = new Scanner(this.in);

    // keep looping...
    while (true) {

      // unless the game is over
      if (isGameOver(model)) {
        wonGame(model);
        return;
      }

      // make an array list to keep track...
      ArrayList<Integer> arr = new ArrayList<>();

      // iterate until the array has four values in it
      while (arr.size() < 4) {

        // if there is no more input, throw exception
        if (!userInput.hasNext()) {
          throw new IllegalStateException("Error: ran out of inputs.\n");
        }

        // else declaring variables
        String input = userInput.next();
        int value;

        // if the input is Q or q
        if (isQuit(input)) {
          quitGame(model);
          return;
        }

        // try to get the value from the input and catch non ints
        try {
          value = Integer.parseInt(input) - 1;
          // if the value is negative, ask for another value
          while (value < 0) {
            outputMessage("Error: value must be positive. Try again.\n");
            value = userInput.nextInt() - 1;
          }
          // if the value is OK, add to the arrayList
          arr.add(value);
        } catch (NumberFormatException | InputMismatchException c) {
          outputMessage("Error: value must be an integer. Try again.\n");
        }
      }

      // once for loop is complete, send to model and print status
      makeMove(arr, model);
      printGame("", model);
    }
  }

  private void makeMove(ArrayList<Integer> arr, MarbleSolitaireModel model) {
    // then try to do the move on the board!
    try {
      //outputMessage(arr.toString() + "\n");
      model.move(arr.get(0), arr.get(1), arr.get(2), arr.get(3));
    } catch (IllegalArgumentException | IndexOutOfBoundsException h) {
      outputMessage("Error: invalid move (" + arr.get(0) + ", " + arr.get(1)
              + ") to (" + arr.get(2) + ", " + arr.get(3) + "). Play again.\n");
    }
  }

  private void wonGame(MarbleSolitaireModel model) {
    printGame("Game over!\n", model);
  }

  private boolean isGameOver(MarbleSolitaireModel model) {
    return (model.isGameOver());
  }

  private void quitGame(MarbleSolitaireModel model) {
    printGame("Game quit!\nState of game when quit:\n", model);
    outputMessage("\n");
  }

  private boolean isQuit(String input) {
    return ((input.equals("Q")) || (input.equals("q")));
  }

  private void printGame(String input, MarbleSolitaireModel model) {
    outputMessage(input + model.getGameState() + "\nScore: " + model.getScore() + "\n");
  }

  private void outputMessage(String message) throws IllegalArgumentException {
    try {
      out.append(message);
    } catch (IOException f) {
      throw new IllegalStateException("Could not complete output.\n");
    }
  }

}

