/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #3
Due Date: 22 August 2021
*/

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CLass used to Clean words and create/write the output file.
 *
 */
public class Word {

    /**
     * Takes a word and cleans it from any undesired symbol/number.
     *
     * @param word String representing a word to be cleaned for symbols and numbers.
     * @return String in capital letters. An exception for MC2 is made, in which the symbol is allowed.
     */
    public static String cleanWord(String word) {
        // Initializing word cleaned.
        String wordCLeaned = "";

        // Verifies for numbers being part of the word.
        if (checksForNumbers(word)) {return null;}

        // Verified for characters/symbols being part of the word.
        for (int i = 0; i<word.length(); i++) {
            if (!checkForChars(word.charAt(i))) {wordCLeaned += word.charAt(i);}
            else {break;}
        }

        // Verifies for words of 0 length.
        if (wordCLeaned.length() == 0) {return null;}

        // Verifies for words of length 1 being either A or I.
        else if (wordCLeaned.length() == 1) {
            char checkChar = wordCLeaned.charAt(0);
            boolean charIsA = checkChar == 'a' || checkChar == 'A';
            boolean charIsI = checkChar == 'i' || checkChar == 'I';

            if (!charIsA && !charIsI) {
                return null;
            }
        }

        // Verifies for the MC2 symbol exception allowed to the sub-dictionary.
        else if (wordCLeaned.equalsIgnoreCase("MC")) {
            char sqrt = 178;
            return "MC" + sqrt;
        }

        // Returns the cleaned world in capital letters.
        return wordCLeaned.toUpperCase();
    }

    /**
     * Verifies for characters inside the word checked character by character.
     *
     * @param chr Char representing every character of a word to clean.
     * @return Boolean value representing if there is a character or not.
     */
    public static boolean checkForChars(char chr) {
        // Checks for symbols in the ASCII table that are neither letters or a hyphen for compound words.
        boolean boundsLowerCase = chr >= 'a' && chr <= 'z';
        boolean boundsUpperCase = chr >= 'A' && chr <= 'Z';
        boolean isHyphen = chr == '-';

        return !(boundsLowerCase || boundsUpperCase || isHyphen);
    }

    /**
     * Verifies for numbers inside the word to clean. This function allows the MC2 exception having a number.
     *
     * @param word
     * @return Boolean value representing if there is a number or not.
     */
    public static boolean checksForNumbers(String word) {
        // Allows the MC2 to trigger a false return value to allow this exception having a number.
        boolean checkMC = word.contains("MC") && word.length()<=3;
        if (checkMC) {return false;}

        // Return value triggered to true if there is a number.
        else if (hasNumbers(word)) {return true;}

        // Return value is negative when no numbers are found.
        else {return false;}
    }

    /**
     * Verifies for numbers inside the word to clean.
     *
     * @param word
     * @return Boolean value representing if there is a number or not.
     */
    public static boolean hasNumbers(String word) {
        String[] numbers = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // Verifies if the word contains numbers from the numbers array.
        for (String digit: numbers) {
            if (word.contains(digit)) {return true;}
        }
        return false;
    }

    /**
     * Create the Array List of Type String.
     * Stores words from the input file.
     *
     * @param arrayList Array List of Type String. Used to store the words in the sub-dictionary.
     * @param keyIn Scanner reading the input file from which words are taken.
     */
    public static void createArrayList (ArrayList <String> arrayList, Scanner keyIn) {
        // Verifies if a next word exists.
        while (keyIn.hasNext()) {
            // Reads word and cleans it from characters/numbers.
            String word = keyIn.next();
            word = cleanWord(word);

            // Verifies the word is not null and isn't duplicate before storing it in the ArrayList.
            if (word != null && !arrayList.contains(word)) {
                arrayList.add(word);
            }
        }
    }

    /**
     * Writes the sub-dictionary in the output file.
     *
     * @param arrayList Array List of Type String. Used to store the words in the sub-dictionary.
     * @param writer PrintWriter used to write the Strings stored in the Array List to the output file.
     */
    public static void printArrayList(ArrayList <String> arrayList, PrintWriter writer) {
        writer.println("The document produced this sub-dictionary, which includes " + arrayList.size() + " entries.");

        for (int i=0; i<arrayList.size()-1; i++) {
            // Prints the heading for a new letter division in the sub-dictionary.
            if (i == 0) {
                writer.println("\n" + arrayList.get(0).charAt(0));
                writer.println("--");
                writer.println(arrayList.get(0));
            }
            // Prints the words in the output file and creates new letter section when needed.
             if (i > 0) {
                 writer.println(arrayList.get(i));
                 try {
                     if (arrayList.get(i).charAt(0) != arrayList.get(i+1).charAt(0)) {
                         writer.println("\n" + arrayList.get(i+1).charAt(0));
                         writer.println("--");
                     }
                 } catch (IndexOutOfBoundsException e) {
                     System.out.println("Error: Index out of bounds.");
                 }
             }
        }
        // Prints last word section skipped inside the for loop.
        writer.println(arrayList.get(arrayList.size()-1));
    }

}
