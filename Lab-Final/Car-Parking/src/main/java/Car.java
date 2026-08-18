package parking;
public class Car extends Vehicle{
    public Car(String registration,String permit) {
        super(registration, permit);
    }
 @Override
 public VehicleType getType(){
        return VehicleType.CAR;
 }
 @Override
    public boolean canPark(SlotType slotType){
        return slotType == SlotType.REGULAR
                ||slotTYpe == SlotType.LARGE;
 }
}
