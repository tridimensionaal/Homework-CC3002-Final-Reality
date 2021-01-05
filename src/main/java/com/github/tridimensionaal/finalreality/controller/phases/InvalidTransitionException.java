package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a invalid movement exception.
 *
 * @author Matías Salim Seda Auil
 */
public class InvalidTransitionException extends Exception {

  /**
   * Creates a new invalid transition exception.
   * @param message the message of the exception.
   *
   */
  public InvalidTransitionException(String message) {
    super(message);
  }
}
