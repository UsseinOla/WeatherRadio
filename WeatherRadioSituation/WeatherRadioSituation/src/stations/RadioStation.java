/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stations;

public class RadioStation extends Station{
    private String code;
    private double freq;

    public RadioStation(String address, String code, double freq) {
        super(address);
        if(!isCodeValid(code))
            throw new IllegalArgumentException("Code is not valid!");
        if(!(freq >= 87.8 && freq <= 108) && !(freq >= 560 && freq <= 1610))
            throw new IllegalArgumentException("Frequency is not valid!");
        this.code = code;
        this.freq = freq;
    }
    /**
     * This method checks if the code is valid or not. 
     * It is valid if it is formed of 3 or 4 capital letters
     */
    private boolean isCodeValid(String code){
        if(code.length() < 3 || code.length() > 4)
            return false;
        return code.equals(code.toUpperCase());            
    }
    public boolean isFM(){
        return freq >= 87.8 && freq <= 108;
    }
    /**
     * This method checks if the caller RadioStation object and the one passed 
     * as parameter, are the same or not (same code and same frequency)
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof RadioStation)
            return code.equals(((RadioStation)o).code) && freq == ((RadioStation)o).freq;
        return false;
    }
    /**
     * This method compares two RadioStation objects according to their frequency
     */
    @Override
    public int compareTo(Object o){
        if(freq > ((RadioStation)o).freq)
            return 1;
        else if(freq < ((RadioStation)o).freq)
            return -1;
        else 
            return 0;
    }
    @Override
    public String toString(){
        String str = "[" + code + ", ";
        str += isFM() ? "FM " : "AM ";
        str += freq + "] " + super.toString();
        return str;
    }
}
