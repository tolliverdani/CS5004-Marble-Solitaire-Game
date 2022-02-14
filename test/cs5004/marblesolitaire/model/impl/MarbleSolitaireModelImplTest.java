
package cs5004.marblesolitaire.model.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * This is the MarbleSolitaireModelImplTest to test the interface.
 */
public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModelImpl defaultBoard;
  private MarbleSolitaireModelImpl customEmpty;
  private MarbleSolitaireModelImpl customSize;
  private MarbleSolitaireModelImpl customEmptyAndSize;

  @Before
  public void setUp() {
    defaultBoard = new MarbleSolitaireModelImpl();
    customEmpty = new MarbleSolitaireModelImpl(3, 4);
    customSize = new MarbleSolitaireModelImpl(5);
    customEmptyAndSize = new MarbleSolitaireModelImpl(7, 9, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUpEven() {
    // testing the failure when the thickness param is an even number
    MarbleSolitaireModelImpl corrupt = new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUpEmptyAndEven() {
    // testing the failure when the thickness param is an even number but col and row are OK
    MarbleSolitaireModelImpl corrupt = new MarbleSolitaireModelImpl(2, 4, 3);
  }

  @Test
  public void testMove() {
    defaultBoard.move(5, 3, 3, 3);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O", defaultBoard.getGameState());
    assertEquals(31, defaultBoard.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertFalse(defaultBoard.isGameOver());
  }

  @Test
  public void testGetGameState() {
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", defaultBoard.getGameState());

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", customEmpty.getGameState());

    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", customSize.getGameState());

    assertEquals("            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O", customEmptyAndSize.getGameState());
  }

  @Test
  public void testGetScore() {
    assertEquals(32, defaultBoard.getScore());
    assertEquals(32, customEmpty.getScore());
    assertEquals(104, customSize.getScore());
    assertEquals(216, customEmptyAndSize.getScore());
  }

}
