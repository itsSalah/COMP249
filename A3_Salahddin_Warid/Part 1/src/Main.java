/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #3
Due Date: 22 August 2021
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * Main method used to run the program.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Creating all variables, Scanners, PrintWritters and ArrayLists used to run the program.
        String inputFileName = "PersonOfTheCentury.txt";
        String outputFileName = "SubDictionary.txt";
        Scanner keyIn = null;
        PrintWriter writer = null;
        ArrayList<String> subDictionary = new ArrayList<String>();

        System.out.println("Welcome to the sub-dictionary generating program.");
        pause();

        // Initializing Scanner to the input file.
        try {
            System.out.println("Program is trying to read the entry file...");
            keyIn = new Scanner(new FileInputStream(inputFileName));
            pause();
        } catch (FileNotFoundException e) {
            pause();
            System.out.println("Error: File not found.");
            System.exit(0);
        }

        // Creating the Array List storing the words in the sub-dictionary.
        Word.createArrayList(subDictionary, keyIn);
        subDictionary.sort(null);

        // Initializing PrintWriter and printing the sub-dictionary in the output file.
        try {
            System.out.println("Program is trying to write the sub-dictionary on the output file...");
            writer = new PrintWriter(new FileOutputStream(outputFileName));
            Word.printArrayList(subDictionary, writer);
            pause();
        } catch (FileNotFoundException e) {
            pause();
            System.out.println("Error: File not found.");
            System.exit(0);
        }

        // CLosing IO variables.
        System.out.println("The program ran successfully.");
        keyIn.close();
        writer.close();
    }

    /**
     * Pause method to add a delay un runtime.
     *
     */
    public static void pause() {
        try { TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignored) {}
    }

}
