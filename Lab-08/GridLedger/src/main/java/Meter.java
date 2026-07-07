import com.sun.source.tree.BreakTree;

public class Meter {
    private int openingReading;
    private int closingReading;

    public Meter(int openingReading,int closeReading){
      if(openingReading< 0|| closingReading< 0){
          throw new IllegalArgumentException("Reading cant be negative");
      }
      if(closingReading<openingReading) {
          throw new IllegalArgumentException("closing reading cant be smaller");
      }
      this.openingReading=openingReading;
      this.closingReading=closeReading;
    }
    public int getOpeningReading(){
        return openingReading;
    }











}
