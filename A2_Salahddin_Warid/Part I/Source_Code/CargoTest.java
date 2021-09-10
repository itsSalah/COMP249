/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

import PackageException.PackageNotLoadedTruckFull;
import PackageException.PackageTooHeavyException;
import Packages.*;
import Packages.Package;

import java.util.concurrent.TimeUnit;

/**
 * CargoTest corresponds to a Test Class with its own main.
 * This method is used to make sure all desired functionalities of the Post Canada program run correctly
 * using a realtime simulation of the source code.
 *
 */
public class CargoTest {

    /**
     * Main method for the CargoTest. Runs a simulation of the Post Canada program.
     *
     * @param args
     */
    public static void main(String[] args){

        //Initialize a truck with all the variables to generate packages.
        Truck myTruck2 = new Truck("Salah & Kevin", 100, "Laval",
                "Montreal");
        Package pack_in; String tracking_num; double weight;int i=1,count=1;

        //Loop that will fill the package array of the truck with various packages of different
        //types and weights. The null packages (unrecognized will be skipped).
        do{
            tracking_num = String.valueOf(i);
            i++;
            weight = (i+0.5)/100;
            pack_in = getPackage(tracking_num,weight);
            try{
                if(pack_in!=null) {
                    myTruck2.loadPackage(pack_in);count ++;
                }
            }catch(PackageNotLoadedTruckFull | PackageTooHeavyException e){
                e.printStackTrace();
            }
        }while(count<201);
        //The truck has been loaded with 200 packages, we print its infos (income, weight, count)
        myTruck2.showLoad();
        System.out.println("Number of packages loaded: "+myTruck2.getPackage_count());
        System.out.println("The gross earning is of: "+myTruck2.getGross_income()+"$");
        System.out.println("The gross weight is of: "+myTruck2.getGross_weight()+"lb");

        //We try to add another package when the truck is full, and it catches the error.
        try{
            myTruck2.loadPackage(pack_in);
        }catch(PackageNotLoadedTruckFull e){
            System.out.println("ERROR THE TRUCK IS FULL WE HAVE ENTERED MORE THAN 200 PACKAGES.");
        }catch(PackageTooHeavyException e){
            e.printStackTrace();
        }
        try{TimeUnit.SECONDS.sleep(2);}catch(InterruptedException ignored){}
        //We drive the simulated truck to destination and unload it.
        try {
            myTruck2.drive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
    }


    /**
     * Method returns Package object associated with the tracking number and weight (in pounds).
     * @param tracking_number
     * @param weight
     * @return Package
     */
    public static Package getPackage(String tracking_number, double weight) {
        switch (tracking_number.charAt(tracking_number.length() - 1)) {
            case '0':
                return new Letter(tracking_number, weight);
            case '1':
                return new Box(tracking_number, weight);
            case '2':
                return new WoodenCrate(tracking_number, weight);
            case '3':
                return new MetalCrate(tracking_number, weight);
            default:
                return null;
        }

    }
}

