/*
Kevin Estrada Dominguez (40076515) - Salahddin Warid (40191626)
Course: COMP249
Assignment #1
Due Date: 18 July 2021
*/

import p1.*;
import p2.*;
import p3.*;
import p4.*;


public class Main {

    public static void main(String[] args) {

        //Testing default constructors
/*      PublicTransportation publicTransportation_0 = new PublicTransportation();
        CityBus cityBus_0 = new CityBus();
        Metro metro_0 = new Metro();
        Tram tram_0 = new Tram();
        Ferry ferry_0 = new Ferry();
        AirCraft aicraft_0 = new AirCraft();
*/

/*
        System.out.println(public_transportation_0);
        System.out.println();
        System.out.println(city_bus_0);
        System.out.println();
        System.out.println(metro_0);
        System.out.println();
        System.out.println(tram_0);
        System.out.println();
        System.out.println(ferry_0);
        System.out.println();
        System.out.println(aicraft_0);
*/

        PublicTransportation public_transportation_1 = new PublicTransportation(100,20);
        PublicTransportation public_transportation_2 = new PublicTransportation(150,10);
//        PublicTransportation public_transportation_3 = new PublicTransportation(public_transportation_1);

/*      System.out.println(public_transportation_1);
        System.out.println(public_transportation_2);
        System.out.println(public_transportation_1.equals(public_transportation_2));
        System.out.println(public_transportation_3.equals(public_transportation_1));
*/

        CityBus city_bus_1 = new CityBus(50,30,1800,1998,"SPN Bus","Domingo");
        CityBus city_bus_2 = new CityBus(50,30,1800,1998,"SPN bus","Domingo");
//        CityBus city_bus_3 = new CityBus(city_bus_1);


/*      System.out.println(city_bus_1);
        System.out.println(city_bus_2);
        System.out.println(city_bus_1.equals(city_bus_2));
        System.out.println(city_bus_3.equals(city_bus_1));
*/

        Metro metro_1 = new Metro(25.9,70,1000,2010,"Exa Line","Sam and Yas",5,"Montreal");
        Metro metro_2 = new Metro(60,35,1000,2010,"Exa Line","Sam and Yas",5,"Montreal");
        Metro metro_3 = new Metro(5.15,25,1000,2010,"Exa Line","Sam and Yas",5,"Montreal");

/*      System.out.println(metro_1);
        System.out.println(metro_2);
        System.out.println(metro_1.equals(metro_2));
        System.out.println(metro_3.equals(metro_1));
*/

        Tram tram_1 = new Tram(10,30,1800,1998,"SPN Bus","Domingo",10000);
        Tram tram_2 = new Tram(8.50,30,1800,1998,"SPN Bus","Domingo",10000);
        Tram tram_3 = new Tram(21.45,30,1800,1998,"SPN Bus","Domingo",10000);
        
/*      System.out.println(tram_1);
        System.out.println(tram_2);
        System.out.println(tram_1.equals(tram_2));
        System.out.println(tram_3.equals(tram_1));
*/

        Ferry ferry_1 = new Ferry(14,100,2105,"Alexander");
        Ferry ferry_2 = new Ferry(7.60,100,2005,"Alexander");
        Ferry ferry_3 = new Ferry(420,100,2005,"Alexander");

 /*     System.out.println(ferry_1);
        System.out.println(ferry_2);
        System.out.println(ferry_1.equals(ferry_2));
        System.out.println(ferry_3.equals(ferry_1));

        ferry_1.setShip_name("Neymar");
        System.out.println(ferry_1.toString());
        System.out.println(ferry_1.getShip_name());
  */
        AirCraft aicraft_1 = new AirCraft(14,100, AirCraft.classType.Airline,AirCraft.maintenanceType.Yearly);
        AirCraft aicraft_2 = new AirCraft(34,100,AirCraft.classType.Ballon,AirCraft.maintenanceType.Yearly);
        AirCraft aicraft_3 = new AirCraft(240,100,AirCraft.classType.Ballon,AirCraft.maintenanceType.Yearly);

/*      System.out.println(aicraft_1);
        System.out.println(aicraft_2);
        System.out.println(aicraft_1.equals(aicraft_2));
        System.out.println(aicraft_3.equals(aicraft_1));

        aicraft_3.setClass_type(AirCraft.classType.Helicopter);
        aicraft_3.setMaintenance_type(AirCraft.maintenanceType.Monthly);
        System.out.println(aicraft_3.toString());
 */

        PublicTransportation[] array = new PublicTransportation[15];

        array[0] = public_transportation_1;
        array[1] = public_transportation_2;
        array[2] = city_bus_1;
        array[3] = city_bus_2;
        array[4] = metro_1;
        array[5] = metro_2;
        array[6] = metro_3;
        array[7] = tram_1;
        array[8] = tram_2;
        array[9] = tram_3;
        array[10] = ferry_1;
        array[11] = ferry_2;
        array[12] = ferry_3;
        array[13] = aicraft_1;
        array[14] = aicraft_2;

        lowerPrice(array);
        System.out.println();
        higherPrice(array);

        PublicTransportation[] array_2 = new PublicTransportation[12];

        array_2[0] = public_transportation_1;
        array_2[1] = public_transportation_2;
        array_2[2] = city_bus_1;
        array_2[3] = city_bus_2;
        array_2[4] = metro_1;
        array_2[5] = metro_2;
        array_2[6] = metro_3;
        array_2[7] = tram_1;
        array_2[8] = tram_2;
        array_2[9] = ferry_1;
        array_2[10] = aicraft_2;
        array_2[11] = ferry_2;

        PublicTransportation[] copy_array = copyCityBus(array_2);
        //Print the results
        for (PublicTransportation publicTransportation : array_2) System.out.println(publicTransportation);
        System.out.println();
        for (PublicTransportation publicTransportation : copy_array) System.out.println(publicTransportation);
        //We notice that the copying is working properly, since we used class comparisons in our method copyCityBus
        //to determine which constructor to use instead of using the "instanceof" comparison.
        //So, the copying is correct.

    }

