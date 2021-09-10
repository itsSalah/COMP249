/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package Packages;

/**
 *  Crate represents a Type of Package object. Extends and Implements the Package class.
 *  Class is abstract to implement different type of crates.
 *
 */
abstract public class Crate extends Package {

    /**
     * Constructor initializes and sets attributes of Crate object.
     *
     * @param tracking_number
     * @param weight
     */
    public Crate(String tracking_number, double weight){
        super(tracking_number, weight);
    }

}
