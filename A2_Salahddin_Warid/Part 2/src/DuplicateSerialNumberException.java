/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

/**
 * DuplicateSerialNumberException class extends Excepton class.
 * Used to debug duplicate serial number attributes of Warship objects.
 *
 */
public class DuplicateSerialNumberException extends Exception {
    /**
     * Default constructor of DuplicateSerialNumberException object.
     *
     * @param string
     */
    public DuplicateSerialNumberException(String string) {
        super(string);
    }
}
