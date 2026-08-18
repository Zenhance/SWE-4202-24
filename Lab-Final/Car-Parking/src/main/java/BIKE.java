public class BIKE extends Vehicle{
    public BIKE(String plate, Discount discount, int hours, slotsType slot){
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
        return 5;
    }
}
