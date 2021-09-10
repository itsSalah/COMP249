/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package PackageException;

/**
 * Signals that a Package too heavy exception has occurred.
 *
 */
public class PackageTooHeavyException extends Exception {

    /**
     * Constructs a PackageTooHeavyException with a specified detail message.
     *
     * @param message
     */
    public PackageTooHeavyException(String message){
        super(message);
        System.err.println("The package is too heavy to be loaded.");
    }
}
