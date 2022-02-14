package cs5004.marblesolitaire.model.impl;

import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class to test my board class and all of it's methods.
 */
public class TriangleSolitaireModelImplTest {

  private MarbleSolitaireModel defaultBoard;
  private MarbleSolitaireModel customEmpty;
  private MarbleSolitaireModel customSize;
  private MarbleSolitaireModel customEmptyAndSize;
  private Appendable appendable;

  @Before
  public void setUp() {
    defaultBoard = new TriangleSolitaireModelImpl();
    customEmpty = new TriangleSolitaireModelImpl(2, 2);
    customSize = new TriangleSolitaireModelImpl(15);
    customEmptyAndSize = new TriangleSolitaireModelImpl(7, 2, 1);
    appendable = new StringBuilder();
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUpEven() {
    // testing the failure when the thickness param is an even number
    TriangleSolitaireModelImpl corrupt = new TriangleSolitaireModelImpl(-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUpEmptyAndEven() {
    // testing the failure when the thickness param is an even number but col and row are OK
    TriangleSolitaireModelImpl corrupt = new TriangleSolitaireModelImpl(2, 0, 3);
  }

  @Test
  public void testOneMove() {
    defaultBoard.move(2, 0, 0, 0);
    assertEquals("    O\n"
            + "   _ O\n"
            + "  _ O O\n"
            + " O O O O\n"
            + "O O O O O", defaultBoard.getGameState());
    assertEquals(13, defaultBoard.getScore());
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

    assertEquals("              _\n"
            + "             O O\n"
            + "            O O O\n"
            + "           O O O O\n"
            + "          O O O O O\n"
            + "         O O O O O O\n"
            + "        O O O O O O O\n"
            + "       O O O O O O O O\n"
            + "      O O O O O O O O O\n"
            + "     O O O O O O O O O O\n"
            + "    O O O O O O O O O O O\n"
            + "   O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O\n"
            + " O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O", customSize.getGameState());

    assertEquals("      O\n"
            + "     O O\n"
            + "    O _ O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", customEmptyAndSize.getGameState());
  }

  @Test
  public void testGetScore() {
    assertEquals(14, defaultBoard.getScore());
    assertEquals(14, customEmpty.getScore());
    assertEquals(119, customSize.getScore());
    assertEquals(27, customEmptyAndSize.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertFalse(defaultBoard.isGameOver());
  }

  @Test
  public void playGameWon() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
            new StringReader("3 1 1 1 "
                    + "3 3 3 1 "
                    + "1 1 3 3 "
                    + "4 1 2 1 "
                    + "5 3 3 1 "
                    + "2 1 4 1 "
                    + "4 4 4 2 "
                    + "4 1 4 3 "
                    + "5 5 5 3 "
                    + "5 2 5 4 "
                    + "3 3 5 3 "
                    + "5 4 5 2 "
                    + "5 1 5 3 q"),
            appendable);
    controller.playGame(new TriangleSolitaireModelImpl());
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 14\n"
            + "    O\n"
            + "   _ O\n"
            + "  _ O O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 13\n"
            + "    O\n"
            + "   _ O\n"
            + "  O _ _\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 12\n"
            + "    _\n"
            + "   _ _\n"
            + "  O _ O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 11\n"
            + "    _\n"
            + "   O _\n"
            + "  _ _ O\n"
            + " _ O O O\n"
            + "O O O O O\n"
            + "Score: 10\n"
            + "    _\n"
            + "   O _\n"
            + "  O _ O\n"
            + " _ _ O O\n"
            + "O O _ O O\n"
            + "Score: 9\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ O\n"
            + " O _ O O\n"
            + "O O _ O O\n"
            + "Score: 8\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ O\n"
            + " O O _ _\n"
            + "O O _ O O\n"
            + "Score: 7\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ O\n"
            + " _ _ O _\n"
            + "O O _ O O\n"
            + "Score: 6\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ O\n"
            + " _ _ O _\n"
            + "O O O _ _\n"
            + "Score: 5\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ O\n"
            + " _ _ O _\n"
            + "O _ _ O _\n"
            + "Score: 4\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ _\n"
            + " _ _ _ _\n"
            + "O _ O O _\n"
            + "Score: 3\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ _\n"
            + " _ _ _ _\n"
            + "O O _ _ _\n"
            + "Score: 2\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ _\n"
            + " _ _ _ _\n"
            + "_ _ O _ _\n"
            + "Score: 1\n"
            + "Game over!\n"
            + "    _\n"
            + "   _ _\n"
            + "  _ _ _\n"
            + " _ _ _ _\n"
            + "_ _ O _ _\n"
            + "Score: 1\n", appendable.toString());
  }

}