/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stations;

public abstract class Station implements Comparable{
    protected String address;

    protected Station(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "At address: " + address;
    }
    
}
