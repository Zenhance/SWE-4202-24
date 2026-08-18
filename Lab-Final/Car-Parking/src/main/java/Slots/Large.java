package Slots;

public class Large extends Slot{
    public int count;
    public int firstHour=30;
    public int regularHour=20;
    public int surcharge=15;
    int slotsAvailable(){
        return count;
    }

    public void set(int x){
        count=x;
    }
}

