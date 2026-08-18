package CarParking;

public final  class ParkingEntry {
    private final Vehicle vehicle;
            private final ParkingSlot slot;
            public ParkingEntry(Vehicle vehicle,ParkingSlot slot){
                this.vehicle=vehicle;
                this.slot=slot;
            }
            public Vehicle vehicle(){
                return vehicle;
            }
            public ParkingSlot slot(){
                return slot;
            }
}
