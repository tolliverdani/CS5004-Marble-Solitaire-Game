package cs5004.marblesolitaire.model.piece;

/**
 * This is the interface for the piece classes. The methods include isMarble, isEmpty, and isBlank.
 */
public interface IPiece {
  /**
   * The method isMarble returns if the piece being inspected is a marble. The default for the
   * abstract class is false.
   *
   * @return boolean - false
   */
  boolean isMarble();

  /**
   * The method isEmpty returns if the piece being inspected is a empty. The default for the
   * abstract class is false.
   *
   * @return boolean - false
   */
  boolean isEmpty();

  /**
   * The method isBlank returns if the piece being inspected is blank. The default for the abstract
   * class is false.
   *
   * @return boolean - false
   */
  boolean isBlank();
}
