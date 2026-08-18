package src.main.java;

public class Discount {

    private Slot slot;

    public Discount(Slot slot){
    if(slot == null)
        throw new IllegalArgumentException("Slot can't be null");
    this.slot = slot;
    }
}
