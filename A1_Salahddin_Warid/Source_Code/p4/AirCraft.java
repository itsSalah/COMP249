/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/

package p4;

import p1.PublicTransportation;

/**
 * AirCraft represents a PublicTransport object
 *
 */
public class AirCraft extends PublicTransportation {

    // The use of private restricted variables protects the Encapsulation principle of OOP.
    // All dependencies are contained inside the class, and values are restricted from the outside,
    // protecting the object attributes from outside the class (can only be mutated from inside).
    private classType class_type;
    private maintenanceType maintenance_type;

    public enum classType {Helicopter, Airline, Glider, Ballon};
    public enum maintenanceType {Weekly, Monthly, Yearly};

    /**
     * Constructs AirCraft object and initializes values to 0
     *
     */
    public AirCraft() {
        this.class_type = null;
        this.maintenance_type = null;
    }

    /**
     * Constructs and initializes AirCraft object
     *
     * @param ticket_price
     * @param number_of_stops
     * @param class_type
     * @param maintenance_type
     */
    public AirCraft(double ticket_price, int number_of_stops, classType class_type,
                    maintenanceType maintenance_type) {
        super(ticket_price, number_of_stops);
        this.class_type = class_type;
        this.maintenance_type = maintenance_type;
    }

    /**
     * Constructs and copies AirCraft object from another object
     *
     * @param obj
     */
    public AirCraft(AirCraft obj) {
        super(obj);
        this.class_type = obj.class_type;
        this.maintenance_type = obj.maintenance_type;
    }

    /**
     * Gives Class type of AirCraft object
     *
     * @return class_type
     */
    public classType getClass_type() {
        return class_type;
    }

    /**
     * Gives Maintenance type of AirCraft object
     *
     * @return maintenance_type
     */
    public maintenanceType getMaintenance_type() {
        return maintenance_type;
    }

    /**
     * Sets CLasstype of AirCraft object
     *
     * @param class_type
     */
    public void setClass_type(classType class_type) {
        this.class_type = class_type;
    }

    /**
     * Sets Maintenance type of AirCraft object
     *
     * @param maintenance_type
     */
    public void setMaintenance_type(maintenanceType maintenance_type) {
        this.maintenance_type = maintenance_type;
    }

    /**
     * Prints AirCraft object attributes
     *
     * @return class_type, maintenance_type
     */
    @Override
    public String toString(){
        return super.toString()+ "\n"+"The aircraft type is "+ class_type
                +" and the maintenance is done "+maintenance_type+".";
    }

    /**
     * Compares if AirCraft object is "equal to" another object
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
            AirCraft otherAirCraft = (AirCraft) otherObject;
            return (class_type == otherAirCraft.class_type &&
                    maintenance_type == otherAirCraft.maintenance_type);
        }
    }
}
