package cs5004.marblesolitaire.model.impl;

import cs5004.marblesolitaire.model.board.EuropeanBoard;

/**
 * This is the EuropeanSolitaireModelImpl class which extends our MarbleSolitaireModelImpl class.
 */
public class EuropeanSolitaireModelImpl extends MarbleSolitaireModelImpl {

  protected EuropeanBoard gameBoard;

  /**
   * This is the constructor for default board that takes in no params. The default values are 3 for
   * row and col and the empty space is at (3, 3).
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3);
  }

  /**
   * This is the constructor for a board which takes in two param for empty row and empty col so the
   * empty space is at (eRow, eCol).
   *
   * @param eRow - the specified row for the empty spot
   * @param eCol - the specified col for the empty spot
   * @throws IllegalArgumentException - for when the inputs are invalid
   */
  public EuropeanSolitaireModelImpl(int eRow, int eCol)
          throws IllegalArgumentException {
    this(3, eRow, eCol);
  }

  /**
   * This is the constructor for a board that only takes in one param for the arm thickness.
   *
   * @param thick - the thickness of the board arm
   * @throws IllegalArgumentException - for when the inputs are invalid
   */
  public EuropeanSolitaireModelImpl(int thick)
          throws IllegalArgumentException {
    this(thick, thick, thick);
  }

  /**
   * This is the constructor for a board that takes in three params for arm thickness, empty row,
   * and empty col. Not only is the board size custom, but the location of the empty spot is marked
   * with (eRow, eCol).
   *
   * @param thick - the thickness of the board arm
   * @param eRow  - the specified row for the empty spot
   * @param eCol  - the specified col for the empty spot
   * @throws IllegalArgumentException - for when the inputs are invalid
   */
  public EuropeanSolitaireModelImpl(int thick, int eRow, int eCol)
          throws IllegalArgumentException {
    // ensure the thickness is valid
    if (thick % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness must be odd.");
    }
    // then set up the values for the board
    gameBoard = new EuropeanBoard(thick, eRow, eCol);
    // ensure the empty space is on the board
    if ((!gameBoard.onBoard(eRow, eCol)) || (gameBoard.emptyQuadrant(eRow, eCol))) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + eRow + ", " + eCol + ")");
    }
  }

  /**
   * The move method alters the board to reflect the new move.
   *
   * @param fromRow - the row for the "from" marble
   * @param fromCol - the col for the "from" marble
   * @param toRow   - the row for the "to" marble
   * @param toCol   - the col for the "to" marble
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    // if the inputs are off the board
    if ((!gameBoard.onBoard(fromRow, fromCol)) || (!gameBoard.onBoard(toRow, toCol))) {
      System.out.println("The issue is onBoard");
      throw new IllegalArgumentException("Input values must be on the board.");
    }
    // if input values are in an empty quadrant
    if ((gameBoard.emptyQuadrant(fromRow, fromCol)) || (gameBoard.emptyQuadrant(toRow, toCol))) {
      System.out.println("The issue is emptyQuad");
      throw new IllegalArgumentException("Input values cannot be in the whitespace.");
    }
    if (!(gameBoard.validMove(fromRow, fromCol, toRow, toCol))) {
      System.out.println("The issue is validMove");
      throw new IllegalArgumentException("Invalid move. Try again.");
    }
    gameBoard.move(fromRow, fromCol, toRow, toCol);
  }

  /**
   * The method isGameOver determines the status of the game by scanning all remaining marbles and
   * checking if they have any valid moves.
   *
   * @return boolean - T/F
   */
  public boolean isGameOver() {
    return gameBoard.isGameOver();
  }

  /**
   * The method getGameState prints out a version of the board in text for the end user.
   *
   * @return String - a string representation of the game
   */
  public String getGameState() {
    return gameBoard.getGameState();
  }

  /**
   * The method getScore returns the current score of the game based on the marbles left.
   *
   * @return int - the score based on the marble counter
   */
  public int getScore() {
    return gameBoard.getScore();
  }
}
