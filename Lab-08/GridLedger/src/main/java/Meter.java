public class Meter {
    private int openingUnits;
    private int closingUnits;
    public Meter(int openingUnits, int closingUnits){
        if((openingUnits<0)||(closingUnits<0)){
            throw new IllegalArgumentException("Opening units and closing units cannot be negative");
        }
        if(closingUnits<openingUnits){
            throw new IllegalArgumentException("invalid");
        }
       this.openingUnits=openingUnits;
       this.closingUnits=closingUnits;


    }

    public int getOpeningUnits() {
        return openingUnits;
    }

    public int getClosingUnits() {
        return closingUnits;
    }

    public int getUnitsConsumed(){
     return closingUnits-openingUnits;
    }
}
