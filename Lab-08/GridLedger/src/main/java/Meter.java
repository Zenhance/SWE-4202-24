public class Meter {
    private final int opening;
    private final int closing;
    public Meter(int opening, int closing) {
        if (opening < 0) {
            throw new IllegalArgumentException("Opening reading cannot be negative");
        }
if(closing<opening){
    throw new IllegalArgumentException("Closing reading cannot be less than opening reading.");
}
        this.opening = opening;
        this.closing = closing;
    }


}
