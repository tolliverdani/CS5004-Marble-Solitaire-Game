package cs5004.marblesolitaire.model.piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * The test class for the abstract piece.
 */
public class AbstractPieceTest {

  private AbstractPiece testAbstractPiece;

  @Before
  public void setUp() {
    testAbstractPiece = new AbstractPiece();
  }

  @Test
  public void isMarble() {
    assertFalse(testAbstractPiece.isMarble());
  }

  @Test
  public void isEmpty() {
    assertFalse(testAbstractPiece.isEmpty());
  }

  @Test
  public void isBlank() {
    assertFalse(testAbstractPiece.isBlank());
  }
}