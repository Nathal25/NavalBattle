/**
 * Class {@code InvalidCoordinatesException} extends {@link java.lang.Exception}
 * This class creates a new exception to be thrown when a set of invalid coordinates are given
 */
package com.example.navalbattle.model.Exceptions;

public class InvalidCoordinatesException extends Exception {
    public InvalidCoordinatesException(String message) {
        super(message);
    }
}
