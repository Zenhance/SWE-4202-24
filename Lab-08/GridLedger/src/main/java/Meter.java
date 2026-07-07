public class Meter {
    private int opening_reading;
    private int closing_reading ;
    public Meter(int opening_reading ,int closing_reading){
        if(closing_reading<opening_reading){
            throw new IllegalArgumentException("not valid");
        }
        if(closing_reading<0){
            throw  new IllegalArgumentException("Not valid");
        }
        if(opening_reading<0) {
            throw new IllegalArgumentException("not valid");
        }
            this.opening_reading=opening_reading;
            this.closing_reading=closing_reading;
    }
    public int getOpening_reading(){
        return opening_reading;
    }
    public int getClosing_reading(){
        return closing_reading;
    }
    public int getUnitsConsumed(){
        return closing_reading-opening_reading;
    }




}
