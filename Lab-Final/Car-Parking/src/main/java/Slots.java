package src.main.java;

public class Slots {
    Vehicle vehicle;
    SlotType type;

    public Slots(SlotType type){
        this.type=type;
         vehicle = null;
    }
    public boolean isFree(){
        return vehicle == null;
    }

}
