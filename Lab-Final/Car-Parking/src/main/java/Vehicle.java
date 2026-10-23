public abstract class Vehicle {

    private final String plate;
    private final Discount scheme;
    private int hoursStood = 0;

    protected Vehicle(String plate, Discount scheme) throws InvalidVehicleException {
        if (plate == null || plate.isBlank()) {
            throw new InvalidVehicleException("a vehicle must have a number plate");
        }
        if (scheme == null) {
            throw new InvalidVehicleException("a vehicle must carry a discount scheme");
        }
        this.plate = plate;
        this.scheme = scheme;
    }

    public final String plate() {
        return plate;
    }

    public final int hoursStood() {
        return hoursStood;
    }

    /** Time passes. Hours can only be added, and only from here. */
    final void standFor(int hours) {
        this.hoursStood = this.hoursStood + hours;
    }

    /** The bill after this vehicle's own scheme. The scheme itself stays private. */
    public final int afterDiscount(int bill) {
        return scheme.apply(bill);
    }

    /**
     * The kinds of slot this vehicle will accept, best first. The first one is the kind it
     * belongs in; standing in any of the others costs that slot's surcharge.
     */
    public abstract String[] slotPreference();

    public final String preferredSlot() {
        return slotPreference()[0];
    }
}
