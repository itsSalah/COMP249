/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package Packages;

/**
 * Package to be transported in a Truck object.
 * Class is abstract to implement different types of packages.
 *
 */
abstract public class Package  {

    private String tracking_number;
    private double weight;
    private String package_type;

    /**
     * Constructor initializes and sets attributes of Package object.
     *
     * @param tracking_number
     * @param weight
     */
    public Package(String tracking_number, double weight) {
        this.tracking_number = tracking_number;
        this.weight = weight;
        setPackage_type();
    }

    /**
     * Method returns Package Tracking Number attribute.
     *
     * @return
     */
    public String getTracking_number() {
        return tracking_number;
    }

    /**
     * Method returns Package Weight attribute in pounds.
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method returns Package Type attribute.
     *
     * @return
     */
    public String getPackage_type() {
        return package_type;
    }

    /**
     * Takes String representing a Tracking Number.
     * Method sets the Tracking Number of Package object from the input.
     *
     * @param tracking_number
     */
    public void setTracking_number(String tracking_number){
        this.tracking_number = tracking_number;
        setPackage_type();

    }

    /**
     * Takes double value representing the weight.
     * Method sets the Weight of Package object from the input.
     *
     * @param weight
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

    /**
     * Method reads and filters the Tracking Number of Package objects loaded to truck.
     * Method sets the Type of Package it belongs to.
     *
     */
    private void setPackage_type() {
        char last_digit = tracking_number.charAt(tracking_number.length()-1);
        if (last_digit == '0') package_type = "Letter";
        else if (last_digit == '1') package_type = "Box";
        else if (last_digit == '2') package_type = "Wooden Crate";
        else if (last_digit == '3') package_type = "Metal Crate";
        else package_type = "Unknown";
    }

    /**
     * Method set to abstract type.
     * Method will implement different pricing for different Package Types.
     *
     * @return
     */
    abstract public double shipping_cost();

    /**
     * Takes weight in pounds.
     * Method converts weight to ounces.
     *
     * @param pound
     * @return
     */
    public static double toOunces(double pound){
        return pound*16.0;
    }

    /**
     * Takes weight in ounces.
     * Method converts weight to pounds.
     *
     * @param ounce
     * @return
     */
    public static double toPounds(double ounce){
        return ounce/16.0;
    }

    /**
     * Method displays Package object attributes.
     *
     * @return Tracking Number, Weight (in pounds and ounces)
     */
    @Override
    public String toString(){
        return "Package type: Unknown"+"  Tracking number: "+tracking_number+"  Weight: "+weight+ " lb; "
                +toOunces(weight)+" oz.";
    }

}
