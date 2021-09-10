/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package Packages;

/**
 * Box represents a Type of Package object. Extends and Implements the Package class.
 *
 */
public class Box extends Package {

    /**
     * Constructor initializes and sets attributes of Box object.
     *
     * @param tracking_number
     * @param weight
     */
    public Box(String tracking_number, double weight) {
        super(tracking_number, weight);
    }

    /**
     * Method returns the shipping cost of Box package based on the weight in pounds.
     *
     * @return Shipping Cost
     */
    @Override
    public double shipping_cost() {
        return 2*getWeight();
    }

    /**
     * Method displays Box object attributes.
     *
     * @return Package Type, tracking Number, Weight (in pounds and in ounces)
     */
    @Override
    public String toString(){
        return "Package type: "+getPackage_type()+"  Tracking number: "+getTracking_number()
                +"  Weight: "+getWeight()+ " lb; "
                +toOunces(getWeight())+" oz.";
    }

}
