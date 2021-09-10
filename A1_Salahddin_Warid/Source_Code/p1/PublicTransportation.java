/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/



package p1;

/**
 * PublicTransportation represents a form of public transportation
 *
 */
public class PublicTransportation {

    // The use of private restricted variables protects the Encapsulation principle of OOP.
    // All dependencies are contained inside the class, and values are restricted from the outside,
    // protecting the object attributes from outside the class (can only be mutated from inside).
    private double ticket_price;
    private int number_of_stops;

    /**
     * Constructs a PublicTransportation object and initializes values to 0
     *
     */
    public PublicTransportation(){
        this(0.0,0);
    }

    /**
     * Constructs and initializes a PublicTransportation object
     *
     * @param ticket_price - Ticket price
     * @param number_of_stops - Number of stops
     */
    public PublicTransportation(double ticket_price, int number_of_stops) {
        this.ticket_price = ticket_price;
        this.number_of_stops = number_of_stops;
    }

    /**
     * Constructs and copies PublicTransportation object from another object
     *
     * @param obj - Copy object
     */
    public PublicTransportation(PublicTransportation obj){
        this.ticket_price = obj.ticket_price;
        this.number_of_stops = obj.number_of_stops;
    }

    /**
     * Gives the Ticket price of a PublicTransportation object
     *
     * @return ticket_price - Ticket price
     */
    public double getTicket_price() {
        return ticket_price;
    }

    /**
     * Gives the Number of stops of a PublicTransportation object
     *
     * @return number_of_stops
     */
    public int getNumber_of_stops() {
        return number_of_stops;
    }

    /**
     * Sets the Ticket price of a PublicTransportation object
     *
     * @param ticket_price - Ticket price
     */
    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    /**
     * Sets the Number of stops of a PublicTransportation object
     *
     * @param number_of_stops - Number of stops
     */
    public void setNumber_of_stops(int number_of_stops) {
        this.number_of_stops = number_of_stops;
    }


    // Annotation to show the override from built-in String toString(). Not necessary

    /**
     * Prints PublicTransportation object attributes
     *
     * @return ticket_price, number_of_stops
     */

    /**
     * Prints PublicTransportation object attributes
     *
     * @param - Print object
     * @return ticket_price, number_of_stops
     */
    @Override
    public String toString(){
        return "The public transportation has a ticket price of "+
                ticket_price + "$ and " + number_of_stops +
                " number of stops.";
    }

    /**
     * Compares if PublicTransportation object is "equal to" another object
     * ( Checks compatibility of Class Types and null objects to avoid program from failing when comparing non-compatible attributes.
     * This avoids from searching non-existent attributes and prevents system crashes.)
     *
     * @param otherObject - Comparative object
     * @return - Boolean
     */
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else
        {
            PublicTransportation otherPublicTransport = (PublicTransportation) otherObject;
            return (ticket_price == otherPublicTransport.ticket_price &&
                    number_of_stops == otherPublicTransport.number_of_stops);
        }
    }

}


