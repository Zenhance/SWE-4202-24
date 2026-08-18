public class Truck extends Vehicle{
    public Truck(String plate,Category category){
        super(plate,category);
    }
    @Override
    public slotType[] prefferedSlot() {
        return new slotType[]{
                slotType.LARGE
        };
    }
    @Override
    public int hourlyRate(){
        return 30;
    }
}