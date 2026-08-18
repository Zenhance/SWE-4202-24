public class SlotBooking {
    private slots slotype;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private String regNum;
    public SlotBooking(slots slotype, String regNum){
        this.slotype=slotype;
        this.isOccupied=false;
        this.regNum=regNum;
    }


}
