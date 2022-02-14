package cs5004.marblesolitaire.model.board;

import java.util.ArrayList;

import cs5004.marblesolitaire.model.board.AbstractBoard;
import cs5004.marblesolitaire.model.piece.Empty;
import cs5004.marblesolitaire.model.piece.IPiece;
import cs5004.marblesolitaire.model.piece.Marble;

/**
 * This is the Triangle board class that extends the AbstractBoard class.
 */
public class TriangleBoard extends AbstractBoard {

  private int width;

  /**
   * This is the constructor for the board class which takes in the dimension, an empty row and
   * empty column.
   *
   * @param dimension - the dimensions of the board
   * @param eRow      - the row for the empty cell
   * @param eCol      - the col for the empty cell
   */
  public TriangleBoard(int dimension, int eRow, int eCol) {
    super(dimension, eRow, eCol);
    this.width = dimension;
    this.board = makeBoard();
  }

  /**
   * The method onBoard checks if coordinates are on the board.
   *
   * @param row - the row under consideration
   * @param col - the col under consideration
   * @return boolean - T/F
   */
  @Override
  public boolean onBoard(int row, int col) {
    return ((row >= 0) && (col >= 0) && (row < width) && (col < board.get(row).size()));
  }

  private boolean diagonalMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 2);
  }

  /**
   * The validMove method is a helper function for move which checks if a move is valid.
   *
   * @param fromRow - the row for the "from" marble
   * @param fromCol - the col for the "from" marble
   * @param toRow   - the row for the "to" marble
   * @param toCol   - the col for the "to" marble
   * @return boolean - T/F
   */
  @Override
  public boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    if ((!board.get(fromRow).get(fromCol).toString().equals("O"))
            || (!board.get(toRow).get(toCol).toString().equals("_"))) {
      return false;
    }
    if (verticalMove(fromRow, fromCol, toRow, toCol)) {
      if (fromRow > toRow) {
        return board.get(fromRow - 1).get(fromCol).toString().equals("O");
      } else {
        return board.get(fromRow + 1).get(fromCol).toString().equals("O");
      }
    } else if (horizontalMove(fromRow, fromCol, toRow, toCol)) {
      if (fromCol > toCol) {
        return board.get(fromRow).get(fromCol - 1).toString().equals("O");
      } else {
        return board.get(fromRow).get(fromCol + 1).toString().equals("O");
      }
    } else if (diagonalMove(fromRow, fromCol, toRow, toCol)) {
      if ((fromCol > toCol) && (fromRow > toRow)) {
        return board.get(fromRow - 1).get(fromCol - 1).toString().equals("O");
      } else if ((fromCol < toCol) && (fromRow < toRow)) {
        return board.get(fromRow + 1).get(fromCol + 1).toString().equals("O");
      } else if ((fromCol < toCol) && (fromRow > toRow)) {
        return board.get(fromRow - 1).get(fromCol + 1).toString().equals("O");
      } else if ((fromCol > toCol) && (fromRow < toRow)) {
        return board.get(fromRow + 1).get(fromCol - 1).toString().equals("O");
      }
    }
    return false;
  }

  /**
   * The method makeBoard returns the array of the board. It is used in the constructor in the
   * board.
   *
   * @return ArrayList - the board
   */
  @Override
  public ArrayList<ArrayList<IPiece>> makeBoard() {
    // initialize main board and boardRow
    ArrayList<ArrayList<IPiece>> board = new ArrayList<>();
    // using a for loop to get list within list for each row
    for (int row = 0; row < width; row++) {
      // create and/or overwrite board row each iteration
      ArrayList<IPiece> boardRow = new ArrayList<>();
      for (int col = 0; col < row + 1; col++) {
        // if it is the coordinate for the empty spot, put '_'
        if ((row == this.emptyRow) && (col == this.emptyCol)) {
          boardRow.add(col, new Empty());
        } else {
          boardRow.add(col, new Marble());
        }
      }
      // then add each boardRow to the main board list
      board.add(row, boardRow);
    }
    return board;
  }

  private String addSpace(int row) {
    return " ".repeat(Math.max(0, width - (row + 1)));
  }

  /**
   * The method getGameState prints out a version of the board in text for the end user.
   *
   * @return String - a string representation of the game
   */
  @Override
  public String getGameState() {
    StringBuilder bString = new StringBuilder();
    // printing the board with rows
    for (int row = 0; row < width; row++) {
      bString.append(addSpace(row));
      for (int col = 0; col < board.get(row).size(); col++) {
        bString.append(board.get(row).get(col).toString()).append(" ");
      }
      bString = new StringBuilder(bString.substring(0, bString.length() - 1) + "\n");
    }
    return bString.substring(0, bString.length() - 1);
  }

  private boolean emptySpace(int newRow, int newCol) {
    return board.get(newRow).get(newCol).toString().equals("_");
  }

  /**
   * The method isGameOver determines the status of the game by scanning all remaining marbles and
   * checking if they have any valid moves.
   *
   * @return boolean - T/F
   */
  @Override
  public boolean isGameOver() {
    for (int row = 0; row < width; row++) {
      for (int col = 0; col < board.get(row).size(); col++) {
        if (board.get(row).get(col).toString().equals("O")) {
          if ((onBoard(row, col + 2) && (validMove(row, col, row, col + 2)))
                  || ((onBoard(row, col - 2)) && (validMove(row, col, row, col - 2)))
                  || ((onBoard(row + 2, col)) && (validMove(row, col, row + 2, col)))
                  || ((onBoard(row - 2, col)) && (validMove(row, col, row - 2, col)))
                  || ((onBoard(row + 2, col + 2))
                  && (validMove(row, col, row + 2, col + 2)))
                  || ((onBoard(row - 2, col - 2))
                  && (validMove(row, col, row - 2, col - 2)))
                  || ((onBoard(row + 2, col - 2))
                  && (validMove(row, col, row + 2, col - 2)))
                  || ((onBoard(row - 2, col + 2))
                  && (validMove(row, col, row - 2, col + 2)))) {
            return false;
          }
        }
      }
    }
    return true;
  }
}