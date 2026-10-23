
public abstract class Slot {

    private Vehicle occupant = null;

    /** The word this kind of slot is known by: BIKE, REGULAR or LARGE. */
    public abstract String type();

    /** What this slot charges for the first hour. */
    protected abstract int firstHourFare();

    /** What this slot charges for every hour after the first. */
    protected abstract int furtherHourFare();

    /** What this slot charges, once, for holding a vehicle that belongs in another kind. */
    protected abstract int surcharge();

    public final boolean isFree() {
        return occupant == null;
    }

    public final Vehicle occupant() {
        return occupant;
    }

    final void take(Vehicle vehicle) {
        this.occupant = vehicle;
    }

    final void release() {
        this.occupant = null;
    }

    /**
     * The bill for standing here the given number of hours: this slot's rates, this slot's
     * surcharge if the vehicle belongs somewhere else, and then the vehicle's own scheme.
     */
    public final int billFor(int hours) {
        int bill = firstHourFare() + (hours - 1) * furtherHourFare();
        if (!type().equals(occupant.preferredSlot())) {
            bill = bill + surcharge();
        }
        return occupant.afterDiscount(bill);
    }
}
