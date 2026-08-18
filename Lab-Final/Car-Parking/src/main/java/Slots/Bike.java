package Slots;

import java.util.ArrayList;

public class Bike extends Slot{
    private static int count;
    public ArrayList b = new ArrayList<>();
    public int firstHour=10;
    public int regularHour=5;
    public int surcharge=0;
    public int slotsAvailable(){
        return count;
    }
    public Bike(String s){
        b.add(s);
    }

}
