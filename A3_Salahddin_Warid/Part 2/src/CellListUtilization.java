/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #3
Due Date: 22 August 2021
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CellListUtilization {

    /**
     * Main class running the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Creating/Initializing all variables
        String[] input_array; CellList myLinkedList = new CellList();long serialNum,input; String brand;
        int year,count=0; double price; ArrayList<Long> serialNum_array = new ArrayList<Long>(); boolean done=false;

        System.out.println("Welcome to the program of Salahddin Warid and Kevin Estrada Dominguez !");
        System.out.println();
        // Check for error signal in the form of FilesNotFound
        try {
            // Initializing scanner and verifying the existence of data inside the .txt file.
            Scanner in = new Scanner(new FileReader("Cell_Info.txt"));
            while(in.hasNextLine()){
                input_array = in.nextLine().split("\\s+");
                serialNum = Long.parseLong(input_array[0]);

                // Verifying for unique serial numbers (no duplicates).
                if(!serialNum_array.contains(serialNum)) {
                    brand = input_array[1];
                    price = Double.parseDouble(input_array[2]);
                    year = Integer.parseInt(input_array[3]);
                    myLinkedList.addToStart(new CellPhone(serialNum, brand, year, price));
                    serialNum_array.add(serialNum);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {System.err.println("Cannot find the text file.");}

        System.out.println("The current size of the list is "+myLinkedList.getSize()+". Here are the contents" +
                " of the list");
        System.out.println("=====================================================================");
        myLinkedList.showContents();
        System.out.println();
        System.out.println();
        Scanner keyIn = new Scanner(System.in);
        // Verifies if Serial number input is in the CellList.
        do {
            // Check for error signal in the form of NumberFormat errors.
            try {
                System.out.print("Enter a serial number to verify if it is on the list: ");
                input = Long.parseLong(keyIn.nextLine());
                // If-else statements to verify the input Serial number for special cases.
                if(input<=0) System.out.println("Please enter a valid serial number.");
                else{
                    myLinkedList.contains(input);
                    if (++count == 3) done = true;
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid serial number.");
            }
            System.out.println();
        }while(!done);
    keyIn.close();
        System.out.println("End of the CellListUtilization class.");
    }
}
