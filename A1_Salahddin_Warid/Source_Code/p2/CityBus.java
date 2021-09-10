/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/

package p2;

import p1.PublicTransportation;

/**
 * CityBus represents a PublicTransport object of the form of a city wagon
 *
 */
public class CityBus extends PublicTransportation {

    // The use of protected access right attributes allows the Metro and Tram subclasses in the same package to access
    // attributes to set the new subclass objects.
    protected long route_number;
    protected int begin_operation_year;
    protected String line_name;
    protected String drivers_name;

    /**
     * Constructs a CityBus object and initializes values to 0
     *
     */
    public CityBus(){
        this.route_number = 0L;
        this.begin_operation_year = 0;
        this.line_name = null;
        this.drivers_name = null;
    }

    /**
     * Constructs and initializes a CityBus object
     *
     * @param ticket_price
     * @param number_of_stops
     * @param route_number
     * @param begin_operation_year
     * @param line_name
     * @param drivers_name
     */
    public CityBus(double ticket_price, int number_of_stops,long route_number, int begin_operation_year,
                   String line_name, String drivers_name)
    {
        super(ticket_price,number_of_stops);
        this.route_number = route_number;
        this.begin_operation_year = begin_operation_year;
        this.line_name = line_name;
        this.drivers_name = drivers_name;
    }

    /**
     * Constructs and copies CityBus object from another object
     *
     * @param obj
     */
    public CityBus(CityBus obj)
    {
        super(obj);
        this.route_number = obj.route_number;
        this.begin_operation_year = obj.begin_operation_year;
        this.line_name = obj.line_name;
        this.drivers_name = obj.drivers_name;
    }

    /**
     * Gives the Route number of CityBus object
     *
     * @return route_number
     */
    public long getRoute_number() {
        return route_number;
    }

    /**
     * Gives the Begin operation year of CityBus object
     *
     * @return begin_operation_year
     */
    public int getBegin_operation_year() {
        return begin_operation_year;
    }

    /**
     * Gives the Line name of CityBus object
     *
     * @return line_name
     */
    public String getLine_name() {
        return line_name;
    }

    /**
     * Gives Driver's name of CityBus object
     *
     * @return drivers_name
     */
    public String getDrivers_name() {
        return drivers_name;
    }

    /**
     * Sets Route number of CItyBus object
     *
     * @param route_number
     */
    public void setRoute_number(long route_number) {
        this.route_number = route_number;
    }

    /**
     * Sets Begin operation year of CityBus object
     *
     * @param begin_operation_year
     */
    public void setBegin_operation_year(int begin_operation_year) {
        this.begin_operation_year = begin_operation_year;
    }

    /**
     * Sets Line name of CityBus object
     *
     * @param line_name
     */
    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }

    /**
     * Sets Driver's name of CityBus object
     *
     * @param drivers_name
     */
    public void setDrivers_name(String drivers_name) {
        this.drivers_name = drivers_name;
    }

    /**
     * Prints CityBus object attributes
     *
     * @return route_number, begin_operation_year, line_name, drivers_name
     */
    @Override
    public String toString(){
        return super.toString()+"\n"+"The city bus has a route number of "
                + route_number + ". It began its operation in " + begin_operation_year
                + ". The line name is " + line_name + " and the driver(s) is/are "
                + drivers_name + ".";
    }

    /**
     * Compares if CityBus object is "equal to" another object
     * ( Checks compatibility of Class Types and null objects to avoid program from failing when comparing non-compatible attributes.
     * This avoids from searching non-existent attributes and prevents system crashes.)
     *
     * @param otherObject
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
            CityBus otherCityBus = (CityBus) otherObject;
            return (super.equals(otherCityBus) &&
                    route_number == otherCityBus.route_number &&
                    begin_operation_year == otherCityBus.begin_operation_year &&
                    line_name.equals(otherCityBus.line_name) &&
                    drivers_name.equals(otherCityBus.drivers_name));
        }
    }
}
