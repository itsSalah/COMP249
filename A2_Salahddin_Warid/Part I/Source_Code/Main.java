/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

import PackageException.PackageNotLoadedTruckFull;
import PackageException.PackageOfWrongTypeException;
import PackageException.PackageTooHeavyException;
import Packages.*;
import Packages.Package;
import Packages.Truck;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * Main method. Runs the Post Canada program.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Initializing System input Scanner and Truck object. As well as other variables.
        Scanner keyIn = new Scanner(System.in);
        String option="",driver_name="",unload_weight="",originating_city="",destination_city="";
        String tracking_number="",package_weight="",position="";
        double unload_weight_db = 0, package_weight_db = 0;
        Truck myTruck = null;

        // Setting trigger for program options.
        boolean done;

        // Selecting menu option.
        do {
            System.out.println();
            done=false;
            show_menu();

            do {

                // Checks for error signal in the format of number entry.
                try {
                    option = keyIn.nextLine();
                    if (Integer.parseInt(option) >= 0 && Integer.parseInt(option) <= 7) {
                        done = true;
                        System.out.println();
                    } else {
                        System.out.println("\nPlease enter a valid option" + "\n");
                        pause();
                        show_menu();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nPlease enter a valid option.");
                    System.out.println();
                    pause();
                    show_menu();
                }
            }while(!done);

            // Program controller for "Start a Cargo" option.
            if (Integer.parseInt(option) == 1) {

                // Setting cargo (Truck object) attributes.
                System.out.print("a. Driver name: ");
                driver_name = keyIn.nextLine();
                done = false;
                do {
                    System.out.print("b. Unload weight (enter the number followed by kg or lb): ");
                    // Checks for error signal in the format of number entry
                    try {
                        unload_weight = keyIn.nextLine();
                        unload_weight_db = Double.parseDouble(unload_weight.substring(0, unload_weight.length() - 2));
                        String truck_units = unload_weight.substring(unload_weight.length() - 2);
                        // Checks for negative weight error
                        if (unload_weight_db<0) {System.out.println("Please enter a proper weight.");pause();}
                        // Filters what type of weight (metric/imperial) was input to program
                        //The weight are all converted and manipulated in pounds.
                        else if (truck_units.equalsIgnoreCase("kg")) {
                            unload_weight_db = Truck.toPounds(unload_weight_db);
                            done = true;
                        } else if (truck_units.equalsIgnoreCase("lb")) {
                            done = true;
                        } else{ // Checks for weight units compatible with the program
                            System.out.println("Please enter a proper unit.");
                            pause();
                        }

                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        System.out.println("Please enter a proper value.");
                        pause();
                    }
                } while (!done);

                System.out.print("c. Originating city: ");
                originating_city = keyIn.nextLine();
                System.out.print("d. Destination city: ");
                destination_city = keyIn.nextLine();
                //Initialize the truck with the parameters provided by the user and print its infos.
                myTruck = new Truck(driver_name, unload_weight_db, originating_city, destination_city);
                System.out.println();
                System.out.println(myTruck);
                System.out.println("Cargo loaded in successfully.");
                pause();
            }

            // Program controller for "Load the truck with packages" option.
            else if (Integer.parseInt(option) == 2) {

                if (myTruck != null) {
                    done = false;
                    //Prompting for package parameters.
                    do {
                        System.out.print("a. Package tracking number: ");
                        // Checks for error signal in the format of number entry
                        try {
                            tracking_number = keyIn.nextLine();
                            // Checks for correct numerical entry
                            if(Integer.parseInt(tracking_number)>0) {done = true;
                            }
                            else {System.out.println("Please enter a valid tracking number.");
                            }
                            pause();

                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid tracking number.");
                            pause();
                        }
                    } while (!done);

                    done = false;
                    do {
                        System.out.print("b. Package weight (enter the number followed by oz or lb):");
                        // Checks for error signal in the format of number entry
                        try {
                            package_weight = keyIn.nextLine();
                            package_weight_db = Double.parseDouble(package_weight.substring(0,
                                    package_weight.length() - 2));
                            String package_units = package_weight.substring(package_weight.length() - 2);
                            // Filters what type of weight (pound or ounce) was input to program
                            //The weight are all converted and manipulated in pounds.
                            if (package_weight_db<0){
                                System.out.println("Please enter a proper value.");
                                pause();
                            } else if (package_units.equalsIgnoreCase("oz")) {
                                package_weight_db = Package.toPounds(package_weight_db);
                                done = true;
                            } else if (package_units.equalsIgnoreCase("lb")) {
                                done = true;
                            } else{
                                System.out.println("Please enter a proper unit.");
                                pause();
                            }

                        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                            System.out.println("Please enter a numerical value.");
                            pause();
                        }
                    } while (!done);

                    // Checks for Package related errors when trying to load it in the truck.
                    try {
                        // Checks the Packages weight is permitted w.r.t. the package type it belongs to.
                        // Then we try to load it if its type is appropriate for loading. Else we throw a
                        // package type error. If it's type is appropriate we look for its weight.
                        // If it's too heavy for its respective type, we throw an error. If the truck
                        // is full, and we try to load another package, we throw an error. For all these errors,
                        // the error is caught and the user is sent back to the main menu.
                        if (tracking_number.charAt(tracking_number.length() - 1) == '0') {
                            Letter myPackage = new Letter(tracking_number, package_weight_db);
                            assert false;
                            myTruck.loadPackage(myPackage);
                        } else if (tracking_number.charAt(tracking_number.length() - 1) == '1') {
                            Box myPackage = new Box(tracking_number, package_weight_db);
                            assert false;
                            myTruck.loadPackage(myPackage);
                        } else if (tracking_number.charAt(tracking_number.length() - 1) == '2') {
                            WoodenCrate myPackage = new WoodenCrate(tracking_number, package_weight_db);
                            assert false;
                            myTruck.loadPackage(myPackage);
                        } else if (tracking_number.charAt(tracking_number.length() - 1) == '3') {
                            MetalCrate myPackage = new MetalCrate(tracking_number, package_weight_db);
                            assert false;
                            myTruck.loadPackage(myPackage);
                        } else throw new PackageOfWrongTypeException("Package type: Unknown " +
                                "Tracking number: " + tracking_number + " Weight: " + package_weight +
                                "\nVerify the tracking" + " number provided.");

                    } catch (PackageOfWrongTypeException | PackageTooHeavyException | PackageNotLoadedTruckFull e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        pause();
                    }

                } else{  //If the truck wasn't initiated, we will simply output this message.                                                                                                   // Checks if package is entered without having a cargo truck
                    System.out.println("Please start a cargo before loading packages.");
                    pause();
                }
            }

            // Program controller for "Unload a package" option.
            else if (Integer.parseInt(option) == 3){
                // Checks the cargo truck is loaded (not empty) and if it was initiated.
                if(myTruck == null || myTruck.getPackage_count()==0){
                    System.out.println("Make sure you have a cargo loaded with packages before selecting this option.");
                    pause();
                }
                else{
                    myTruck.showLoad();
                    done = false;
                    do {
                        // Checks for error signal in the format of number entry
                        try {
                            // Selection of which package to unload
                            System.out.print("Select the position of the package you would like to unload: ");
                            position = keyIn.nextLine();
                            if(Integer.parseInt(position)>=1 && Integer.parseInt(position)<= myTruck.getPackage_count()){
                                done = true;
                            }
                            else{
                                System.out.println("Please enter a valid position");
                                pause();}
                        }catch(NumberFormatException e){
                            System.out.println("Please enter a valid position.");
                            pause();
                        }
                    }while(!done);
                    //Unload the package selected from the truck
                    myTruck.unloadPackage(Integer.parseInt(position));
                }
            }

            // Program controller for "The number of packages loaded" option.
            else if (Integer.parseInt(option) == 4){
                if(myTruck == null){ // Checks if truck is not initiated
                    System.out.println("There are no truck loaded.");
                    pause();}
                else if (myTruck.getPackage_count() ==0) {
                    myTruck.showLoad(); //Will say the truck is empty.
                    pause();
                }
                else {
                    myTruck.showLoad(); //Prints all the packages with their infos
                    System.out.println("The truck contains a total of "+myTruck.getPackage_count()+ " packages.");
                    pause();}
            }

            // Program controller for "The gross income earned by shipping the cargo" option.
            else if (Integer.parseInt(option) == 5) {
                if (myTruck == null){System.out.println("There are no truck loaded."); pause();}
                else if (myTruck.getPackage_count() == 0) {System.out.println("There are no package loaded.");pause();}
                else
                {System.out.println("The gross income of the cargo is of " + myTruck.getGross_income() + "$");pause();}
            }

            // Program controller for "Weight the truck(after it has been completely loaded)" option.
            else if (Integer.parseInt(option)== 6){
                if (myTruck == null) {System.out.println("There are no truck loaded.");pause();}
                else if (myTruck.getPackage_count() != 200){
                    System.out.println("The truck isn't fully loaded.");
                    System.out.println((200- myTruck.getPackage_count())+" packages are still needed.");
                    pause();
                }
                else {
                    System.out.println("The weight of the truck completely loaded is of "+
                            Math.round(Truck.toKilograms(myTruck.getGross_weight())*100.0)/100.0+" kg; "
                            +Math.round(myTruck.getGross_weight()*100.0)/100.0+" lb.");
                    pause();}
            }

            // Program controller for "Drive the truck to destination" option.
            else if (Integer.parseInt(option)==7){
                if (myTruck == null) {System.out.println("There are no truck loaded.");pause();}
                else try{myTruck.drive();}catch(InterruptedException ignored){}
            }
        }while(Integer.parseInt(option) != 0);
        //Leave loop only if option 0 is selected and close the scanner, then the end the program.
        keyIn.close();
        pause();
        System.out.println("The program has been closed safely.");
    }

    /**
     * Method displays the selection menu of Post Canada program.
     *
     */
    public static void show_menu(){

        System.out.println("What would you like to do?");
        System.out.println("   1.  Start a cargo");
        System.out.println("           a.  Driver name");
        System.out.println("           b.  Unload weight(kg; lb)");
        System.out.println("           c.  Originating city");
        System.out.println("           d.  Destination city");
        System.out.println("   2.  Load the truck with packages");
        System.out.println("           a.  Package tracking number");
        System.out.println("           b.  Package weight(oz; lb)");
        System.out.println("           c.  Package shipping cost");
        System.out.println("   3.  Unload a package");
        System.out.println("   4.  The number of packages loaded");
        System.out.println("   5.  The gross income earned by shipping the cargo");
        System.out.println("   6.  Weight the truck(after it has been completely loaded)");
        System.out.println("   7.  Drive the truck to destination");
        System.out.println("   0.  To quit");
        System.out.print("Please enter your choice and press <Enter>: ");
    }

    /**
     * Method pauses/gives delay to the output screen.
     *
     */
    public static void pause(){
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException ignored) {}
    }

}

