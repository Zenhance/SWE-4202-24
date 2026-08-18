public abstract class Vehicle {
    private String registration;
    private String permit;


    public Vehicle(String registration, String permit) {
        this.registration = registration;
        this.permit = permit;
    }

    public String getRegistration() {
        return registration;
    }

    public String getPermit() {
        return permit;
    }

    public abstract VehicleType getType();

    public abstract boolean canPark(SlotType slotType);
}
