/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #2
Due Date: 4 August 2021
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;

/**
 * WarshipInventory1 represents a form of inventory for objects of class Warship.
 *
 */
public class WarshipInventory1 extends Warship {
    static Warship[] wsArr;
    static int numberOfWarships;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Main method prompts the user to enter the name of the output file
     * that will be created to hold the modified/correct inventory.
     *
     * @param arg
     */
    public static void main(String[] arg) {
        String outFileName;
        String inFileName = "Initial_Cargoship_Info.txt";
        System.out.print("Please enter the name of output file, which will have correct information: ");

        // Prompts user for output file name.
        while (true) {
            outFileName = scanner.next();
            File file = new File(outFileName);
            // Exception handling if the output name already exists.
            if (file.exists()) {
                System.out.println("Error: There is an existing file called " + outFileName);
                System.out.println("That file already has a size of " + file.length() + " bytes.");
            } else {
                break;
            }
            System.out.print("\nPlease enter another file name to create: ");
        }

        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        // Exception handling if files cannot be found.
        try {
            fileIn = new FileInputStream(new File(inFileName));
            fileOut = new FileOutputStream(new File(outFileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Gets the number of ships at runtime to set the right size array.
        numberOfWarships = getNumberOfWarships(inFileName);
        wsArr = new Warship[numberOfWarships];
        System.out.println("\nThe file has " + numberOfWarships + " records.");

        // Fix inventory serial numbers if more than 1 ships.
        if(numberOfWarships > 1) {
            fixInventory(fileIn, fileOut);
        }

        // Exception handling if files cannot be found.
        try {
            System.out.println("\nHere are the contents of file " + inFileName + " AFTER copying operation:");
            System.out.println("====================================================================");
            displayFileContents(new FileInputStream(new File(inFileName)));
            System.out.println();
            System.out.println("\nHere are the contents of file " + outFileName + ":");
            System.out.println("====================================================================");
            displayFileContents(new FileInputStream(new File(outFileName)));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    /**
     * Takes a File entry and scans every line inside the file.
     * This method adds a count for every existing line and returns the total numbers of
     * lines. The number corresponds to the size of the inventory.
     *
     * @param fileName
     * @return
     */
    private static int getNumberOfWarships(String fileName) {
        FileInputStream fileIn = null;
        int count = 0;

        // Exception handling if files cannot be found.
        try {
            fileIn = new FileInputStream(new File(fileName));
            Scanner scanner = new Scanner(fileIn);
            // Adds a counts if the inventory continues.
            while (scanner.hasNextLine()) {
                count++;
                scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return count;
    }

    /**
     * Takes an input and an output Stream Files.
     * This method creates a temporary copy inventory array and and compares serial numbers for the input file. If
     * ships appear as duplicate, a serial number prompt is asked to replace the erroneous serial number.
     *
     * @param fileIn
     * @param fileOut
     */
    private static void fixInventory(FileInputStream fileIn, FileOutputStream fileOut) {
        int i = 0;
        // Exception handling when converting IO inputs to numeric values for Warship attributes.
        try {
            // Exception handling if IO stream error occurs.
            try (Scanner scanner = new Scanner(fileIn)) {
                // Separates elements in the line separated by " " to respective Warship attributes.
                while (scanner.hasNextLine()) {
                    String[] record = scanner.nextLine().split(" ");
                    Warship ship = new Warship(Integer.parseInt(record[0]), record[1], Integer.parseInt(record[2]), record[3],
                            Double.parseDouble(record[4]), Integer.parseInt(record[5]));
                    wsArr[i] = ship;
                    i++;
                }
                scanner.close();
                fileIn.close();
            } catch (IOException e) {
                System.out.println("IO operation failed.");
            }
        } catch (NumberFormatException e1) {
            System.out.println("Invalid input.");
        }

        int flag = 0;
        String serial;
        long serial_long;
        Warship[] copy = new Warship[numberOfWarships];

        for (i = 0; i < numberOfWarships; i++) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                // Triggers flag if there is a duplicate
                if (wsArr[i].serialNumber == copy[j].serialNumber) {
                    flag = 1;
                    break;
                }
            }

            // Solving duplicate serial issue
            if (flag == 1) {
                try {
                    throw new DuplicateSerialNumberException("Duplicate serial number " + wsArr[i].serialNumber + " detected in record # " + (i+1));
                } catch (DuplicateSerialNumberException ex) {
                    System.out.print(ex + ". Please enter the correct serial number: ");
                }

                boolean done = false;
                int temp = 0;
                do {
                    try {
                        serial = scanner.nextLine();
                        serial_long = Long.parseLong(serial.substring(0));

                        // Verifies entry is not a duplicate
                        for (int j = 0; j < i; j++) {
                            if (serial_long == copy[j].serialNumber) {
                                System.out.println("Attempt of duplicate entry to a previous record.");
                                System.out.println("Initial appearance of serial number " + serial_long + " was found at record " + (j + 1) + ".");
                                System.out.println("Error.... Duplicate Entry of Serial Number. The entered serial number exists for another record.");
                            }
                        }

                        // Changes the duplicate serial number
                        if (serial_long > 0) {
                            wsArr[i].serialNumber = serial_long;
                            i--;
                            done = true;
                        // Does no allow serial numbers negative and 0
                        } else {
                            System.out.print("Please enter a valid serial number: ");
                        }
                    } catch (NumberFormatException ex1) {
                        if (temp == 0) { temp = 1; }
                    }
                } while (!done);
                continue;
            }
            copy[i] = wsArr[i];
        }

        // Writes the corrected inventory to the output file.
        OutputStreamWriter osw = new OutputStreamWriter(fileOut);
        // Exception handling if IO stream error occurs.
        try {
            for (i = 0; i < numberOfWarships; i++) {
                osw.write(wsArr[i].toString());
            }
            osw.close();
        } catch (IOException e) {
            System.out.println("IO operation failed.");
        }
    }

    /**
     * Takes an input file stream name,
     * This method displays the contents of this file to the standard output (the screen).
     *
     * @param fileIn
     */
    private static void displayFileContents(FileInputStream fileIn) {
        Scanner scanner = new Scanner(fileIn);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void pause() {try { TimeUnit.SECONDS.sleep(100);} catch (InterruptedException ignored) {}}

}