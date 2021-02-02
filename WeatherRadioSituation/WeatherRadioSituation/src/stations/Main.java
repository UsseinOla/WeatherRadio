/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stations;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanLines = new Scanner(System.in);
        Region r = new Region();
        while(true){
            System.out.println("Choose from the following menu:\n1. Add Radio Station\n2. Add Weather Station\n3. Exit");
            try{
                int choice = scan.nextInt();
                if(choice == 3)
                    break;
                System.out.print("Enter Address: ");
                String address =scanLines.nextLine();
                switch(choice){
                    case 1: System.out.print("Enter code (3 or 4 capital letters) and frequency: ");
                        r.addRadioStation(new RadioStation(address, scan.next(), scan.nextDouble()));
                        break;
                    case 2: System.out.print("Enter number of variables: ");
                        r.addWeatherStation(new WeatherStation(address, scan.nextInt()));
                        break;
                    default: System.out.println("Invalid Input!");
                }//end switch
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            catch(InputMismatchException ex){
                System.out.println(ex);
            }
        }//end while loop
        ArrayList list = r.getStations();
        //Display the FM radio stations
        displayFM(list);  
        
        //Get the array of weather stations and sort them: Sorting is done according 
        //to the number of variables (according to the implementation of compareTo)        
        WeatherStation[] wStations = getWeatherStations(list);
        Arrays.sort(wStations);
        
        System.out.println("\nThe weather station with the largest number of variables is: ");
        System.out.println(wStations[wStations.length - 1]);
    }//end main
    
    /**
     * This method takes as parameter an arraylist and displays all FM radio stations
     */
    public static void displayFM(ArrayList list){
        System.out.println("The FM radio stations are: ");
        for(int i = 0; i < list.size(); i++)
            if(list.get(i) instanceof RadioStation && ((RadioStation)list.get(i)).isFM())
                System.out.println(list.get(i));
    }
    
    /**
     * This method takes as parameter an ArrayList and returns an array of type 
     * WeatherStation that contains all WeatherStation objects found in the arraylist
     */
    public static WeatherStation[] getWeatherStations(ArrayList list){
        int j = 0; 
        //copying the WeatherStation objects from the arraylist into an array
        //of same size as the arraylist
        WeatherStation[] temp = new WeatherStation[list.size()]; 
        for(int i = 0; i < list.size(); i++)
            if(list.get(i) instanceof WeatherStation)
                temp[j++] = (WeatherStation)list.get(i);
        //Creating an array of size equal the number of WeartherStation objects 
        //found and copying the objects to it from the array temp
        WeatherStation[] wStations = new WeatherStation[j];
        System.arraycopy(temp, 0, wStations, 0, j);
        return wStations;  
    }
}
