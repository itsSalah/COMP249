/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #3
Due Date: 22 August 2021
*/

/**
 * CellPhone represents a class of CellPhone objects.
 *
 */
public class CellPhone {

    // Creating attributes of CellPhone Object.
    private long serialNum;
    private String brand;
    private int year;
    private double price;

    /**
     * Parametrized constructor for CellPhone objects.
     *
     * @param serialNum
     * @param brand
     * @param year
     * @param price
     */
    public CellPhone(long serialNum, String brand, int year, double price) {
        // Verifies all attributes of CellPhone are allowed.
        if (serialNum<=0)
            throw new IllegalArgumentException("Incorrect serial number.");
        else if (brand == null)
            throw new IllegalArgumentException("Empty brand name.");
        else if (year < 1973)
            throw new IllegalArgumentException("Incorrect year. The first cellphone was created in 1973.");
        else if (price <= 0)
            throw new IllegalArgumentException("Incorrect price. Price has to be positive.");
        else{
            this.serialNum = serialNum;
            this.brand = brand;
            this.year = year;
            this.price = price;
        }
    }

    /**
     * Copy constructor for CellPhone object from another existing Cellphone object.
     * Every attribute is copied except for the serial number.
     *
     * @param otherCellPhone CellPhone object to copy.
     * @param serialNum Unique serial number for the clone phone.
     */
    public CellPhone(CellPhone otherCellPhone, long serialNum){
        if (otherCellPhone == null)
            throw new IllegalArgumentException("Empty object was passed in.");
        else if (serialNum<=0)
            throw new IllegalArgumentException("Incorrect serial number.");
        else{
            this.serialNum = serialNum;
            this.brand = otherCellPhone.brand;
            this.year = otherCellPhone.year;
            this.price = otherCellPhone.price;
        }
    }

    /**
     * Function clones an existing CellPhone object to a new Cellphone object.
     * Cloned object takes a ne and unique serial number.
     *
     * @param serialNum Unique serial number to the cloned CellPhone.
     * @return
     */
    public CellPhone clone(long serialNum){
        return new CellPhone(this,serialNum);
    }

    /**
     * Function displays CellPhone object attributes.
     *
     * @return
     */
    @Override
    public String toString(){
        return "["+serialNum+": "+brand+" "+price+"$ "+year+"]";
    }

    /**
     * Function compares CellPhone object to another object to verify if attributes are equal.
     * Serial number is not verified as this attribute is unique to every CellPhone object.
     *
     * @param otherObject Object to be compared to.
     * @return
     */
    @Override
    public boolean equals(Object otherObject){
        if (otherObject == null) return false;
        else if (getClass() != otherObject.getClass()) return false;
        else{
            CellPhone otherCellPhone = (CellPhone) otherObject;
            return (brand.equalsIgnoreCase(otherCellPhone.brand) &&
                    (Math.abs(price - otherCellPhone.price)<0.001) && year== otherCellPhone.year);

        }
    }

    /**
     * Function sets/mutates the Serial number attribute of Cellphone object.
     *
     * @param serialNum
     */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * Function sets/mutates the Brand attribute of Cellphone object.
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Function sets/mutates the Year attribute of Cellphone object.
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Function sets/mutates the Price attribute of Cellphone object.
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Function returns the Serial number attribute of Cellphone object.
     *
     * @return
     */
    public long getSerialNum() {
        return serialNum;
    }

    /**
     * Function returns the Brand attribute of Cellphone object.
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Function returns the Year attribute of Cellphone object.
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * Function returns the Price attribute of Cellphone object.
     *
     * @return
     */
    public double getPrice() {
        return price;
    }
}
