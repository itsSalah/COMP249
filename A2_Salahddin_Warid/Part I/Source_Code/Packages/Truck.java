/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

package Packages;
import PackageException.PackageNotLoadedTruckFull;
import PackageException.PackageTooHeavyException;
import java.util.concurrent.TimeUnit;

import java.util.Arrays;

/**
 * Truck represents a delivery truck transporting Packages.
 *
 */
public class Truck {

    private String driver_name,originating_city, destination_city;
    private double gross_weight,gross_income ,unloaded_weight;
    private Package[] package_carry = new Package[200];
    private int package_count =0;

    /**
     * Constructor initializes and sets attributes of Truck object.
     *
     * @param driver_name
     * @param unloaded_weight
     * @param originating_city
     * @param destination_city
     */
    public Truck(String driver_name, double unloaded_weight , String originating_city, String destination_city) {
        this.driver_name = driver_name;
        this.unloaded_weight = unloaded_weight;
        this.originating_city = originating_city;
        this.destination_city = destination_city;
    }

    /**
     * Method returns Truck object Driver's Name.
     *
     * @return
     */
    public String getDriver_name() {
        return driver_name;
    }


    /**
     * Method returns Truck object Original's City.
     *
     * @return
     */
    public String getOriginating_city() {
        return originating_city;
    }

    /**
     * Method returns Truck object Destination's City.
     *
     * @return
     */
    public String getDestination_city() {
        return destination_city;
    }

    /**
     * Method returns Truck object Number of Packages count.
     *
     * @return
     */
    public int getPackage_count() {
        return package_count;
    }

    /**
     * Method returns Truck object Unloaded weight in pounds.
     *
     * @return
     */
    public double getUnloaded_weight(){
        return this.unloaded_weight;
    }

    /**
     * Method returns Truck object Gross weight in pounds.
     *
     * @return
     */
    public double getGross_weight(){
        double total_weight = unloaded_weight;
        for(int i=0; i<package_carry.length ;i++){
            if(package_carry[i]!=null)
                total_weight += package_carry[i].getWeight();
        }
        return Math.round(total_weight*100.0)/100.0;
    }

    /**
     * Method returns Truck object Gross income.
     *
     * @return
     */
    public double getGross_income(){
        double total_income=0;
        for(int i=0; i<package_carry.length ;i++){
            if(package_carry[i]!=null)
                total_income += package_carry[i].shipping_cost();
        }
        return Math.round(total_income*100.0)/100.0;
    }

    /**
     * Takes an input Package object.
     * Method verifies the weight in pounds of the package and loads it to the truck if the limit weight is respected.
     *
     * @param package_in
     * @throws PackageTooHeavyException
     * @throws PackageNotLoadedTruckFull
     */
    public void loadPackage(Package package_in) throws PackageTooHeavyException, PackageNotLoadedTruckFull {
        //Verify if the package is too heavy
        if (package_in.getPackage_type().equals("Letter") && package_in.getWeight() > 2.0)
            throw new PackageTooHeavyException(package_in + "\nThe weight of the letter is above 2 pounds.");
        else if (package_in.getPackage_type().equals("Box") && package_in.getWeight() > 40.0)
            throw new PackageTooHeavyException(package_in + "\nThe weight of the box is above 40 pounds.");
        else if (package_in.getPackage_type().equals("Wooden Crate") && package_in.getWeight() > 80.0)
            throw new PackageTooHeavyException(package_in + "\nThe weight of the wooden crate is above 80 pounds.");
        else if (package_in.getPackage_type().equals("Metal Crate") && package_in.getWeight() > 100.0)
            throw new PackageTooHeavyException(package_in + "\nThe weight of the metal crate is above 100 pounds.");

            //Verify if the truck has room
        else if (package_count + 1 > 200)
            throw new PackageNotLoadedTruckFull((package_in + "\nNeed to unload package before loading more."));

            //Everything is fine we load it.
        else
        {   package_carry[package_count] = package_in;
            package_count++;
            System.out.println();
            System.out.println("The package following package has been loaded successfully:");
            System.out.println(package_in);
            System.out.println("The shipping cost of this package is of "+
                    Math.round(package_in.shipping_cost()*100.0)/100.0+ "$");
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException ignored) {}
        }
    }

    /**
     * Takes as input the Tracking number of a package (integer).
     * Method selects a specific package loaded to Truck object and removes/unloads it.
     *
     * @param x
     */
    public void unloadPackage(int x) {

        System.out.println();
        System.out.println(package_carry[x-1]+" Shipping cost: "+
                Math.round(package_carry[x-1].shipping_cost()*100.0)/100.0+"$"
                + "\nHas been successfully unloaded from the truck.");
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException ignored) {}
        package_carry[x-1] = null;
        //We got to reorder the array
        if (x != package_count) {
            for (int i = x-1; i < package_carry.length-1; i++) {
                package_carry[i] = package_carry[i+1];
            }
            //The array is reduced by one the last element is always null
            package_carry[package_carry.length-1] = null;
        }
        package_count--;
    }

    /**
     * Method unloads all packages of Truck object.
     *
     */
    public void unloadTruck(){
        Arrays.fill(package_carry, null);
        package_count = 0;
        System.out.println("The truck has been completely unloaded.");
    }

    /**
     * Method shows all position, weight in pounds and price of all Packages loaded to Truck object.
     * Method also check if the Truck object is empty.
     *
     */
    public void showLoad() {
        if (package_count == 0) {
            System.out.println("The truck contains no package.");
        } else {
            for (int i = 0; i < package_count; i++){
                System.out.println("Position "+(i+1)+"  "+package_carry[i]+" Shipping cost: "
                        +Math.round(package_carry[i].shipping_cost()*100.0)/100.0+"$");
            }
        }
    }

    /**
     * Method checks if Truck object is empty or loaded. If loaded, method drives Truck object to the Destination City
     * and unloads it.
     *
     * @throws InterruptedException
     */
    public void drive() throws InterruptedException {
        System.out.println("Driving the truck to destination...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("The truck arrived from "+originating_city+" and got to "+destination_city+".");
        if(this.getPackage_count()>=1)  {
            System.out.println("The truck is currently unloading...");
            TimeUnit.SECONDS.sleep(2);
            this.unloadTruck();}
        else System.out.println("The truck has no package to unload.");
    }

    /**
     * Takes weight in pounds.
     * Method converts weight to kilograms.
     *
     * @param pounds
     * @return
     */
    public static double toKilograms(double pounds){return pounds/2.20462262185;}

    /**
     * Takes weight in kilograms.
     * Method converts weight to pounds.
     *
     * @param kilograms
     * @return
     */
    public static double toPounds(double kilograms){
        return kilograms*2.20462262185;
    }

    /**
     * Method displays Truck object attributes.
     *
     * @return Driver Name, Weight (in pounds and kilograms), Originating City, Destination City
     */
    public String toString(){
        return "Driver name: "+getDriver_name()+"  Unloaded weight: "+Math.round(getUnloaded_weight()*100.0)/100.0+
                " lb; " + Math.round(toKilograms(getUnloaded_weight())*100.0)/100.0+" kg"
                + "  Originating city: "+getOriginating_city() + "  Destination city: "+getDestination_city();
    }
}
