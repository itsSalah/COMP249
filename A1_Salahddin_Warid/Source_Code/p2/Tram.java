/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/

package p2;

/**
 * Tram represents a CityBus object
 *
 */
public class Tram extends CityBus {

    // The use of private restricted variables protects the Encapsulation principle of OOP.
    // All dependencies are contained inside the class, and values are restricted from the outside,
    // protecting the object attributes from outside the class (can only be mutated from inside).
    private int maximum_speed;

    /**
     * Constructs a Tram object and initializes values to 0
     *
     */
    public Tram() {
        this.maximum_speed = 0;
    }

    /**
     * Constructs and initializes a Tram object
     *
     * @param ticket_price
     * @param number_of_stops
     * @param route_number
     * @param begin_operation_year
     * @param line_name
     * @param drivers_name
     * @param maximum_speed
     */
    public Tram(double ticket_price, int number_of_stops, long route_number, int begin_operation_year,
                String line_name, String drivers_name, int maximum_speed) {
        super(ticket_price, number_of_stops, route_number, begin_operation_year, line_name, drivers_name);
        this.maximum_speed = maximum_speed;
    }

    /**
     * Constructs and copies a Tram object from another object
     *
     * @param obj
     */
    public Tram(Tram obj) {
        super(obj);
        this.maximum_speed = obj.maximum_speed;
    }

    /**
     * Gets maximum speed of the Tram object.
     *
     * @return
     */
    public int getMaximum_speed() {
        return maximum_speed;
    }

    /**
     * Sets Maximum speed of Tram object.
     *
     * @param maximum_speed
     */
    public void setMaximum_speed(int maximum_speed) {
        this.maximum_speed = maximum_speed;
    }

    /**
     * Prints Tram object attributes
     *
     * @return maximum_speed
     */
    @Override
    public String toString() {
        return super.toString()+ "\n" + "The city bus has a maximum speed of " + maximum_speed
                + " km/h.";
    }

    /**
     * Compares if Tram object is "equal to" another object
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
            Tram otherTram = (Tram) otherObject;
            return (super.equals(otherTram) &&
                    maximum_speed == otherTram.maximum_speed);
        }
    }
}