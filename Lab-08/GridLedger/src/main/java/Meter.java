public class Meter {
    private int opening;
    private int closing;

    public Meter(int opening, int closing){
        if (opening<0 || closing<0 )
            throw new IllegalArgumentException("Error");
        if (opening>closing)
            throw new IllegalArgumentException("Error");
        this.opening = opening;
        this.closing = closing;
    }

    public int getUnitsConsumed(){
        int units;
        units = opening - closing;
    return units;
    }
}
