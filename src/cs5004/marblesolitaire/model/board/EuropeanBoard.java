package cs5004.marblesolitaire.model.board;

import java.util.ArrayList;

import cs5004.marblesolitaire.model.board.AbstractBoard;
import cs5004.marblesolitaire.model.piece.Blank;
import cs5004.marblesolitaire.model.piece.Empty;
import cs5004.marblesolitaire.model.piece.IPiece;
import cs5004.marblesolitaire.model.piece.Marble;

/**
 * This is the EuropeanBoard class which extends from the AbstractBoard class.
 */
public class EuropeanBoard extends AbstractBoard {

  /**
   * This is the constructor for the board class which takes in the thickness, an empty row and
   * empty column.
   *
   * @param thick - the thickness of the arm
   * @param eRow  - the row for the empty cell
   * @param eCol  - the col for the empty cell
   */
  public EuropeanBoard(int thick, int eRow, int eCol) {
    super(thick, eRow, eCol);
    this.board = makeBoard();
  }

  /**
   * The method makeBoard returns the array of the board. It is used in the constructor in the
   * board.
   *
   * @return ArrayList - the board
   */
  @Override
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
   * A helper function to checks if coordinates are in the empty quadrants of the board.
   *
   * @param row - the row under consideration
   * @param col - the col under consideration
   * @return boolean - T/F
   */
  @Override
  public boolean emptyQuadrant(int row, int col) {
    // top left quad
    if (col < thick - 1 && col < thick - (row + 1)) {
      return true;
    }
    // top right quad
    if (row < thick - 1 && col > thick * 2 + (row - 2)) {
      return true;
    }
    // bottom left quad
    if (row > thick * 2 - 2 && row > thick * 2 + (col - 2)) {
      return true;
    }
    // bottom right quad
    //if (col > thick * 2 - 2 && col - row < thick - 1) {
    return (col > thick * 2 - 2) && (row > thick * 2 - 2)
            && (col - (thick * 2 - 1) + (row - (thick * 2 - 1)) >= thick - 2);
  }
}
