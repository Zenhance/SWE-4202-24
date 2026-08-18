package Slots;

public class Regular extends Slot{
    private int count;
    public int firstHour=50;
    public int regularHour=40;
    public int surcharge=25;
    public int slotsAvailable(){
        return count;
    }

    public void set(int x){
        count=x;
    }

}

