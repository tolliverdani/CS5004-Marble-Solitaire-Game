package cs5004.marblesolitaire.model.board;

import java.util.ArrayList;

import cs5004.marblesolitaire.model.piece.IPiece;
import cs5004.marblesolitaire.model.piece.Blank;
import cs5004.marblesolitaire.model.piece.Empty;
import cs5004.marblesolitaire.model.piece.Marble;

/**
 * This is the Board class which creates the board for the marble game.
 */
public class AbstractBoard implements IBoard {

  protected ArrayList<ArrayList<IPiece>> board;
  protected final int emptyRow;
  protected final int emptyCol;
  protected final int boardLength;
  protected final int lowerLimit;
  protected final int upperLimit;
  protected final int thick;

  /**
   * This is the constructor for the board class which takes in the thickness, an empty row and
   * empty column.
   *
   * @param thick - the thickness of the arm
   * @param eRow  - the row for the empty cell
   * @param eCol  - the col for the empty cell
   */
  public AbstractBoard(int thick, int eRow, int eCol) {
    this.thick = thick;
    this.emptyRow = eRow;
    this.emptyCol = eCol;
    this.boardLength = thick * 3 - 2;
    this.lowerLimit = thick - 1;
    this.upperLimit = thick * 2 - 1;
    this.board = makeBoard();
  }

  /**
   * The method getScore returns the current score of the game based on the marbles left.
   *
   * @return int - the score based on the marble counter
   */
  public int getScore() {
    int count = 0;
    for (ArrayList<IPiece> iPieces : board) {
      for (IPiece iPiece : iPieces) {
        if (iPiece.toString().equals("O")) {
          count += 1;
        }
      }
    }
    return count;
  }

  /**
   * The method onBoard checks if coordinates are on the board.
   *
   * @param row - the row under consideration
   * @param col - the col under consideration
   * @return boolean - T/F
   */
  public boolean onBoard(int row, int col) {
    return ((row >= 0) && (col >= 0)
            && (row < this.boardLength) && (col < this.boardLength));
  }

  /**
   * A helper function to checks if coordinates are in the empty quadrants of the board.
   *
   * @param row - the row under consideration
   * @param col - the col under consideration
   * @return boolean - T/F
   */
  public boolean emptyQuadrant(int row, int col) {
    // top left quadrant
    if ((row < lowerLimit) && (col < lowerLimit || col >= upperLimit)) {
      return true;
    }
    // bottom left quadrant
    return (row >= upperLimit) && (col < lowerLimit || col >= upperLimit);
  }

  /**
   * The method makeBoard returns the array of the board. It is used in the constructor in the
   * board.
   *
   * @return ArrayList - the board
   */
  public ArrayList<ArrayList<IPiece>> makeBoard() throws IllegalArgumentException {
    // initialize main board and boardRow
    ArrayList<ArrayList<IPiece>> board = new ArrayList<>();

    // using a for loop to get list within list for each row
    for (int row = 0; row < this.boardLength; row++) {
      ArrayList<IPiece> boardRow = new ArrayList<>();
      for (int col = 0; col < this.boardLength; col++) {
        // if it is the coordinate for the empty spot, put '_'
        if ((row == this.emptyRow) && (col == this.emptyCol)) {
          boardRow.add(col, new Empty());
        } else if (emptyQuadrant(row, col)) {
          boardRow.add(col, new Blank());
        } else {
          boardRow.add(col, new Marble());
        }
      }
      // then add each boardRow to the main board list
      board.add(row, boardRow);
    }
    //checkEmptySpot(emptyRow, emptyCol);
    return board;
  }

  /**
   * A helper method to determine if the move is a valid horizontal move.
   *
   * @param fromRow - the from row coordinate
   * @param fromCol - the from col coordinate
   * @param toRow   - the to row coordinate
   * @param toCol   - the to col coordinate
   * @return boolean (T/F)
   */
  protected boolean horizontalMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (fromRow == toRow && ((fromCol > toCol) || (fromCol < toCol))
            && Math.abs(fromCol - toCol) == 2);
  }

  /**
   * A helper method to determine if the move is a valid vertical move.
   *
   * @param fromRow - the from row coordinate
   * @param fromCol - the from col coordinate
   * @param toRow   - the to row coordinate
   * @param toCol   - the to col coordinate
   * @return boolean (T/F)
   */
  protected boolean verticalMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (fromCol == toCol && ((fromRow > toRow) || (fromRow < toRow))
            && Math.abs(fromRow - toRow) == 2);
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
  public boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    // updated this to be cleaner
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
    }
    return false;
  }

  /**
   * A helper function to update the middle marble during the move.
   *
   * @param fromRow - the row for the "from" marble
   * @param fromCol - the col for the "from" marble
   * @param toRow   - the row for the "to" marble
   * @param toCol   - the col for the "to" marble
   */
  public void middleMove(int fromRow, int fromCol, int toRow, int toCol) {
    int colDir = 0;
    int rowDir = 0;

    if (fromCol > toCol) {
      colDir = fromCol - 1;
    } else if (fromCol < toCol) {
      colDir = fromCol + 1;
    } else {
      colDir = fromCol;
    }
    if (fromRow > toRow) {
      rowDir = fromRow - 1;
    } else if (fromRow < toRow) {
      rowDir = fromRow + 1;
    } else {
      rowDir = fromRow;
    }
    board.get(rowDir).set(colDir, new Empty());
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
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (validMove(fromRow, fromCol, toRow, toCol)) {
      // alter the from location to be "_'
      board.get(fromRow).set(fromCol, new Empty());
      // alter the middle marble location to be "_'
      middleMove(fromRow, fromCol, toRow, toCol);
      // alter the to location to be "O"
      board.get(toRow).set(toCol, new Marble());
    }
  }

  /**
   * The method isGameOver determines the status of the game by scanning all remaining marbles and
   * checking if they have any valid moves.
   *
   * @return boolean - T/F
   */
  public boolean isGameOver() {
    for (int row = 0; row < boardLength; row++) {
      for (int col = 0; col < board.get(row).size(); col++) {
        if (board.get(row).get(col).toString().equals("O")) {
          // updated this to be cleaner
          if ((onBoard(row, col + 2) && (validMove(row, col, row, col + 2)))
                  || ((onBoard(row, col - 2)) && (validMove(row, col, row, col - 2)))
                  || ((onBoard(row + 2, col)) && (validMove(row, col, row + 2, col)))
                  || ((onBoard(row - 2, col)) && (validMove(row, col, row - 2, col)))) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * The method getGameState prints out a version of the board in text for the end user.
   *
   * @return String - a string representation of the game
   */
  public String getGameState() {
    StringBuilder bString = new StringBuilder();
    // printing the board with rows
    for (int row = 0; row < this.board.size(); row++) {
      for (int col = 0; col < this.boardLength; col++) {
        if ((col >= lowerLimit) && (board.get(row).get(col).toString().equals(" "))) {
          bString.append("");
        } else {
          bString.append(board.get(row).get(col).toString()).append(" ");
        }
      }
      if ((row > lowerLimit) || (row < upperLimit)) {
        bString = new StringBuilder(bString.substring(0, bString.length() - 1) + "\n");
      } else {
        bString.append("\n");
      }
    }
    // then print the final bString without the last \n
    return bString.substring(0, bString.length() - 1);
  }
}