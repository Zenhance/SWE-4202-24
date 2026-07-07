public class Meter {
    int x,y;
    public Meter(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public int getUnitsConsumed() {
        return y-x;


    }
}
