package parking;
public class Bike extends Vehicle{
    public Bike(String registration,String permit){
        super(registration,permit);
    }
 @Override
 public VehicleType getType() {
        return VehicleType.BIKE;
 }
 @Override
    public boolean canPark(SlotType slotType){
        return slotType == SlotType.BIKE
                ||slotType == SlotType.Regular;
 }

}
