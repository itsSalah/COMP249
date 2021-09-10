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

/**
 * TestClass corresponds to a Test Class with its own main.
 * This method is used to make sure all desired functionalities work during runtime.
 *
 */
public class TestClass {

    public static void main(String[] args) {
        //Following part is commented on CellListUtilization:
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String[] input_array; CellList myLinkedList = new CellList();long serialNum,input; String brand;
        int year,count=0; double price; ArrayList<Long> serialNum_array = new ArrayList<Long>();

        System.out.println("WARNING: MAIN FOR TESTING PURPOSES.");
        System.out.println();
        // Check for error signal in the form of FilesNotFound
        try {
            // Initializing scanner and verifying the existence of data inside the .txt file.
            Scanner in = new Scanner(new FileReader("Cell_Info.txt"));
            while(in.hasNextLine()){
                input_array = in.nextLine().split("\\s+");
                serialNum = Long.parseLong(input_array[0]);

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
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //We will test features of the CellPhone class
        CellPhone testPhone = new CellPhone(11111,"Custom",2000,456);
        CellPhone testPhone2 = new CellPhone(testPhone,11111112);
        CellPhone testPhone3 = new CellPhone(11111,"Bad",2000,456);

        //verify equal method
        System.out.println(testPhone.equals(testPhone2)); //Which is true
        System.out.println(testPhone.equals(testPhone3)); //Which is false

        //Verify if the copy constructor provides a deep copy
        testPhone2.setPrice(1000);
        System.out.println(testPhone.equals(testPhone2)); //Now false, so the copy is deep.

        //Verify the clone method
        CellPhone testPhone4 = testPhone.clone(95324121);
        System.out.println(testPhone4); // Checking toString and proper output.
        System.out.println(testPhone.equals(testPhone4));//Which is true
        testPhone4.setPrice(1000);
        System.out.println(testPhone.equals(testPhone4));//Which is becomes false, so it is a deep copy.


        //CellPhone testPhone3 = new CellPhone(null,100002);  Exception is thrown when trying to pass empty object.
        //CellPhone testPhone3 = new CellPhone(testPhone2,-100002); Incorrect serial number error is thrown.
        //CellPhone(long serialNum, String brand, int year, double price)
        //CellPhone testPhone20 = new CellPhone(-11111,null,-2000,-456); error will be thrown as long as all these
        //wrong parameters aren't changed.

        //We will test all the methods that needed to be implemented for the linked list.
        //addToStart()
        myLinkedList.showContents();
        myLinkedList.addToStart(testPhone);
        System.out.println("\n");
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        myLinkedList.addToStart(testPhone2);
        System.out.println();
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        //Working as expected.

        //insertAtIndex()
        CellPhone testPhone5 = new CellPhone(11550,"InsertAtIndex",2020,550);
        System.out.println();
        myLinkedList.insertAtIndex(testPhone5,25); //We can try multiple values between 0 and 25
        //(the size of the list) inclusively and they all work as expected.
        //myLinkedList.insertAtIndex(testPhone5,28); //Throws an error for invalid index.
        //myLinkedList.insertAtIndex(null,25); //Throws and error for empty data.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        //Working as expected. Added the functionality to insert an element to append the list.

        //deleteFromIndex()
        myLinkedList.deleteFromIndex(25);
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize()); //We deleted the last element and the size updates properly.
        //myLinkedList.deleteFromIndex(25); //Index now out of bound.
        System.out.println();
        myLinkedList.deleteFromIndex(0); //We removed the first element.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());

        System.out.println();
        myLinkedList.deleteFromIndex(2); //We removed the third element.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        //myLinkedList.deleteFromIndex(-1); //Index out of bound error.
        //Everything is working as intended.

        //replaceAtIndex()
        CellPhone cellPhone6 = new CellPhone(11550,"Replaced",2020,550);
        System.out.println();
        myLinkedList.replaceAtIndex(cellPhone6,2); //We replaced the third element.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        System.out.println();
        myLinkedList.replaceAtIndex(cellPhone6,22); //We replaced the last element.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        System.out.println();
        myLinkedList.replaceAtIndex(cellPhone6,0); //We replaced the first element.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        //myLinkedList.replaceAtIndex(cellPhone6,24); //Index out of bound error.
        //myLinkedList.replaceAtIndex(cellPhone6,-1); //Index out of bound error.
        //Everything is working as intended.


        //deleteFromStart()
        System.out.println();
        myLinkedList.deleteFromStart(); //We removed the first element.
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        CellList secondList = new CellList();
        secondList.addToStart(testPhone);
        secondList.showContents();
        System.out.println();
        System.out.println(secondList.getSize());
        secondList.deleteFromStart();
        secondList.showContents();
        System.out.println();
        System.out.println(secondList.getSize());
        //Simple method that works as expected.

        //find() and contains()
        System.out.println();
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        myLinkedList.find(2787985); //The list is of size 22, we searched for the 21st member. Working.
        System.out.println();
        System.out.println(myLinkedList.contains(2787985));//Has the find() output and returns boolean.
        System.out.println();
        myLinkedList.find(-1); //Can't find the incorrect serial number.
        System.out.println();
        System.out.println(myLinkedList.contains(-1));
        System.out.println();
        myLinkedList.find(1119000); //Searching for the first element. Working.
        System.out.println();
        System.out.println(myLinkedList.contains(1119000));
        //Working as expected.

        //showContents has been used extensively, so this is the only test case we make here:
        CellList showContentTest = new CellList();
        showContentTest.showContents(); //Only return the X since there are no element in the list.
        //Working as expected.

        //Testing the copy constructor of the linked list and the clone to see if they give deep copies.
        System.out.println();
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        System.out.println();

        CellList myLinkedList_copyClone = myLinkedList.clone();
        myLinkedList_copyClone.showContents();
        System.out.println();
        System.out.println(myLinkedList_copyClone.getSize());
        System.out.println(myLinkedList.equals(myLinkedList_copyClone));//Returning true as expected.

        System.out.println();
        myLinkedList_copyClone.deleteFromStart();
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        System.out.println();
        myLinkedList_copyClone.showContents();
        System.out.println();
        System.out.println(myLinkedList_copyClone.getSize());
        System.out.println(myLinkedList.equals(myLinkedList_copyClone));//Returning false as expected from deep copies.
        //The clone method returns a deep copy of the linkedlist.

        //Now testing the copy constructor
        CellList myLinkedList_copyCons = new CellList(myLinkedList);
        System.out.println();
        myLinkedList.showContents();
        System.out.println();
        System.out.println(myLinkedList.getSize());
        System.out.println();
        myLinkedList_copyCons.showContents();
        System.out.println();
        System.out.println(myLinkedList_copyCons.getSize());
        System.out.println();
        System.out.println(myLinkedList.equals(myLinkedList_copyCons)); //Returning true as expected.
        myLinkedList_copyCons.addToStart(testPhone);
        System.out.println(myLinkedList.equals(myLinkedList_copyCons)); //Returning false, because deep copy.
        //The copy constructor works as expected and provides a deep copy of the object.

        //END OF THE TESTING CLASS.
    }
}
