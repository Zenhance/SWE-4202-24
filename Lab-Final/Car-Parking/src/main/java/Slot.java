package src.main.java;

public class Slot {
    Vehicle vehicle;
    SlotType type;

    public Slot(SlotType type){
        this.type=type;
         vehicle = null;
    }
    public boolean isFree(){
        return vehicle == null;
    }

}
