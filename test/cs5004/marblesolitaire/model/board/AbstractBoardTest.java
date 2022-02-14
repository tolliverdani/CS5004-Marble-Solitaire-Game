package cs5004.marblesolitaire.model.board;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class to test my board class and all of it's methods.
 */
public class AbstractBoardTest {

  private IBoard defaultBoard;
  private IBoard customEmpty;
  private IBoard customSize;
  private IBoard customEmptyAndSize;

  @Before
  public void setUp() {
    defaultBoard = new AbstractBoard(3, 3, 3);
    customEmpty = new AbstractBoard(3, 3, 4);
    customSize = new AbstractBoard(5, 5, 5);
    customEmptyAndSize = new AbstractBoard(7, 9, 12);
  }

  @Test
  public void getScore() {
    assertEquals(32, defaultBoard.getScore());
    assertEquals(32, customEmpty.getScore());
    assertEquals(104, customSize.getScore());
    assertEquals(216, customEmptyAndSize.getScore());
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
  public void getGameState() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", defaultBoard.getGameState());

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", customEmpty.getGameState());

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", customSize.getGameState());

    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
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
  public void testMoveDefaultBoard() {
    defaultBoard.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O", defaultBoard.getGameState());
  }

  @Test
  public void testMoveCustomEmptyBoard() {
    customEmpty.move(3, 2, 3, 4);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", customEmpty.getGameState());
  }

  @Test
  public void testMoveCustomSizeBoard() {
    customSize.move(7, 5, 5, 5);
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", customSize.getGameState());
  }

  @Test
  public void testMoveCustomEmptyAndSizeBoard() {
    customEmptyAndSize.move(11, 12, 9, 12);
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", customEmptyAndSize.getGameState());
  }

}