package cs5004.marblesolitaire.model.piece;

/**
 * This is the class for the marble piece. The methods for this class include isMarble and
 * toString.
 */
public class Marble extends AbstractPiece {
  /**
   * The method isMarble returns if the piece being inspected is a marble. The default for the
   * abstract class is false.
   *
   * @return boolean - true
   */
  @Override
  public boolean isMarble() {
    return true;
  }

  /**
   * The method toString returns the string equivalent of the marble for the board which is "O".
   *
   * @return string - "O"
   */
  @Override
  public String toString() {
    return "O";
  }
}
