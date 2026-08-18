public class TRUCK extends Vehicle{
    public TRUCK(String plate, Discount discount, int hours, slotsType slot){
        super(plate, discount, hours, slot);
    }
    public slotsType[] slots(){
        return new slotsType[]{
                slotsType.BIKE,
                slotsType.REGULAR,
                slotsType.LARGE
        };
    }
    public int hourlyRate(){
        return 50;
    }
}
