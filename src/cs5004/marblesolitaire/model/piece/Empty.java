package cs5004.marblesolitaire.model.piece;

/**
 * This is the class for the empty piece. The methods for this class include isMarble and
 * toString.
 */
public class Empty extends AbstractPiece {
  /**
   * The method isEmpty returns if the piece being inspected is a empty.
   *
   * @return boolean - true
   */
  @Override
  public boolean isEmpty() {
    return true;
  }

  /**
   * The method toString returns the string equivalent of the empty for the board which is "_".
   *
   * @return string - "_"
   */
  @Override
  public String toString() {
    return "_";
  }
}
