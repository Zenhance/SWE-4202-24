public class Meter{
    int p;
    int c;

    public Meter(int p, int c){
        if(p > c || p < 0 || c < 0)
            throw new IllegalArgumentException("Incorrect entries");
        this.p = p;
        this.c = c;
    }

    public int getUnitsConsumed(){return c-p;}
}