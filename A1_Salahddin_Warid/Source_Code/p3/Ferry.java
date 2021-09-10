/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/

package p3;

import p1.PublicTransportation;

/**
 * Ferry represents a PublicTransport object
 *
 */
public class Ferry extends PublicTransportation {

    // The use of private restricted variables protects the Encapsulation principle of OOP.
    // All dependencies are contained inside the class, and values are restricted from the outside,
    // protecting the object attributes from outside the class (can only be mutated from inside).
    private int build_year;
    private String ship_name;

    /**
     * Constructs aFerry object and initializes values to 0
     *
     */
    public Ferry() {
        this.build_year = 0;
        this.ship_name = null;
    }

    /**
     * Constructs and initializes a Ferry object
     *
     * @param ticket_price
     * @param number_of_stops
     * @param build_year
     * @param ship_name
     */
    public Ferry(double ticket_price, int number_of_stops, int build_year, String ship_name) {
        super(ticket_price, number_of_stops);
        this.build_year = build_year;
        this.ship_name = ship_name;
    }

    /**
     * Constructs and copies Ferry object from another object
     *
     * @param obj
     */
    public Ferry(Ferry obj) {
        super(obj);
        this.build_year = obj.build_year;
        this.ship_name = obj.ship_name;
    }

    /**
     * Gives the Build year of Ferry object
     *
     * @return build_year
     */
    public int getBuild_year() {
        return build_year;
    }

    /**
     * Gives the Ship name of Ferry object
     *
     * @return ship_name
     */
    public String getShip_name() {
        return ship_name;
    }

    /**
     * Sets Build year of Ferry object
     *
     * @param build_year
     */
    public void setBuild_year(int build_year) {
        this.build_year = build_year;
    }

    /**
     * Sets Ship name of Ferry object
     *
     * @param ship_name
     */
    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    /**
     * Prints Ferry object attributes
     *
     * @return build_year, ship_name
     */
    @Override
    public String toString(){
        return super.toString()+ "\n"+"The ferry was built in "+ build_year
                +" and its name is "+ship_name+".";
    }

    /**
     * Compares if Ferry object is "equal to" another object
     * ( Checks compatibility of Class Types and null objects to avoid program from failing when comparing non-compatible attributes.
     * This avoids from searching non-existent attributes and prevents system crashes.)
     *
     * @param otherObject - Comparative object
     * @return
     */
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else
        {
            Ferry otherFerry = (Ferry) otherObject;
            return (super.equals(otherFerry) &&
                    build_year == otherFerry.build_year &&
                    ship_name.equals(otherFerry.ship_name));
        }
    }
}
