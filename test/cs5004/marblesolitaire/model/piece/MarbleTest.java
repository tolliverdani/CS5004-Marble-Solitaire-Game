package cs5004.marblesolitaire.model.piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * The test class for the marble piece.
 */
public class MarbleTest {

  private AbstractPiece testMarble;

  @Before
  public void setUp() {
    testMarble = new Marble();
  }

  @Test
  public void isMarble() {
    assertTrue(testMarble.isMarble());
    assertFalse(testMarble.isEmpty());
    assertFalse(testMarble.isBlank());
  }

  @Test
  public void testToString() {
    assertEquals("O", testMarble.toString());
  }
}