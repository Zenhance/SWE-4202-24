public class Meter {
    private int opening;
    private int closing;

    public Meter(int opening, int closing){
        if(opening<0){
            throw new IllegalArgumentException("Cannot be negative");
        }
        if(closing<0){
            throw new IllegalArgumentException("Cannot be negative");
        }
        this.opening=opening;
        this.closing=closing;
    }
    public int getUnitsConsumed(){
        return opening-closing;
    }
}
