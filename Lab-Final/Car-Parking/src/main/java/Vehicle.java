abstract class Vehicle {
    final String plate;
    int hours;
    Discount discount;
    Slot slot;

    public Vehicle(String plate, Discount discount){
        this.plate = plate;
        this.discount = discount;
        hours = 0;
        slot = null;
    }
    public abstract SlotType[] getWantedSlots();
}
