public abstract class Vehicle {
    private final String registration;
    private final String pass;
    private String assignedSlot;
    private int entryTime;
    private boolean oversized;
    public Vehicle(String registration, String pass) {
        this.registration = registration;
        this.pass = pass;
    }

}
