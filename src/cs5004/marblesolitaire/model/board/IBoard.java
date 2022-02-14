package cs5004.marblesolitaire.model.board;

import java.util.ArrayList;

import cs5004.marblesolitaire.model.piece.IPiece;

/**
 * This is the interface for the board in the game. It contains methods like getScore, onBoard,
 * makeBoard, vaildMove, move and getGameState.
 */
public interface IBoard {
  /**
   * The method getScore returns the current score of the game based on the marbles left.
   *
   * @return int - the score
   */
  int getScore();

  /**
   * The method onBoard checks if coordinates are on the board.
   *
   * @param row - the row under consideration
   * @param col - the col under consideration
   * @return boolean - T/F
   */
  boolean onBoard(int row, int col);

  /**
   * The method makeBoard returns the array of the board. It is used in the constructor in the
   * board.
   *
   * @return ArrayList - the board
   */
  ArrayList<ArrayList<IPiece>> makeBoard();

  /**
   * The validMove method is a helper function for move which checks if a move is valid.
   *
   * @param fromRow - the row for the "from" marble
   * @param fromCol - the col for the "from" marble
   * @param toRow   - the row for the "to" marble
   * @param toCol   - the col for the "to" marble
   * @return boolean - T/F
   */
  boolean validMove(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * The move method alters the board to reflect the new move.
   *
   * @param fromRow - the row for the "from" marble
   * @param fromCol - the col for the "from" marble
   * @param toRow   - the row for the "to" marble
   * @param toCol   - the col for the "to" marble
   */
  void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException;

  /**
   * The empty quadrant method determines if the space on the board is in an empty block or not.
   *
   * @param row - the row under consideration
   * @param col - the col under consideration
   * @return boolean (T/F)
   */
  boolean emptyQuadrant(int row, int col);

  /**
   * The method getGameState prints out a version of the board in text for the end user.
   *
   * @return String - a string representation of the game
   */
  String getGameState();
}
