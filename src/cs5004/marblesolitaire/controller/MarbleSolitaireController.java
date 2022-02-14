package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.impl.MarbleSolitaireModel;

/**
 * The interface for the marble solitaire controller. It only has one method, playGame.
 */
public interface MarbleSolitaireController {
  /**
   * This method plays a new game of marble solitaire using the passed in model. Will throw an
   * exception if the model is null or if the controller is unable to receive input / give output.
   *
   * @param model - the model passed in to play the game
   */
  void playGame(MarbleSolitaireModel model);
}
