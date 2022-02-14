package cs5004.marblesolitaire.model.impl;

import cs5004.marblesolitaire.model.board.TriangleBoard;

/**
 * This is the TriangleSoliaireModelImpl class which extends the MarbleSolitaireModelImpl class.
 */
public class TriangleSolitaireModelImpl extends MarbleSolitaireModelImpl {

  protected TriangleBoard gameBoard;

  /**
   * This is the constructor for default board that takes in no params. The default values are 3 for
   * row and col and the empty space is at (3, 3).
   */
  public TriangleSolitaireModelImpl() {
    this(0, 0);
  }

  /**
   * This is the constructor for a board which takes in two param for empty row and empty col so the
   * empty space is at (sRow, sCol).
   *
   * @param eRow - the specified row for the empty spot
   * @param eCol - the specified col for the empty spot
   * @throws IllegalArgumentException - for when the inputs are invalid
   */
  public TriangleSolitaireModelImpl(int eRow, int eCol)
          throws IllegalArgumentException {
    this(5, eRow, eCol);
  }

  /**
   * This is the constructor for a board that only takes in one param for the arm thickness.
   *
   * @param dimension - the thickness of the board arm
   * @throws IllegalArgumentException - for when the inputs are invalid
   */
  public TriangleSolitaireModelImpl(int dimension)
          throws IllegalArgumentException {
    this(dimension, 0, 0);
  }

  /**
   * This is the constructor for a board that takes in three params for arm thickness, empty row,
   * and empty col. Not only is the board size custom, but the location of the empty spot is marked
   * with (sRow, sCol).
   *
   * @param dimension - the thickness of the board arm
   * @param eRow  - the specified row for the empty spot
   * @param eCol  - the specified col for the empty spot
   * @throws IllegalArgumentException - for when the inputs are invalid
   */
  public TriangleSolitaireModelImpl(int dimension, int eRow, int eCol)
          throws IllegalArgumentException {
    // ensure the thickness is valid
    if (dimension < 1) {
      throw new IllegalArgumentException("Dimension must be greater than 1.");
    }
    // then set up the values for the board
    this.gameBoard = new TriangleBoard(dimension, eRow, eCol);
    // ensure the empty space is on the board
    if (!gameBoard.onBoard(eRow, eCol)) {
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
      throw new IllegalArgumentException("Input values must be on the board.");
    }
    if (!(gameBoard.validMove(fromRow, fromCol, toRow, toCol))) {
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
