package cs5004.marblesolitaire.model.piece;

/**
 * This is the class for the blank piece. The methods for this class include isMarble and
 * toString.
 */
public class Blank extends AbstractPiece {
  /**
   * The method isBlank returns if the piece being inspected is blank.
   *
   * @return boolean - true
   */
  @Override
  public boolean isBlank() {
    return true;
  }

  /**
   * The method toString returns the string equivalent of the blank for the board which is " ".
   *
   * @return string - " "
   */
  @Override
  public String toString() {
    return " ";
  }
}
