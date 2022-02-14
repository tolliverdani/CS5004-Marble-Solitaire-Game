package cs5004.marblesolitaire.model.piece;

/**
 * This is the class for the abstract piece which has a default value of false for all methods.
 */
public class AbstractPiece implements IPiece {

  /**
   * The method isMarble returns if the piece being inspected is a marble. The default for the
   * abstract class is false.
   *
   * @return boolean - false
   */
  @Override
  public boolean isMarble() {
    return false;
  }

  /**
   * The method isEmpty returns if the piece being inspected is a empty. The default for the
   * abstract class is false.
   *
   * @return boolean - false
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * The method isBlank returns if the piece being inspected is blank. The default for the abstract
   * class is false.
   *
   * @return boolean - false
   */
  @Override
  public boolean isBlank() {
    return false;
  }
}