    /**
     * Compares the Prices of tickets attributes in an array of PublicTransportation objects. Gives back the lowest value
     * and it's index on the array.
     *
     * @param array
     */
    public static void lowerPrice(PublicTransportation[] array) {
        int k=0;
        double price = array[0].getTicket_price();
        for(int i=1; i<array.length; i++) {
            if (array[i].getTicket_price() < price) {
                price = array[i].getTicket_price();
                k = i;
            }
        }
        System.out.println(array[k]);
        System.out.println("Indexed at :" + k);
    }

    /**
     * Compares the Prices of tickets attributes in an array of PublicTransportation objects. Gives back the highest value
     * and it's index on the array.
     *
     * @param array
     */
    public static void higherPrice(PublicTransportation[] array) {
        int k=0;
        double price = array[0].getTicket_price();
        for(int i=1; i<array.length; i++) {
            if (array[i].getTicket_price() > price) {
                price = array[i].getTicket_price();
                k = i;
            }
        }
        System.out.println(array[k]);
        System.out.println("Indexed at: " + k);
    }

    /**
     * Takes a PublicTransportation type array and copies every object to a new PublicTransportation type array.
     * This method compares the type of Public transport from every object individually, and uses the copy constructor
     * for every respective object type. This avoids any system errors when copying classes.
     *
     * @param array
     * @return Copy of parameter "array"
     */
    public static PublicTransportation[] copyCityBus(PublicTransportation[] array){
        PublicTransportation[] temp = new PublicTransportation[array.length];

        for (int i = 0; i< array.length; i++){
            if (array[i].getClass() == Tram.class)
                temp[i] = new Tram((Tram) array[i]);
            else if (array[i].getClass() == Metro.class)
                temp[i] = new Metro((Metro) array[i]);
            else if (array[i].getClass() == CityBus.class)
                temp[i] = new CityBus((CityBus) array[i]);
            else if (array[i].getClass() == Ferry.class)
                temp[i] = new Ferry((Ferry) array[i]);
            else if (array[i].getClass() == AirCraft.class)
                temp[i] = new AirCraft((AirCraft) array[i]);
            else if (array[i].getClass() == PublicTransportation.class)
                temp[i] = new PublicTransportation((PublicTransportation) array[i]);
            else
                temp[i] = null;

        }

        return temp;
    }


}
