package cs5004.marblesolitaire.model;

import java.util.Scanner;

import cs5004.marblesolitaire.model.impl.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.impl.EuropeanSolitaireModelImpl;
import cs5004.marblesolitaire.model.impl.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.impl.TriangleSolitaireModelImpl;

/**
 * This is the parser for the command line arguments.
 */
public class Parser {

  private Scanner scanner;

  public Parser(String input) {
    scanner = new Scanner(input);
  }

  /**
   * The findBoard type method gets the board type from the inputs.
   *
   * @return the model for the controller to use
   */
  public MarbleSolitaireModel findBoardType() {

    int size = 3;
    int holeRow = size;
    int holeCol = size;

    while (scanner.hasNext()) {

      String boardType = scanner.next();

      // if the boardType is english
      if (boardType.equals("English") || boardType.equals("english")) {
        while (scanner.hasNext()) {
          String nextTerm = scanner.next();
          if (nextTerm.equals("-size")) {
            size = scanner.nextInt();
          }
          if (nextTerm.equals("-hole")) {
            holeRow = scanner.nextInt();
            holeCol = scanner.nextInt();
          } else {
            holeRow = size;
            holeCol = size;
          }
        }
        // return the default / English model impl
        return new MarbleSolitaireModelImpl(size, holeRow, holeCol);
      }

      // if the boardType is european
      if (boardType.equals("European") || boardType.equals("european")) {
        while (scanner.hasNext()) {
          String nextTerm = scanner.next();
          if (nextTerm.equals("-size")) {
            size = scanner.nextInt();
          }
          if (nextTerm.equals("-hole")) {
            holeRow = scanner.nextInt();
            holeCol = scanner.nextInt();
          } else {
            holeRow = size;
            holeCol = size;
          }
        }
        // return the European model impl
        return new EuropeanSolitaireModelImpl(size, holeRow, holeCol);
      }

      // if the boardType is a triangle
      if (boardType.equals("Triangle") || boardType.equals("triangle")) {
        size = 5;
        holeRow = 0;
        holeCol = 0;

        while (scanner.hasNext()) {
          String nextTerm = scanner.next();
          if (nextTerm.equals("-size")) {
            size = scanner.nextInt();
          }
          if (nextTerm.equals("-hole")) {
            holeRow = scanner.nextInt();
            holeCol = scanner.nextInt();
          }
        }
        // return the Triangle model impl
        return new TriangleSolitaireModelImpl(size, holeRow, holeCol);
      }
    }

    // and if there are no items to iterate on...
    return new MarbleSolitaireModelImpl();
  }
}
