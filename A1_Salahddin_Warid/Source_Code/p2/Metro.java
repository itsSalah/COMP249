/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/

package p2;

/**
 * Metro represents a CityBus object
 *
 */
public class Metro extends CityBus {

    // The use of private restricted variables protects the Encapsulation principle of OOP.
    // All dependencies are contained inside the class, and values are restricted from the outside,
    // protecting the object attributes from outside the class (can only be mutated from inside).
    private int number_of_vehicules;
    private String the_name_of_the_city;

    /**
     * Constructs a Metro object and initializes values to 0
     *
     */
    public Metro() {
        this.number_of_vehicules = 0;
        this.the_name_of_the_city = null;
    }

    /**
     * Constructs and initializes a Metro object
     *
     * @param ticket_price
     * @param number_of_stops
     * @param route_number
     * @param begin_operation_year
     * @param line_name
     * @param drivers_name
     * @param number_of_vehicules
     * @param the_name_of_the_city
     */
    public Metro(double ticket_price, int number_of_stops, long route_number, int begin_operation_year, String line_name, String drivers_name, int number_of_vehicules, String the_name_of_the_city) {
        super(ticket_price, number_of_stops, route_number, begin_operation_year, line_name, drivers_name);
        this.number_of_vehicules = number_of_vehicules;
        this.the_name_of_the_city = the_name_of_the_city;
    }

    /**
     * Constructs and copies a Metro object form another object
     *
     * @param obj
     */
    public Metro(Metro obj) {
        super(obj);
        this.number_of_vehicules = obj.number_of_vehicules;
        this.the_name_of_the_city = obj.the_name_of_the_city;
    }

    /**
     * Gives the Number of vehicules of Metro object
     *
     * @return number_of_vehicules
     */
    public int getNumber_of_vehicules() {
        return number_of_vehicules;
    }

    /**
     * Gives the Name of the city of Metro object
     *
     * @return the_name_of_the_city
     */
    public String getThe_name_of_the_city() {
        return the_name_of_the_city;
    }

    /**
     * Sets the Number of vehicules of Metro object
     *
     * @param number_of_vehicules
     */
    public void setNumber_of_vehicules(int number_of_vehicules) {
        this.number_of_vehicules = number_of_vehicules;
    }

    /**
     * Sets the Name of the city of Metro object
     *
     * @param the_name_of_the_city
     */
    public void setThe_name_of_the_city(String the_name_of_the_city) {
        this.the_name_of_the_city = the_name_of_the_city;
    }

    /**
     * Prints Metro object attributes
     *
     * @return number_of_vehicules, the_name_of_the_city
     */
   @Override
    public String toString() {
        return super.toString()+ "\n" + "The metro has " + number_of_vehicules
                + " vehicules and is in the city of " + the_name_of_the_city + ".";
    }

    /**
     * Compares if Metro object is "equal to" another object
     * ( Checks compatibility of Class Types and null objects to avoid program from failing when comparing non-compatible attributes.
     * This avoids from searching non-existent attributes and prevents system crashes.)
     *
     * @param otherObject
     * @return
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else {
            Metro otherMetro = (Metro) otherObject;
            return (super.equals(otherMetro) &&
                    number_of_vehicules == otherMetro.number_of_vehicules &&
                    the_name_of_the_city.equals(otherMetro.the_name_of_the_city));
        }

    }
}