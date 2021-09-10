/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package PackageException;

/**
 * Signals that a Package not loaded due to a full Truck exception has occurred.
 *
 */
public class PackageNotLoadedTruckFull extends Exception {

    /**
     * Constructs a PackageNotLoadedTruckFull with a specified detail message.
     *
     * @param message
     */
    public PackageNotLoadedTruckFull(String message){
        super(message);
        System.err.println("The package can't be loaded since the truck is full.");
    }

}