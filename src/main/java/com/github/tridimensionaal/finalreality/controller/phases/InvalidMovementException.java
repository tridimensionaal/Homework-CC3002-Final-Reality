
package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a invalid movement exception.
 *
 * @author Matías Salim Seda Auil
 */
public class InvalidMovementException extends Exception {
  /**
   * Creates a new invalid movement exception.
   * @param message the message of the exception.
   *
   */
    public InvalidMovementException(String message) {
        super(message);
    }
}
