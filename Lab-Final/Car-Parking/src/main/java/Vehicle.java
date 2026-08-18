abstract public class Vehicle {
    private String numPlate;
    private int hoursstood;
    private Slot currentslot;
    private Scheme scheme;
    public Vehicle(String numPlate,Scheme scheme){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.hoursstood=0;
    }

    public int getHoursstood() {
        return hoursstood;
    }

    public String getNumPlate() {
        return numPlate;
    }

    public Slot getCurrentslot() {
        return currentslot;
    }

    public Scheme getScheme() {
        return scheme;
    }
    public void addHours(int hours){
        hoursstood+=hours;
    }
    public abstract Slot[] prefferedorder();
    public Slot defaultslot(){
      return prefferedorder()[0];
    };
    public boolean isSurcharged(){
        return currentslot!=defaultslot();
    }

    public void setCurrentslot(Slot currentslot) {
        this.currentslot = currentslot;
    }
}
