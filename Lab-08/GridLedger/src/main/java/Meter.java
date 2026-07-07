public class Meter {
    int opening;
    int closing;
    public Meter(int opening,int closing){
        if(opening<0)
            throw new IllegalArgumentException("Opening cannot be negative");
        if (closing<opening)
            throw new IllegalArgumentException("Closing cannot be smaller than opening");
        this.opening=opening;
        this.closing=closing;
    }
    public int getUnitsConsumed(){
        return closing-opening;
    }
}
