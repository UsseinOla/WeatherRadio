/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stations;
import java.util.*;
public class Region {
    private ArrayList stations;
    public Region() {
        stations = new ArrayList();
    }
    public void addRadioStation(RadioStation r){
        boolean found = false;
        for(int i = 0; i < stations.size(); i++)
            //Checking if r exists in the arraylist
            if(stations.get(i) instanceof RadioStation && r.equals(stations.get(i))){
                found = true;
                break;
            }
        if(found)
            System.out.println(r + " already exists!");
        else
            stations.add(r);
    }
    public void addWeatherStation(WeatherStation w){
        stations.add(w);
    }
    public ArrayList getStations(){
        return stations;
    }
    @Override
    public String toString(){
        String str = "The stations in this region are: \n";
        for(int i = 0; i < stations.size(); i++)
            str += stations.get(i) + "\n";
        return str;
    }
}
