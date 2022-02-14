package cs5004.marblesolitaire.model.piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * The test class for the empty piece.
 */
public class EmptyTest {

  private AbstractPiece testEmpty;

  @Before
  public void setUp() {
    testEmpty = new Empty();
  }

  @Test
  public void isEmpty() {
    assertTrue(testEmpty.isEmpty());
    assertFalse(testEmpty.isBlank());
    assertFalse(testEmpty.isMarble());
  }

  @Test
  public void testToString() {
    assertEquals("_", testEmpty.toString());
  }
}