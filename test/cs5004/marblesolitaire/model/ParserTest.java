package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.Parser;
import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;

import static org.junit.Assert.assertEquals;

/**
 * This is a test file for the parser class which makes sure it works.
 */
public class ParserTest {

  private Appendable appendable;
  private MarbleSolitaireController controller;
  private Parser parser;

  @Before
  public void setup() {
    appendable = new StringBuilder();
  }

  @Test
  public void englishBoardDefault() {
    parser = new Parser("english");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n\n", appendable.toString());
  }

  @Test
  public void englishBoardCustomSizeAndHole() {
    parser = new Parser("english -size 5 -hole 6 7");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O _ O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 104\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O _ O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 104\n\n", appendable.toString());
  }

  @Test
  public void europeanBoardDefault() {
    parser = new Parser("european");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n\n", appendable.toString());
  }

  @Test
  public void europeanBoardCustomSizeAndHole() {
    parser = new Parser("european -size 7 -hole 5 4");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("            O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "  O O O _ O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "            O O O O O O O\n"
            + "Score: 276\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "            O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "  O O O _ O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "            O O O O O O O\n"
            + "Score: 276\n\n", appendable.toString());
  }

  @Test
  public void triangleBoardDefault() {
    parser = new Parser("triangle");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 14\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O\n"
            + "Score: 14\n\n", appendable.toString());
  }

  @Test
  public void triangleBoardCustomSizeAndHole() {
    parser = new Parser("triangle -size 15 -hole 3 2");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("              O\n"
            + "             O O\n"
            + "            O O O\n"
            + "           O O _ O\n"
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
            + "O O O O O O O O O O O O O O O\n"
            + "Score: 119\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "              O\n"
            + "             O O\n"
            + "            O O O\n"
            + "           O O _ O\n"
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
            + "O O O O O O O O O O O O O O O\n"
            + "Score: 119\n\n", appendable.toString());
  }

  @Test
  public void triangleBoardCustomSizeAndHoleRev() {
    parser = new Parser("triangle -hole 3 2 -size 15");
    controller = new MarbleSolitaireControllerImpl(new StringReader("q"), appendable);
    controller.playGame(parser.findBoardType());
    assertEquals("              O\n"
            + "             O O\n"
            + "            O O O\n"
            + "           O O _ O\n"
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
            + "O O O O O O O O O O O O O O O\n"
            + "Score: 119\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "              O\n"
            + "             O O\n"
            + "            O O O\n"
            + "           O O _ O\n"
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
            + "O O O O O O O O O O O O O O O\n"
            + "Score: 119\n\n", appendable.toString());
  }
}