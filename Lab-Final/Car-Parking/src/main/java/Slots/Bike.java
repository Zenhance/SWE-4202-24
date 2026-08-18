package Slots;

public class Bike extends Slot{
    int count;
    public int firstHour=10;
    public int regularHour=5;
    public int surcharge=0;
    int slotsAvailable(){
        return count;
    }
}
