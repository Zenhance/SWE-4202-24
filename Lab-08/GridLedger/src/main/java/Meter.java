public class Meter {
    protected int currentMeter;
    protected int previousMeter;


    public Meter(int currentMeter, int previousMeter) {
        if (currentMeter == 0 || previousMeter == 0) {
            throw new IllegalArgumentException("Meters can't be negative");
        }
        this.currentMeter = currentMeter;
        this.previousMeter = previousMeter;
    }
    protected int units = currentMeter - previousMeter;
    public int getCurrentMeter() {
        return currentMeter;
    }

    public int getPreviousMeter() {
        return previousMeter;
    }
}







































