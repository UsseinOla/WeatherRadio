/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stations;

public class WeatherStation extends Station{
    private int numOfVars;

    public WeatherStation(String address, int numOfVars) {
        super(address);
        this.numOfVars = numOfVars;
    }
    @Override
    public int compareTo(Object o){
        if(numOfVars > ((WeatherStation)o).numOfVars)
            return 1;
        else if(numOfVars < ((WeatherStation)o).numOfVars)
            return -1;
        else 
            return 0;
    }
    @Override
    public String toString() {
        return "WeatherStation{" + "numOfVars=" + numOfVars + "} " + super.toString();
    }
}
