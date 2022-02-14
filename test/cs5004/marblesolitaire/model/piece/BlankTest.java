package cs5004.marblesolitaire.model.piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * The test class for the blank piece.
 */
public class BlankTest {

  private AbstractPiece testBlank;

  @Before
  public void setUp() {
    testBlank = new Blank();
  }

  @Test
  public void isBlank() {
    assertTrue(testBlank.isBlank());
    assertFalse(testBlank.isEmpty());
    assertFalse(testBlank.isEmpty());
  }

  @Test
  public void testToString() {
    assertEquals(" ", testBlank.toString());
  }
}