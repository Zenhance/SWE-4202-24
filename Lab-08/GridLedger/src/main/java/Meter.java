public class Meter {
    int startingunit;
    int endingunit;
    public Meter(int startingunit, int endingunit) {
        if(!(startingunit > endingunit)&&(startingunit>=0)&&(endingunit>=0)) {
            this.startingunit = startingunit;
            this.endingunit = endingunit;
        }
    }
    public int getStartingunit() {
        return startingunit;
    }
    public int getEndingunit() {
        return endingunit;
    }

    public int getUnitsConsumed() {
        return  endingunit - startingunit;
    }
}
