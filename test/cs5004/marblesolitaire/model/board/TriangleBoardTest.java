package cs5004.marblesolitaire.model.board;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class to test my board class and all of it's methods.
 */
public class TriangleBoardTest {

  private IBoard defaultBoard;
  private IBoard customEmpty;
  private IBoard customSize;
  private IBoard customEmptyAndSize;

  @Before
  public void setUp() {
    defaultBoard = new TriangleBoard(5, 0, 0);
    customEmpty = new TriangleBoard(5, 2, 2);
    customSize = new TriangleBoard(10, 0, 0);
    customEmptyAndSize = new TriangleBoard(10, 5, 4);
  }

  @Test
  public void getScore() {
    assertEquals(14, defaultBoard.getScore());
    assertEquals(14, customEmpty.getScore());
    assertEquals(54, customSize.getScore());
    assertEquals(54, customEmptyAndSize.getScore());
  }

  @Test
  public void onBoard() {
    assertTrue(defaultBoard.onBoard(1, 1));
    assertTrue(customEmpty.onBoard(2, 2));
    assertTrue(customSize.onBoard(3, 2));
    assertTrue(customEmptyAndSize.onBoard(5, 2));

    assertFalse(defaultBoard.onBoard(-1, 2));
    assertFalse(customEmpty.onBoard(-1, 2));
    assertFalse(customSize.onBoard(15, 2));
    assertFalse(customEmptyAndSize.onBoard(50, 2));
  }

  @Test
  public void testGetGameState() {
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", defaultBoard.getGameState());

    assertEquals("    O\n"
            + "   O O\n"
            + "  O O _\n"
            + " O O O O\n"
            + "O O O O O", customEmpty.getGameState());

    assertEquals("         _\n"
            + "        O O\n"
            + "       O O O\n"
            + "      O O O O\n"
            + "     O O O O O\n"
            + "    O O O O O O\n"
            + "   O O O O O O O\n"
            + "  O O O O O O O O\n"
            + " O O O O O O O O O\n"
            + "O O O O O O O O O O", customSize.getGameState());

    assertEquals("         O\n"
            + "        O O\n"
            + "       O O O\n"
            + "      O O O O\n"
            + "     O O O O O\n"
            + "    O O O O _ O\n"
            + "   O O O O O O O\n"
            + "  O O O O O O O O\n"
            + " O O O O O O O O O\n"
            + "O O O O O O O O O O", customEmptyAndSize.getGameState());
  }

  @Test
  public void testValidMode() {
    assertTrue(customEmpty.validMove(4, 2, 2, 2));
    assertTrue(customEmpty.validMove(2, 0, 2, 2));
    assertTrue(customEmpty.validMove(4, 4, 2, 2));
    assertTrue(customEmpty.validMove(0, 0, 2, 2));
    assertTrue(customEmpty.validMove(4, 0, 2, 2));
  }

  @Test
  public void testMove() {
    defaultBoard.move(2, 0, 0, 0);
    assertEquals("    O\n"
            + "   _ O\n"
            + "  _ O O\n"
            + " O O O O\n"
            + "O O O O O", defaultBoard.getGameState());
  }

}