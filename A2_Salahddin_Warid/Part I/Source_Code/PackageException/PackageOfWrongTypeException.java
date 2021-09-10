/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package PackageException;

/**
 * Signals that a Package of the wrong type exception has occurred.
 *
 */
public class PackageOfWrongTypeException extends Exception {

    /**
     * Constructs a PackageOfWrongTypeException with a specified detail message.
     *
     * @param message
     */
    public PackageOfWrongTypeException(String message){
        super(message);
        System.err.println("This package type can't be loaded.");

    }
}
