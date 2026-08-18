public class SlotBooking {
    private slotsType slotype;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private String regNum;
    public SlotBooking(slotsType slotype, String regNum){
        this.slotype=slotype;
        this.isOccupied=false;
        this.regNum=regNum;
    }


}
