/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

/**
 * Warship represents a form of naval ship.
 *
 */
public class Warship {
    protected long serialNumber;
    protected String name;
    protected int creationYear;
    protected String ownerCountry;
    protected double price;
    protected int speed;

    /**
     * Default Constructor of object Warship an initializes values to 0/null.
     *
     */
    public Warship() {
        this.serialNumber = 0;
        this.name = "";
        this.creationYear = 0;
        this.ownerCountry = "";
        this.price = 0;
        this.speed = 0;
    }

    /**
     * Constructor initializes and sets attributes of Warship object.
     *
     * @param serialNumber
     * @param name
     * @param creationYear
     * @param ownerCountry
     * @param price
     * @param speed
     */
    public Warship(long serialNumber, String name, int creationYear, String ownerCountry, double price, int speed) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.creationYear = creationYear;
        this.ownerCountry = ownerCountry;
        this.price = price;
        this.speed = speed;
    }

    /**
     * Prints Warship object attributes.
     *
     * @return
     */
    @Override
    public String toString() {
        return serialNumber + " " + name + " " + creationYear + " " + ownerCountry + " " + price + " " + speed + "\n";
    }
}
