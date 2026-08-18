package Slots;

import java.util.ArrayList;

public class Large extends Slot{
    public static int count;
    public ArrayList l = new ArrayList<>();
    public int firstHour=30;
    public int regularHour=20;
    public int surcharge=15;
    public Large(String s){
        l.add(s);
    }
    int slotsAvailable(){
        return count;
    }

}

