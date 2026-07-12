public class Meter {
    private final int opening;
    private final int closing;

    public Meter(int opening, int closing){
        if(opening<0 || closing<0){
            throw new IllegalArgumentException("Meter readings can't be negative");
        }
        if(closing < opening){
            throw new IllegalArgumentException("Closing reading cannot be less than opening");
        }

        this.opening=opening;
        this.closing=closing;
    }

    public int getOpening() {
        return opening;
    }

    public int getClosing() {
        return closing;
    }

    public int getUnitsConsumed(){
        return closing-opening;
    }
}
