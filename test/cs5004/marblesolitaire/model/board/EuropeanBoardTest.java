package cs5004.marblesolitaire.model.board;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class to test my board class and all of it's methods.
 */
public class EuropeanBoardTest {

  private AbstractBoard defaultBoard;
  private AbstractBoard customEmpty;
  private AbstractBoard customSize;
  private AbstractBoard customEmptyAndSize;

  @Before
  public void setUp() {
    defaultBoard = new EuropeanBoard(3, 3, 3);
    customEmpty = new EuropeanBoard(3, 3, 4);
    customSize = new EuropeanBoard(5, 5, 5);
    customEmptyAndSize = new EuropeanBoard(7, 9, 12);
  }

  @Test
  public void getScore() {
    assertEquals(36, defaultBoard.getScore());
    assertEquals(36, customEmpty.getScore());
    assertEquals(128, customSize.getScore());
    assertEquals(276, customEmptyAndSize.getScore());
  }

  @Test
  public void onBoard() {
    assertTrue(defaultBoard.onBoard(3, 2));
    assertTrue(customEmpty.onBoard(3, 2));
    assertTrue(customSize.onBoard(3, 2));
    assertTrue(customEmptyAndSize.onBoard(3, 2));

    assertFalse(defaultBoard.onBoard(-1, 2));
    assertFalse(customEmpty.onBoard(-1, 2));
    assertFalse(customSize.onBoard(15, 2));
    assertFalse(customEmptyAndSize.onBoard(50, 2));
  }

  @Test
  public void testGetGameState() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", defaultBoard.getGameState());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", customEmpty.getGameState());

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", customSize.getGameState());

    assertEquals("            O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "            O O O O O O O", customEmptyAndSize.getGameState());
  }

  @Test
  public void testValidMode() {
    assertTrue(defaultBoard.validMove(5, 3, 3, 3));
    assertTrue(defaultBoard.validMove(1, 3, 3, 3));
    assertTrue(defaultBoard.validMove(3, 1, 3, 3));
    assertTrue(defaultBoard.validMove(3, 5, 3, 3));
  }

  @Test
  public void testMove() {
    defaultBoard.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", defaultBoard.getGameState());
  }
}