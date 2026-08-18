public class SlotBooking {
    public slotsType slotType;
    public boolean isOccupied;
    private VehicleType vehicleType;
    public String regNum;
    public SlotBooking(slotsType slotType){
        this.slotType=slotType;
        this.isOccupied=false;
        this.regNum="";
    }


}
