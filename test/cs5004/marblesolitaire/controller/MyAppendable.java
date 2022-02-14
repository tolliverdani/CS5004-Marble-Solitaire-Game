package cs5004.marblesolitaire.controller;

import java.io.IOException;

/**
 * This is a test class called MyAppendable to test the IOExceptions in the controller.
 */
public class MyAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("For testing purposes.");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("For testing purposes.");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("For testing purposes.");
  }
}
