package Slots;

import java.util.ArrayList;

public class Regular extends Slot{
    private static int count;
    public int firstHour=50;
    public ArrayList r = new ArrayList<>();
    public int regularHour=40;
    public int surcharge=25;
    public int slotsAvailable(){
        return count;
    }
    public Regular(String s){
        r.add(s);
    }


}

