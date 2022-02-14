import java.io.InputStreamReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.Parser;

/**
 * This is a main class file so I can test the game live.
 */
public class Main {

  /**
   * Here is the constructor for the model and controller in the main file. It takes in args which
   * is the string from the user input.
   *
   * @param args - the string input from user
   */
  public static void main(String[] args) {
    StringBuilder input = new StringBuilder();
    for (String arg : args) {
      input.append(arg).append(" ");
    }
    System.out.println(input);

    Parser parser = new Parser(input.toString());
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
            new InputStreamReader(System.in), System.out);
    controller.playGame(parser.findBoardType());
  }
}
